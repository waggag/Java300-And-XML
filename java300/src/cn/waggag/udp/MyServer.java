package cn.waggag.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 服务器
 * 1.服务器端+端口
 * 2.准备接受容器
 * 3.封装成包
 * 4.接受数据
 * @author waggag
 * 2018年4月20日 下午1:42:38
 */
public class MyServer {
	public static void main(String[] args) throws IOException {
		//创建服务器+端口
		DatagramSocket server = new DatagramSocket(8888);
		//准备接受容器
		byte[] con = new byte[1024];
		//DatagramPackge 封装成包
		DatagramPacket packet = new DatagramPacket(con, con.length);
		//接受数据
		server.receive(packet);
		//分析数据
		byte[] data = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(data,0,len));
		//释放资源
		server.close();
		
		
		
		
		
		
		
		
		
		
		
	}
}
