package cn.waggag.send;
/**
 * �����߳�
 * @author waggag
 * 2018��4��20�� ����8:37:53
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
	//�̱߳�ʶ
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
	//�������ݵķ���
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
