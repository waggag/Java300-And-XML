package cn.waggag.httpserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * ��װ��Ӧ��Ϣ
 * @author wagga
 * 2018��4��21�� ����4:43:01
 */
public class Response {
	
	private static final String CRLF = "\r\n";
	private static final String BLANK  = " ";
	//�洢ͷ��Ϣ
	private StringBuilder headInfo;
	private int len ;
	//�洢������Ϣ
	private StringBuilder content;
	//��
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
	 * ������Ӧͷ
	 */
	public Response() {
		
		headInfo = new StringBuilder();
		content = new StringBuilder();
		len = 0;
	}
	
	
	/**
	 * ��������
	 * @return 
	 */
	public Response print(String info) {
		content.append(info);
		len = len + info.getBytes().length;
		return this;
	}
	/**
	 * ��������+�س�  ���ģ����ظ��ͻ��˵���Ϣ
	 */
	public Response println(String info) {
		content.append(info).append(CRLF);
		len = len + (info+CRLF).getBytes().length;
		return this;
	}
	
	/**
	 * code  ������http���õ�Ӧ��ʽ  
	 * 200  ok  404 NOt Found
	 */
	private void createHeadInfo(int code) {
		
		//��Ӧ��������Ϣ
		StringBuilder responseContext = new StringBuilder();
		responseContext.append("<html><head><title>HTTP</title>"+
		"</head><body>Hello WagGag!</body></html>");
		
		//��Ӧ��ͷ��Ϣ
		//1.httpЭ��汾�� ״̬�룬 ����
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
		//2.��Ӧͷ
		headInfo.append("Server:waggag server/0.0.1").append(CRLF);
		headInfo.append("Date:").append(new Date()).append(CRLF);
		//3.��Ӧ��������
		headInfo.append("Content-type:text/html;charset=GDK").append(CRLF);
		//���ĳ��ȣ��ֽڳ���
		headInfo.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
		
		headInfo.append(CRLF);  //�ָ���
		
	}
	
	void pushClient(int code) throws IOException {
		//�ж�ͷ��Ϣ�Ƿ�Ϊ��
		if(headInfo == null) {
			code = 500;
		}
		createHeadInfo(code);
		//ͷ��Ϣ�ͷָ���
		bw.append(headInfo.toString());
		//����
		bw.append(content).toString();
		bw.flush();
		bw.close();
	}
	
	
}
