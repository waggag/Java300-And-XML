package cn.waggag.httpserver;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * ����������������
 * ������Ӧ
 * @author wagga
 * 2018��4��21�� ����12:55:29
 */
public class Server6 {
	
	private ServerSocket server;
	
	private boolean isShutDown = false;
	
	public static void main(String[] args) {
		Server6 server = new Server6();
		server.start();
	}
	
	/**
	 * ��������,ָ���˿�
	 */
	public void start(int port) {
		
		try {
			server = new ServerSocket(port);
			this.receive();
			
		} catch (IOException e) {
			stop();
		}	
	}
	
	public void start() {
			
			try {
				server = new ServerSocket(8888);
				this.receive();
				
			} catch (IOException e) {
				stop();
			}	
		}
	
	/**
	 * ���տͻ���
	 */
	private void receive() {
		try {
			while(!isShutDown){			
				new Thread(new Dispatcher(server.accept())).start();
			}
			
		} catch (IOException e) {
			//e.printStackTrace();
			stop();
		}
	}
	
	//��������
	public void stop() {
		isShutDown = true;
		ClossUtil.closeSocket(server);
	}
}
