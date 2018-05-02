package cn.waggag.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ������
 * 1.��������+�˿�
 * 2.׼����������
 * 3.��װ�ɰ�
 * 4.��������   -->double
 * @author waggag
 * 2018��4��20�� ����1:42:38
 */
public class Server {
	@SuppressWarnings("unused")
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
		double data = convert(packet.getData());
		int len = packet.getLength();
		System.out.println(data);
		//�ͷ���Դ
		server.close();
	}
	/**
	 * �ֽ�����+Data������
	 * @throws IOException 
	 */
	public static double convert(byte[] data) throws IOException 
	{
		
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
		double num = dis.readDouble();
		
		return num;
	}
}
