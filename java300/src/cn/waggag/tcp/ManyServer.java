package cn.waggag.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 必须先启动服务器后连接
 * 创建服务器,指定端口 ServerSocket(int port)
 * 接收客户端连接
 * 发送数据  接收数据
 * 
 * 接收多个客户端
 * @author waggag
 * 2018年4月20日 下午7:14:35
 */
public class ManyServer {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		//创建服务器,指定端口
		ServerSocket server = new ServerSocket(8888);
		//接收客户端连接
		while(true)  //一个accept(),一个客户端
		{  
			Socket socket = server.accept();
			System.out.println("一个客户端建立连接!");
			//发送数据
			String str = "欢迎使用!";
			
			//输出流
			/*BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())
					);
			bw.write(str);
			bw.newLine();
			bw.flush();*/
			
			DataOutputStream dos = new DataOutputStream(
					socket.getOutputStream()
					);
			dos.writeUTF(str);
			dos.flush();
		}
	}
}
