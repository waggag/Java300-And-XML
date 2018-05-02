package cn.waggag.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器并启动
 * @author wagga
 * 2018年4月21日 下午12:55:29
 */
public class Server1 {
	
	private ServerSocket server;
	public static void main(String[] args) {
		Server1 server = new Server1();
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
			//用于接受客户端的请求信息
			StringBuilder sb =new StringBuilder();
			String msg = null;
			//用于接受请求数据
			BufferedReader br = new BufferedReader(
					new InputStreamReader(client.getInputStream()));
			while((msg = br.readLine()).length() > 0)
			{
				sb.append(msg);
				sb.append("\r\n");
				if(msg == null) {
					break;
	
			}			}
			//处理客户端的请求信息
			String requeestInfo = sb.toString().trim();
			System.out.println(requeestInfo);
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	//结束方法
	public void stop() {
		
	}
	
}
