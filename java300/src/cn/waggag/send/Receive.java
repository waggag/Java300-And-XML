package cn.waggag.send;
/**
 * 接受线程
 * @author waggag
 * 2018年4月20日 下午8:37:53
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
	//线程标识
	private boolean isRunning = true;
	private DataInputStream dis;
	public Receive(Socket client) {
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			isRunning = false;
			ClossUtil.closeAll(dis);
		}
		
	}
	//接收数据的方法
	public String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			isRunning = false;
			ClossUtil.closeAll(dis);
		}
		return msg;
	}
	@Override
	public void run() {
		while(isRunning)
		{
			System.out.println(receive());
		}
	}
	
}
