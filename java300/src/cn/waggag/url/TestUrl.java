package cn.waggag.url;

import java.net.MalformedURLException;
import java.net.URL;

public class TestUrl {
	
	public static void main(String[] args) throws MalformedURLException {
		
		URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=waggag");
		System.out.println("Э��:"+url.getProtocol());
		
		//����·��
		url = new URL("http://www.baidu.com:80/a/");
		//���·��
		url = new URL(url,"/b.txt");
		System.out.println(url.toString());
		
	}
}
