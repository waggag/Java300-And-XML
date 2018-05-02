package cn.waggag.send;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * �����ͻ���  ���� + ����
 * 
 * ���������������ͬһ���߳���,Ӧ�ö�������,�˴˶���
 * @author waggag
 * 2018��4��20�� ����8:08:44
 */
public class ChatClient {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		//����̨������
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		Socket client = new Socket("localhost", 9999);
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		while(true) {
			String info = console.readLine();
			//�������
			dos.writeUTF(info);
			dos.flush();
			//������
			String msg = dis.readUTF();
			System.out.println(msg);
		}
		
	}
}
