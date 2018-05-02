package cn.waggag.http2;
/**
 * һ����������Ӧ����һ���Ӷ���
 * @author wagga
 * 2018��4��22�� ����12:01:58
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
			//���������ܺ���Ӧ����
			Servlet serv = WebApp.getServlet(req.getUrl());
			if(null == serv) {
				this.code = 404; //�Ҳ�����Ӧ�Ĵ���
			}else {
				serv.service(req, rep);
			}
			//code   ѡ��httpӦ����
			rep.pushClient(code);  //���͵��ͻ���
		} catch (Exception e) {
			//e.printStackTrace();
			this.code = 500;
		} 
		ClossUtil.closeAll(client);
	}
	
}
