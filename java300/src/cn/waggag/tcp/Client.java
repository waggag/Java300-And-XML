package cn.waggag.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �����ͻ��� + ����ָ���������Ӷ˿�
 * 
 * @author waggag
 * 2018��4��20�� ����7:23:54
 */
public class Client {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException {
		//�����ͻ���,����ָ��������+�˿�
		Socket client = new Socket("localhost", 8888);
		
		//��������
		/*BufferedReader br = new BufferedReader(
				new InputStreamReader(client.getInputStream())
				);
		String str = br.readLine();
		System.out.println(str);
		*/
		
		DataInputStream dis = new DataInputStream(
				client.getInputStream()
				);
		System.out.println(dis.readUTF());
		
		
	}
}
