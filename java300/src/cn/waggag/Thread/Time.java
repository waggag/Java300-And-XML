package cn.waggag.Thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 任务调度,了解一下
 * @author waggag
 * 2018年4月19日 下午8:13:09
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
