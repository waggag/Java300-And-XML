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
 * ����������
 * @author waggag
 * 2018��4��20�� ����8:07:47
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
	 * һ���ͻ��ˣ�һ����·
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
				this.send("��ӭ������������ң�");
				this.sendOthers(this.name+"������������!",true);
			} catch (IOException e) {
				ClossUtil.closeAll(dis, dos);
				isRunning = false;
			}
		}
		/**
		 * �ӿͻ��˶�ȡ����
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
		 * �������ݣ��ѽ��ܵ����ݷ����ȥ
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
		 * ���͸������ͻ���
		 */
		public  void sendOthers(String msg, boolean sys) {
			//�鿴�Ƿ�Ϊ˽��
			if(msg.startsWith("@") && msg.indexOf(":")>-1) {//˽��
				//��ȡname
				String name = msg.substring(1, msg.indexOf(":"));
				String content = msg.substring(msg.indexOf(":")+1);
				for(MyChannel other : all)
				{
					if(other.name.equals(name))
					{
						other.send(this.name+"����˵���Ļ�!"+content);
					}
				}
			}else {//������
				for(MyChannel other : all)
				{
					if(other == this)
					{
						continue;
					}
					if(sys) {
						other.send("ϵͳ��Ϣ��"+msg);
					}else {
						//���͸������Ŀͻ���
						other.send(this.name+"����˵:"+msg);
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

