package cn.waggag.http2;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 创建服务器并启动
 * 请求并响应
 * @author wagga
 * 2018年4月21日 下午12:55:29
 */
public class Server {
	
	private ServerSocket server;
	
	private boolean isShutDown = false;
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	
	/**
	 * 启动方法,指定端口
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
	 * 接收客户端
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
	
	//结束方法
	public void stop() {
		isShutDown = true;
		ClossUtil.closeSocket(server);
	}
}
