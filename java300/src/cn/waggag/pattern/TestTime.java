package cn.waggag.pattern;

import java.util.concurrent.CountDownLatch;

/**
 * ���Ե���ģʽ��Ч��
 * @author waggag
 * 2018��4��29�� ����9:19:03
 */
public class TestTime {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int threadNum = 10;
		final CountDownLatch count = new CountDownLatch(threadNum);
		
		
		for(int i=0;i<threadNum;i++) {
			new Thread(new Runnable() {

				@SuppressWarnings("unused")
				@Override
				public void run() {
					for(int i = 0;i<100000;i++) {
						Object obj = Singleton3.getInstance();
					}
					count.countDown();
				}
				
			}).start();
		}
		try {
			count.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("�ܺ�ʱ"+(end - start));
	}
}
