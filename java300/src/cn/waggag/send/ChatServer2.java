package cn.waggag.send;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建服务器
 * @author waggag
 * 2018年4月20日 下午8:07:47
 */
public class ChatServer2 {
	
	private List<MyChannel> all = new ArrayList<MyChannel>();
	public static void main(String[] args) throws IOException {
		
		new ChatServer2().start();
		
	}
	@SuppressWarnings("resource")
	public void start() throws IOException
	{
		ServerSocket server = new ServerSocket(9999);
		while(true)
		{
			Socket client = server.accept();
			MyChannel channel = new MyChannel(client);
			all.add(channel);
			new Thread(channel).start();
		}
	}
	
	/**
	 * 一个客户端，一条道路
	 */
	class MyChannel implements Runnable{
		private DataOutputStream dos ;
		private DataInputStream dis ;
		
		private boolean isRunning = true;
		
		public MyChannel(Socket client) {
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				ClossUtil.closeAll(dis, dos);
				isRunning = false;
			}
		}
		/**
		 * 读取数据
		 * @return
		 */
		private String receive() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				ClossUtil.closeAll(dis);
				all.remove(this);
				
			}
			return msg;
		}
		/**
		 * 发送数据
		 */
		@SuppressWarnings("null")
		private void send(String msg) {
			if(msg == null && msg.equals("")){
				return ;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				ClossUtil.closeAll(dos);
				all.remove(this);
			}
			
			
			
		}
		/**
		 * 发送给其他客户端
		 */
		public  void sendOthers() {
			String msg = receive();
			for(MyChannel other : all)
			{
				if(other == this)
				{
					continue;
				}
				//发送给其他的客户端
				other.send(msg);
			}
		}
		@Override
		public void run() {
			while(isRunning) {
				sendOthers();
			}			
		}
		
	}
}

