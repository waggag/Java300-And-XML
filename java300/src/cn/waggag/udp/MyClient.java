package cn.waggag.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
/**
 * 客服端
 * 1.创建客户端+端口
 * 2.准备数据
 * 3.打包(发送的地点与端口)
 * 4.发送
 * 5.释放
 * @author waggag
 * 2018年4月20日 下午1:52:24
 */
public class MyClient {
	
	public static void main(String[] args) throws SocketException {
		//创建服务器+端口
		DatagramSocket client = new DatagramSocket(6666);
		//准备数据
		String msg = "udp编程";
		byte[] data = msg.getBytes();
		//打包
		DatagramPacket packet = new DatagramPacket(data,data.length,
				new InetSocketAddress("localhost",8888));
		//发送
		try {
			client.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//释放
		client.close();
		
	}
	
}
