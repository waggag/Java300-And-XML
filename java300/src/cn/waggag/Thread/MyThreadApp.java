package cn.waggag.Thread;

public class MyThreadApp {
	
	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread();
		Thread proxy = new Thread(t1, "����");
//		proxy.setName("����");
//		System.out.println(proxy.getName());
//		proxy.start();
//		System.out.println("�������״̬"+proxy.isAlive());
//		Thread.sleep(2);
//		t1.stop();
//		Thread.sleep(10);
//		System.out.println("ֹͣ���״̬"+proxy.isAlive());
		MyThread t2 = new MyThread();
		Thread proxy2 = new Thread(t2, "��");
	
		proxy.start();
		proxy2.start();
		Thread.sleep(100);
		t1.stop();
		t2.stop();
		
		
		
	}
}
