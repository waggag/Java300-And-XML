package cn.waggag.Thread;

public class MyThreadApp {
	
	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread();
		Thread proxy = new Thread(t1, "王港");
//		proxy.setName("王港");
//		System.out.println(proxy.getName());
//		proxy.start();
//		System.out.println("启动后的状态"+proxy.isAlive());
//		Thread.sleep(2);
//		t1.stop();
//		Thread.sleep(10);
//		System.out.println("停止后的状态"+proxy.isAlive());
		MyThread t2 = new MyThread();
		Thread proxy2 = new Thread(t2, "王");
	
		proxy.start();
		proxy2.start();
		Thread.sleep(100);
		t1.stop();
		t2.stop();
		
		
		
	}
}
