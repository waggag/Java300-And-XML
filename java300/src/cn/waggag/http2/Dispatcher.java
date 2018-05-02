package cn.waggag.http2;
/**
 * 一个请求与响应就是一个子对象
 * @author wagga
 * 2018年4月22日 下午12:01:58
 */

import java.io.IOException;
import java.net.Socket;

import cn.waggag.send.ClossUtil;

public class Dispatcher implements Runnable{
	
	private Socket client;
	private Request req;
	private Response rep;
	private int code;
	
	public Dispatcher(Socket client) {
		this.client = client;
		try {
			req = new Request(client.getInputStream());
			rep = new Response(client.getOutputStream());
		} catch (IOException e) {
			//e.printStackTrace();
			code = 500;
			return ;
		}
	}
	
	@Override
	public void run() {
		try {
			//服务器接受和响应请求
			Servlet serv = WebApp.getServlet(req.getUrl());
			if(null == serv) {
				this.code = 404; //找不到对应的处理
			}else {
				serv.service(req, rep);
			}
			//code   选择http应答码
			rep.pushClient(code);  //推送到客户端
		} catch (Exception e) {
			//e.printStackTrace();
			this.code = 500;
		} 
		ClossUtil.closeAll(client);
	}
	
}
