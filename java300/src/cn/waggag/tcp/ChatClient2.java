package cn.waggag.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 创建客户端  发送 + 接收
 * 
 * 输入流与输出流在同一个线程内,应该独立处理,彼此独立
 * @author waggag
 * 2018年4月20日 下午8:08:44
 */
public class ChatClient2 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		//控制台输入流
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		Socket client = new Socket("localhost", 9999);
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		while(true) {
			System.out.print("请输入你的用户名:");
			String info = console.readLine();
			//输出数据
			dos.writeUTF(info);
			dos.flush();
			//读取数据
			String msg = dis.readUTF();
			System.out.println(msg);
		}
	}
}
