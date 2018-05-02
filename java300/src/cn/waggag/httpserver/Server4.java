package cn.waggag.httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器并启动
 * 请求并响应
 * @author wagga
 * 2018年4月21日 下午12:55:29
 */
public class Server4 {
	
	private ServerSocket server;
	
	public static void main(String[] args) {
		Server4 server = new Server4();
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
	@SuppressWarnings("unused")
	private void receive() {
		try {
			Socket client = server.accept();
			Request req = new Request(client.getInputStream());
			/**
			 * 响应
			 */
			Response rep = new Response(client);
			rep.println("<html><head><title>waggag  seriver</title>");
			rep.println("</head><body>Hello World!</body></html>");
			rep.pushClient(500);
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	//结束方法
	public void stop() {
		
	}
}
