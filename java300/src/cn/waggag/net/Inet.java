package cn.waggag.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inet {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostName());
		System.out.println(addr.getHostAddress());
		//���������õ�InetAddress
		addr = InetAddress.getByName("www.baidu.com");
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		//����ip�õ�InetAddress
		addr = InetAddress.getByName("192.168.168.168");
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
	
	}
}
