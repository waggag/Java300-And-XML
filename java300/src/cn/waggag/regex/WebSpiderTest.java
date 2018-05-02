package cn.waggag.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 网络爬虫取链接
 * @author waggag
 * 2018年4月29日 下午4:44:14
 */
public class WebSpiderTest {
	
	/**
	 * 获得URl对应的网页源码的内容
	 */
	public static String getUrlContent(String urlStr, String charset) {
		
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlStr);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName(charset)));
			String temp = "";
			while((temp = reader.readLine()) != null){
				sb.append(temp);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return sb.toString();
	}
	
	public static List<String> getMatherSubstrs(String destStr, String regexStr){
		
		Pattern p = Pattern.compile(regexStr);
		Matcher m = p.matcher(destStr);
		
		List<String> result = new ArrayList<String>();
		
		while(m.find())
		{
			result.add(m.group(1));
		}
		return result;
	}
		
	public static void main(String[] args) {
		String destStr = getUrlContent("https://www.csdn.net/", "gbk");
		System.out.println(destStr);
		
		//<a href="home.php">空间</a>
		//Pattern p = Pattern.compile("<a[\\s\\S]+?</a>");
		
		//Pattern p = Pattern.compile("href=\"(.+?)\"");
		List<String> result = getMatherSubstrs(destStr, "href=\"([\\w\\s./:]+?)\"");
		for(String temp: result) {
			System.out.println(temp);
		}
	}
}
