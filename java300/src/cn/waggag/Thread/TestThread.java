package cn.waggag.Thread;

public class TestThread {
	public static void main(String[] args) {
		//创建子类对象
		Rabbit rab = new Rabbit();
		Tortoise to = new Tortoise();
		//调用start()方法,不要调用run方法,使用多条路径
		rab.start();
		to.start();
		for(int i=0; i<100; i++)
		{
			System.out.println("main--->"+i);
		}
		
		
		
	}
}
