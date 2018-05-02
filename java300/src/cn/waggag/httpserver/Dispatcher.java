package cn.waggag.httpserver;
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
		Servlet serv = new Servlet();
		//服务器接受和响应请求
		serv.service(req, rep);
		//code   选择http应答码
		try {
			rep.pushClient(code);  //推送到客户端
		} catch (IOException e) {
			//e.printStackTrace();
			code = 500;
		}
		ClossUtil.closeAll(client);
	}
	
}
