package cn.waggag.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
/**
 * 客服端
 * 1.创建客户端+端口
 * 2.准备数据 double类型转为字节数组
 * 3.打包(发送的地点与端口)
 * 4.发送
 * 5.释放
 * @author waggag
 * 2018年4月20日 下午1:52:24
 */
public class Client {
	
	public static void main(String[] args) throws IOException {
		//创建客户端+端口
		DatagramSocket client = new DatagramSocket(6666);
		//准备数据
		double num = 89.12;
		byte[] data = convert(num);
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
	/**
	 * 使用字节数组当数据源+Data输出流
	 * @param num
	 * @return
	 * @throws IOException 
	 */
	public static byte[] convert(double num) throws IOException {
		byte[] data = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		//以Byte形式写入double类型的值
		dos.writeDouble(num);
		dos.flush();
		//获取数据
		data = bos.toByteArray();
		dos.close();
		
		return data;
		
	}
	
	
	
}
