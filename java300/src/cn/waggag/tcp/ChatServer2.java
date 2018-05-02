package cn.waggag.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import cn.waggag.send.ClossUtil;

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
		private String name;
		public MyChannel(Socket client) {
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				
				this.name = dis.readUTF();
				this.send("欢迎你进入了聊天室！");
				this.sendOthers(this.name+"进入了聊天室!",true);
			} catch (IOException e) {
				ClossUtil.closeAll(dis, dos);
				isRunning = false;
			}
		}
		/**
		 * 从客户端读取数据
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
		 * 发送数据，把接受的数据发射出去
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
		public  void sendOthers(String msg, boolean sys) {
			//查看是否为私聊
			if(msg.startsWith("@") && msg.indexOf(":")>-1) {//私聊
				//获取name
				String name = msg.substring(1, msg.indexOf(":"));
				String content = msg.substring(msg.indexOf(":")+1);
				for(MyChannel other : all)
				{
					if(other.name.equals(name))
					{
						other.send(this.name+"对你说悄悄话!"+content);
					}
				}
			}else {//所有人
				for(MyChannel other : all)
				{
					if(other == this)
					{
						continue;
					}
					if(sys) {
						other.send("系统信息："+msg);
					}else {
						//发送给其他的客户端
						other.send(this.name+"对你说:"+msg);
					}
				}
			}
		}
		@Override
		public void run() {
			while(isRunning) {
				sendOthers(receive(),false);
			}			
		}
		
	}
}

