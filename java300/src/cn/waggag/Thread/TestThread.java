package cn.waggag.Thread;

public class TestThread {
	public static void main(String[] args) {
		//�����������
		Rabbit rab = new Rabbit();
		Tortoise to = new Tortoise();
		//����start()����,��Ҫ����run����,ʹ�ö���·��
		rab.start();
		to.start();
		for(int i=0; i<100; i++)
		{
			System.out.println("main--->"+i);
		}
		
		
		
	}
}
