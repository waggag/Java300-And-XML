package cn.waggag.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������
 * @author waggag
 * 2018��4��20�� ����8:07:47
 */
public class ChatServer {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		ServerSocket socket = new ServerSocket(9999);
		Socket client = socket.accept();
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		while(true)
		{
			String str = dis.readUTF();
			System.out.println(str);
			dos.writeUTF("���������յ�!-->"+str);
			dos.flush();
		}
		
	}
}
