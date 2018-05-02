package cn.waggag.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
/**
 * �ͷ���
 * 1.�����ͻ���+�˿�
 * 2.׼������
 * 3.���(���͵ĵص���˿�)
 * 4.����
 * 5.�ͷ�
 * @author waggag
 * 2018��4��20�� ����1:52:24
 */
public class MyClient {
	
	public static void main(String[] args) throws SocketException {
		//����������+�˿�
		DatagramSocket client = new DatagramSocket(6666);
		//׼������
		String msg = "udp���";
		byte[] data = msg.getBytes();
		//���
		DatagramPacket packet = new DatagramPacket(data,data.length,
				new InetSocketAddress("localhost",8888));
		//����
		try {
			client.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//�ͷ�
		client.close();
		
	}
	
}
