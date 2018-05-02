package cn.waggag.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 封装请求信息
 * @author wagga
 * 2018年4月21日 下午5:49:38
 */
public class Request {
	//请求方式
	private String method;
	//请求资源
	private String url;
	
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}

	//请求参数
	private Map<String ,List<String>> parameterMapValue;
	
	//内部需要
	private static final String CRLF = "\r\n";
	
	@SuppressWarnings("unused")
	private InputStream is;
	private String requestInfo;
	
	public Request(){
		method = "";
		url = "";
		parameterMapValue = new HashMap<String ,List<String>>();
		requestInfo = "";
	}
	public Request(InputStream is){
		this();
		this.is = is;
		//得到所有的请求信息
		try {
			byte[] data = new byte[204800];
			int len = is.read(data);
			requestInfo = new String(data, 0, len);
		} catch (IOException e) {
			//e.printStackTrace();
			return ;
		}
		//分析头信息
		parseRequestInfo();	
	}
	
	
	private void parseRequestInfo() {
		
		if(requestInfo == null || (requestInfo = requestInfo.trim()).equals(""))
		{
			return ;
		}
		/**========================================
		 * 从信息的首行分解出：请求方式 请求路径 请求参数（get可能存在）
		 * GET /index.html?uname=ssjjh&pwd=sdg HTTP/1.1
		 * 
		 * 如果为post,请求参数可能在正文
		 * ==========================================
		 */
		String paramString = "";//接收请求参数
		//1.获取请求方式
		String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
		int idx = requestInfo.indexOf("/");
		this.method = firstLine.substring(0, idx).trim();
		String urlStr = firstLine.substring(idx, firstLine.indexOf("HTTP/")).trim();
		if(this.method.equalsIgnoreCase("post"))
		{
			this.url = urlStr;
			paramString = requestInfo.substring(requestInfo.lastIndexOf("HTTP/")).trim();
		}else if(this.method.equalsIgnoreCase("get")) {
			if(urlStr.contains("?"))
			{
				String[] urlArray = urlStr.split("\\?");
				this.url = urlArray[0];
				paramString = urlArray[1];
				
			}else {
				this.url = urlStr;
			}
		}
		
		//不存在请求参数
		if(paramString.equals("")) {
			return ;
		}
		parseParams(paramString);
	}
	
	//2.将请求参数封装到Map中
	private void parseParams(String paramString)
	{
		//分割字符串，将字符串转为数组
		StringTokenizer toker = new StringTokenizer(paramString, "&");
		
		while(toker.hasMoreTokens()) {
			
			String keyValue = toker.nextToken();
			String[] keyValues = keyValue.split("=");
			//如果keyValue的长度为1的话，拷贝
			if(keyValues.length == 1) {
				keyValues = Arrays.copyOf(keyValues, 2);
				keyValues[1] = null;
			}
			
			//转换成Map，根据key存放Value
			String key = keyValues[0].trim();
			//编码方式的输入一定要正确，不然会返回一个null
			String value = null==keyValues[1]?null:decode((keyValues[1].trim()),"gbk");
			//不存在，放进去一个
			if(!parameterMapValue.containsKey(key));
			{
				parameterMapValue.put(key, new ArrayList<String>());
			}
			
			List<String> values = parameterMapValue.get(key);
			values.add(value);
		}
	}
	
	/**
	 * 根据页面的name获取对应的值,返回一个字符串数组
	 */
	@SuppressWarnings("unused")
	public String[] getParameterValues(String name)
	{
		List<String> values = null;
		if((values=parameterMapValue.get(name)) == null) {
			return null;
		}else {
			return parameterMapValue.get(name).toArray(new String[0]);
		}
	}
	/**
	 * 根据页面的name获取对应的值,返回一个字符串
	 */
	public String getParameter(String name)
	{
		String[] values = getParameterValues(name);
		if(null == values) {
			return null;
		}
		return values[0];
	}
	/**
	 * 解决中文的问题
	 */
	private String decode(String value, String code) {
		try {
			return URLDecoder.decode(value, code);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
