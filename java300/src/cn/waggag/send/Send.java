package cn.waggag.send;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 用于数据的发送
 * @author waggag
 * 2018年4月20日 下午8:37:08
 */
public class Send implements Runnable{
	//控制台输入流
	private BufferedReader console;
	//管道输出流
	private DataOutputStream dos;
	
	private String name;
	
	private boolean isRunning = true;
	
	public Send() {
		console = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	public Send(Socket client, String name) {
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
			this.name = name;
			send(this.name);
		} catch (IOException e) {
			isRunning = false;
			ClossUtil.closeAll(dos,console);
		}
	}
	
	private String getMsgFromConsole() {
		try {
			return console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 从控制台接收数据
	 * 发送数据
	 */
	public void send(String msg) {
		
		if(msg != null && !msg.equals(""))
		{
			try {
				dos.writeUTF(msg);
				dos.flush();  //强制刷新
			} catch (IOException e) {
				isRunning = false;
				ClossUtil.closeAll(dos,console);
			}
		}
	}
	@Override
	public void run() {
		while(isRunning) {
			send(getMsgFromConsole());
		}
	}

}
