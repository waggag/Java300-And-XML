package cn.waggag.send;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * �������ݵķ���
 * @author waggag
 * 2018��4��20�� ����8:37:08
 */
public class Send implements Runnable{
	//����̨������
	private BufferedReader console;
	//�ܵ������
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
	 * �ӿ���̨��������
	 * ��������
	 */
	public void send(String msg) {
		
		if(msg != null && !msg.equals(""))
		{
			try {
				dos.writeUTF(msg);
				dos.flush();  //ǿ��ˢ��
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
