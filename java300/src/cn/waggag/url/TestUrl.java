package cn.waggag.url;

import java.net.MalformedURLException;
import java.net.URL;

public class TestUrl {
	
	public static void main(String[] args) throws MalformedURLException {
		
		URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=waggag");
		System.out.println("协议:"+url.getProtocol());
		
		//绝对路径
		url = new URL("http://www.baidu.com:80/a/");
		//相对路径
		url = new URL(url,"/b.txt");
		System.out.println(url.toString());
		
	}
}
