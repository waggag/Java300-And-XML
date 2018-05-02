package cn.waggag.httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器并启动
 * @author wagga
 * 2018年4月21日 下午12:55:29
 */
public class Server2 {
	
	private ServerSocket server;
	
	public static void main(String[] args) {
		Server2 server = new Server2();
		server.start();
	}
	
	/**
	 * 启动方法
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
	 * 接收客户端
	 */
	private void receive() {
		try {
			Socket client = server.accept();
			//用于接受客户端的请求信息	
			byte[] data = new byte[20480];
			//请求数据的长度
			int len = client.getInputStream().read(data);		
			
			//处理客户端的请求信息
			String requeestInfo = new String(data, 0, len).trim();
			System.out.println(requeestInfo);
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	//结束方法
	public void stop() {
		
	}
}
