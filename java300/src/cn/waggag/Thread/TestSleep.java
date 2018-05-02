package cn.waggag.Thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * ����ʱ
 * 1.����10����,һ���Ӵ�ӡһ��
 * 2.����ʱ
 * @author waggag
 * 2018��4��19�� ����10:53:51
 */
public class TestSleep {
	
	public static void main(String[] args) throws InterruptedException, ParseException {
		test();
		test2();
		
	}
	public static void test2() throws InterruptedException {
		/**
		 * ģ�⵹��ʱ
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
			Thread.sleep(1000);//��ͣһ����
			if(num<=0)
			{
				break;
			}
		}
	}
}




