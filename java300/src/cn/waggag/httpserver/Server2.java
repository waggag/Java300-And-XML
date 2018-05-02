package cn.waggag.httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������������
 * @author wagga
 * 2018��4��21�� ����12:55:29
 */
public class Server2 {
	
	private ServerSocket server;
	
	public static void main(String[] args) {
		Server2 server = new Server2();
		server.start();
	}
	
	/**
	 * ��������
	 */
	public void start() {
		
		try {
			server = new ServerSocket(8888);
			this.receive();
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * ���տͻ���
	 */
	private void receive() {
		try {
			Socket client = server.accept();
			//���ڽ��ܿͻ��˵�������Ϣ	
			byte[] data = new byte[20480];
			//�������ݵĳ���
			int len = client.getInputStream().read(data);		
			
			//����ͻ��˵�������Ϣ
			String requeestInfo = new String(data, 0, len).trim();
			System.out.println(requeestInfo);
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	//��������
	public void stop() {
		
	}
}
