package cn.waggag.httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������������
 * ������Ӧ
 * @author wagga
 * 2018��4��21�� ����12:55:29
 */
public class Server4 {
	
	private ServerSocket server;
	
	public static void main(String[] args) {
		Server4 server = new Server4();
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
			Request req = new Request(client.getInputStream());
			/**
			 * ��Ӧ
			 */
			Response rep = new Response(client);
			rep.println("<html><head><title>waggag  seriver</title>");
			rep.println("</head><body>Hello World!</body></html>");
			rep.pushClient(500);
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	//��������
	public void stop() {
		
	}
}
