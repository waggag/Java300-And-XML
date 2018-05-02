package cn.waggag.Thread;

public class Web12306 implements Runnable{
	
	private int num = 50;

	@Override
	public void run() {
		while(true)
		{
			if(num<=0) {
				break;
			}
			System.out.println(Thread.currentThread().getName()+"抢到了"+(num--)+"票");
		}
	}
	public static void main(String[] args) {
		//真实角色
		Web12306 web= new Web12306();
		//代理
		Thread t1 = new Thread(web, "王港");
		
		Thread t2 = new Thread(web, "杨友凤");
		Thread t3 = new Thread(web, "google工程师");
		t1.start();
		t2.start();
		t3.start();
	}
}
