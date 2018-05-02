package cn.waggag.httpserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 创建服务器并启动
 * 请求并响应
 * @author wagga
 * 2018年4月21日 下午12:55:29
 */
public class Server3 {
	
	private ServerSocket server;
	
	private static final String CRLF = "\r\n";
	private static final String BLANK  = " ";
	
	public static void main(String[] args) {
		Server3 server = new Server3();
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
			/**
			 * 接受请求信息
			 */
			Socket client = server.accept();
			//用于接受客户端的请求信息	
			byte[] data = new byte[20480];
			//请求数据的长度
			int len = client.getInputStream().read(data);		
			
			//处理客户端的请求信息
			String requeestInfo = new String(data, 0, len).trim();
			System.out.println(requeestInfo);
			
			/**
			 * 对于客户端的请求给出响应
			 */
			StringBuilder responseContext = new StringBuilder();
			responseContext.append("<html><head><title>HTTP</title>"+
			"</head><body>Hello Tomcat!</body></html>");
			
			StringBuilder response = new StringBuilder();
			//1.http协议版本， 状态码， 描述
			response.append("HTTP/1.1:").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
			//2.响应头
			response.append("Server:waggag server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			//3.响应正文类型
			response.append("Content-type:text/html;charset=GDK").append(CRLF);
			//正文长度，字节长度
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			response.append(CRLF);
			
			//正文
			response.append(responseContext);
			
			//输出流
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	//结束方法
	public void stop() {
		
	}
}
