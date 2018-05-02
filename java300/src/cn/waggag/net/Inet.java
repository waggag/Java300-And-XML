package cn.waggag.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inet {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostName());
		System.out.println(addr.getHostAddress());
		//根据域名得到InetAddress
		addr = InetAddress.getByName("www.baidu.com");
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		//根据ip得到InetAddress
		addr = InetAddress.getByName("192.168.168.168");
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
	
	}
}
