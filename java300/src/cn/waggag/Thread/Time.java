package cn.waggag.Thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * �������,�˽�һ��
 * @author waggag
 * 2018��4��19�� ����8:13:09
 */
public class Time {
	public static void main(String[] args) {
		
		Timer tm = new Timer();
		tm.schedule(new TimerTask(){

			@Override
			public void run() {
				System.out.println("so easy!");
			}
			
		}, new Date(System.currentTimeMillis()+10000), 1000);
		
	}
}
