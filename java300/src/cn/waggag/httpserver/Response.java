package cn.waggag.httpserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * 封装响应信息
 * @author wagga
 * 2018年4月21日 下午4:43:01
 */
public class Response {
	
	private static final String CRLF = "\r\n";
	private static final String BLANK  = " ";
	//存储头信息
	private StringBuilder headInfo;
	private int len ;
	//存储正文信息
	private StringBuilder content;
	//流
	private BufferedWriter bw;
	
	public Response (Socket client) {
		this();
		try {
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			//e.printStackTrace();
			headInfo = null;
		}
	}
	
	public Response (OutputStream os) {
		this();
		bw = new BufferedWriter(new OutputStreamWriter(os));
	}
	/**
	 * 构建响应头
	 */
	public Response() {
		
		headInfo = new StringBuilder();
		content = new StringBuilder();
		len = 0;
	}
	
	
	/**
	 * 构建正文
	 * @return 
	 */
	public Response print(String info) {
		content.append(info);
		len = len + info.getBytes().length;
		return this;
	}
	/**
	 * 构建正文+回车  正文，返回给客户端的消息
	 */
	public Response println(String info) {
		content.append(info).append(CRLF);
		len = len + (info+CRLF).getBytes().length;
		return this;
	}
	
	/**
	 * code  服务器http采用的应答方式  
	 * 200  ok  404 NOt Found
	 */
	private void createHeadInfo(int code) {
		
		//响应的正文信息
		StringBuilder responseContext = new StringBuilder();
		responseContext.append("<html><head><title>HTTP</title>"+
		"</head><body>Hello WagGag!</body></html>");
		
		//响应的头信息
		//1.http协议版本， 状态码， 描述
		headInfo.append("HTTP/1.1:").append(BLANK).append(code).append(BLANK);
		switch(code)
		{
			case 200:
				headInfo.append("OK").append(CRLF);
				break;
			case 404:
				headInfo.append("NOT Found").append(CRLF);
				break;
			case 500:
				headInfo.append("Server Error").append(CRLF);
				break;
		}
		//2.响应头
		headInfo.append("Server:waggag server/0.0.1").append(CRLF);
		headInfo.append("Date:").append(new Date()).append(CRLF);
		//3.响应正文类型
		headInfo.append("Content-type:text/html;charset=GDK").append(CRLF);
		//正文长度，字节长度
		headInfo.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
		
		headInfo.append(CRLF);  //分隔符
		
	}
	
	void pushClient(int code) throws IOException {
		//判断头信息是否为空
		if(headInfo == null) {
			code = 500;
		}
		createHeadInfo(code);
		//头信息和分隔符
		bw.append(headInfo.toString());
		//正文
		bw.append(content).toString();
		bw.flush();
		bw.close();
	}
	
	
}
