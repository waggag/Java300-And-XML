package cn.waggag.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������������������
 * ����������,ָ���˿� ServerSocket(int port)
 * ���տͻ�������
 * ��������  ��������
 * 
 * ���ն���ͻ���
 * @author waggag
 * 2018��4��20�� ����7:14:35
 */
public class ManyServer {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		//����������,ָ���˿�
		ServerSocket server = new ServerSocket(8888);
		//���տͻ�������
		while(true)  //һ��accept(),һ���ͻ���
		{  
			Socket socket = server.accept();
			System.out.println("һ���ͻ��˽�������!");
			//��������
			String str = "��ӭʹ��!";
			
			//�����
			/*BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())
					);
			bw.write(str);
			bw.newLine();
			bw.flush();*/
			
			DataOutputStream dos = new DataOutputStream(
					socket.getOutputStream()
					);
			dos.writeUTF(str);
			dos.flush();
		}
	}
}
