package cn.waggag.net;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 封装端口:在InetAddress基础上 + 端口
 * @author waggag
 * 2018年4月19日 下午8:56:55
 */
public class InetSocke {
	
	public static void main(String[] args) {
		InetSocketAddress address = new InetSocketAddress("192.168.64.1",9999);
		System.out.println(address.getHostName());
		System.out.println(address.getPort());
		InetAddress add = address.getAddress();
		System.out.println(add.getHostAddress());
		System.out.println(add.getHostName());
		
	}
}