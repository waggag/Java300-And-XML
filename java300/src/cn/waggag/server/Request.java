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
 * ��װ������Ϣ
 * @author wagga
 * 2018��4��21�� ����5:49:38
 */
public class Request {
	//����ʽ
	private String method;
	//������Դ
	private String url;
	
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}

	//�������
	private Map<String ,List<String>> parameterMapValue;
	
	//�ڲ���Ҫ
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
		//�õ����е�������Ϣ
		try {
			byte[] data = new byte[204800];
			int len = is.read(data);
			requestInfo = new String(data, 0, len);
		} catch (IOException e) {
			//e.printStackTrace();
			return ;
		}
		//����ͷ��Ϣ
		parseRequestInfo();	
	}
	
	
	private void parseRequestInfo() {
		
		if(requestInfo == null || (requestInfo = requestInfo.trim()).equals(""))
		{
			return ;
		}
		/**========================================
		 * ����Ϣ�����зֽ��������ʽ ����·�� ���������get���ܴ��ڣ�
		 * GET /index.html?uname=ssjjh&pwd=sdg HTTP/1.1
		 * 
		 * ���Ϊpost,�����������������
		 * ==========================================
		 */
		String paramString = "";//�����������
		//1.��ȡ����ʽ
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
		
		//�������������
		if(paramString.equals("")) {
			return ;
		}
		parseParams(paramString);
	}
	
	//2.�����������װ��Map��
	private void parseParams(String paramString)
	{
		//�ָ��ַ��������ַ���תΪ����
		StringTokenizer toker = new StringTokenizer(paramString, "&");
		
		while(toker.hasMoreTokens()) {
			
			String keyValue = toker.nextToken();
			String[] keyValues = keyValue.split("=");
			//���keyValue�ĳ���Ϊ1�Ļ�������
			if(keyValues.length == 1) {
				keyValues = Arrays.copyOf(keyValues, 2);
				keyValues[1] = null;
			}
			
			//ת����Map������key���Value
			String key = keyValues[0].trim();
			//���뷽ʽ������һ��Ҫ��ȷ����Ȼ�᷵��һ��null
			String value = null==keyValues[1]?null:decode((keyValues[1].trim()),"gbk");
			//�����ڣ��Ž�ȥһ��
			if(!parameterMapValue.containsKey(key));
			{
				parameterMapValue.put(key, new ArrayList<String>());
			}
			
			List<String> values = parameterMapValue.get(key);
			values.add(value);
		}
	}
	
	/**
	 * ����ҳ���name��ȡ��Ӧ��ֵ,����һ���ַ�������
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
	 * ����ҳ���name��ȡ��Ӧ��ֵ,����һ���ַ���
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
	 * ������ĵ�����
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
