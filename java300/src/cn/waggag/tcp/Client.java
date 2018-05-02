package cn.waggag.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端 + 必须指定服务器加端口
 * 
 * @author waggag
 * 2018年4月20日 下午7:23:54
 */
public class Client {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException {
		//创建客户端,必须指定服务器+端口
		Socket client = new Socket("localhost", 8888);
		
		//接受数据
		/*BufferedReader br = new BufferedReader(
				new InputStreamReader(client.getInputStream())
				);
		String str = br.readLine();
		System.out.println(str);
		*/
		
		DataInputStream dis = new DataInputStream(
				client.getInputStream()
				);
		System.out.println(dis.readUTF());
		
		
	}
}
