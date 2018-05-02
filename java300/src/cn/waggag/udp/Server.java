package cn.waggag.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 服务器
 * 1.服务器端+端口
 * 2.准备接受容器
 * 3.封装成包
 * 4.接受数据   -->double
 * @author waggag
 * 2018年4月20日 下午1:42:38
 */
public class Server {
	@SuppressWarnings("unused")
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
		double data = convert(packet.getData());
		int len = packet.getLength();
		System.out.println(data);
		//释放资源
		server.close();
	}
	/**
	 * 字节数组+Data输入流
	 * @throws IOException 
	 */
	public static double convert(byte[] data) throws IOException 
	{
		
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
		double num = dis.readDouble();
		
		return num;
	}
}
