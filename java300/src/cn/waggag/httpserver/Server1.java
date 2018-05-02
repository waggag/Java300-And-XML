package cn.waggag.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������������
 * @author wagga
 * 2018��4��21�� ����12:55:29
 */
public class Server1 {
	
	private ServerSocket server;
	public static void main(String[] args) {
		Server1 server = new Server1();
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
	@SuppressWarnings("unused")
	private void receive() {
		try {
			Socket client = server.accept();
			//���ڽ��ܿͻ��˵�������Ϣ
			StringBuilder sb =new StringBuilder();
			String msg = null;
			//���ڽ�����������
			BufferedReader br = new BufferedReader(
					new InputStreamReader(client.getInputStream()));
			while((msg = br.readLine()).length() > 0)
			{
				sb.append(msg);
				sb.append("\r\n");
				if(msg == null) {
					break;
	
			}			}
			//����ͻ��˵�������Ϣ
			String requeestInfo = sb.toString().trim();
			System.out.println(requeestInfo);
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	//��������
	public void stop() {
		
	}
	
}
