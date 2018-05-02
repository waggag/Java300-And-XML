package cn.waggag.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
/**
 * �ͷ���
 * 1.�����ͻ���+�˿�
 * 2.׼������ double����תΪ�ֽ�����
 * 3.���(���͵ĵص���˿�)
 * 4.����
 * 5.�ͷ�
 * @author waggag
 * 2018��4��20�� ����1:52:24
 */
public class Client {
	
	public static void main(String[] args) throws IOException {
		//�����ͻ���+�˿�
		DatagramSocket client = new DatagramSocket(6666);
		//׼������
		double num = 89.12;
		byte[] data = convert(num);
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
	/**
	 * ʹ���ֽ����鵱����Դ+Data�����
	 * @param num
	 * @return
	 * @throws IOException 
	 */
	public static byte[] convert(double num) throws IOException {
		byte[] data = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		//��Byte��ʽд��double���͵�ֵ
		dos.writeDouble(num);
		dos.flush();
		//��ȡ����
		data = bos.toByteArray();
		dos.close();
		
		return data;
		
	}
	
	
	
}
