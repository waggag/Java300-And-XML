package cn.waggag.Thread;
/**
 * �����ͬ�����������������
 * @author waggag
 * 2018��4��19�� ����2:11:58
 */
public class DeadLock {
	public static void main(String[] args) {
		Object goods = new Object();
		Object money = new Object();
		
		Test t1 = new Test(goods, money);
		Test1 t2 = new Test1(goods, money);
		Thread proxy = new Thread(t1);
		Thread proxy2 = new Thread(t2);
		proxy.start();
		proxy2.start();
	}
}
class Test implements Runnable{
	Object goods;
	Object money;
	
	public Test(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	@Override
	public void run() {
		while(true){
			test();
		}
	}
	public void test() {
		synchronized (goods) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		synchronized (money) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("һ�ָ�Ǯ");
		
	}
	
}

class Test1 implements Runnable{
	Object goods;
	Object money;
	
	public Test1(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	@Override
	public void run() {
		while(true)
		{
			test();
		}
	}
	public void test() {
		synchronized (money) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		synchronized (goods) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("һ�ָ���");
		
	}
	
}

