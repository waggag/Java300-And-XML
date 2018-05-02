package cn.waggag.Thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 倒计时
 * 1.倒数10个数,一秒钟打印一个
 * 2.倒计时
 * @author waggag
 * 2018年4月19日 上午10:53:51
 */
public class TestSleep {
	
	public static void main(String[] args) throws InterruptedException, ParseException {
		test();
		test2();
		
	}
	public static void test2() throws InterruptedException {
		/**
		 * 模拟倒计时
		 */
		Date endtime = new Date(System.currentTimeMillis()+10*1000);
		long end = endtime.getTime();
		while(true) {
			System.out.println(new SimpleDateFormat("hh:mm:ss").format(endtime));
			endtime = new Date(endtime.getTime() - 1000);
			Thread.sleep(1000);
			if(end-10000>endtime.getTime())
			{
				break;
			}	
		}
	}

	public static void test() throws InterruptedException
	{
		int num = 10;
		while(true) {
			System.out.println(num--);
			Thread.sleep(1000);//暂停一秒钟
			if(num<=0)
			{
				break;
			}
		}
	}
}




