package cn.waggag.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ������
 * 1.��������+�˿�
 * 2.׼����������
 * 3.��װ�ɰ�
 * 4.��������
 * @author waggag
 * 2018��4��20�� ����1:42:38
 */
public class MyServer {
	public static void main(String[] args) throws IOException {
		//����������+�˿�
		DatagramSocket server = new DatagramSocket(8888);
		//׼����������
		byte[] con = new byte[1024];
		//DatagramPackge ��װ�ɰ�
		DatagramPacket packet = new DatagramPacket(con, con.length);
		//��������
		server.receive(packet);
		//��������
		byte[] data = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(data,0,len));
		//�ͷ���Դ
		server.close();
		
		
		
		
		
		
		
		
		
		
		
	}
}
