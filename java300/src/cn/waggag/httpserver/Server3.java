package cn.waggag.httpserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * ����������������
 * ������Ӧ
 * @author wagga
 * 2018��4��21�� ����12:55:29
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
	 * ��������
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
	 * ���տͻ���
	 */
	private void receive() {
		try {
			/**
			 * ����������Ϣ
			 */
			Socket client = server.accept();
			//���ڽ��ܿͻ��˵�������Ϣ	
			byte[] data = new byte[20480];
			//�������ݵĳ���
			int len = client.getInputStream().read(data);		
			
			//����ͻ��˵�������Ϣ
			String requeestInfo = new String(data, 0, len).trim();
			System.out.println(requeestInfo);
			
			/**
			 * ���ڿͻ��˵����������Ӧ
			 */
			StringBuilder responseContext = new StringBuilder();
			responseContext.append("<html><head><title>HTTP</title>"+
			"</head><body>Hello Tomcat!</body></html>");
			
			StringBuilder response = new StringBuilder();
			//1.httpЭ��汾�� ״̬�룬 ����
			response.append("HTTP/1.1:").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
			//2.��Ӧͷ
			response.append("Server:waggag server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			//3.��Ӧ��������
			response.append("Content-type:text/html;charset=GDK").append(CRLF);
			//���ĳ��ȣ��ֽڳ���
			response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
			response.append(CRLF);
			
			//����
			response.append(responseContext);
			
			//�����
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	//��������
	public void stop() {
		
	}
}
