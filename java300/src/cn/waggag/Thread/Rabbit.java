package cn.waggag.Thread;
/**
 * ģ���������
 * 1.�������߳�,�̳�Thread�� + ��дrun
 * 2.ʹ���߳� �����������,�������.start()����,�߳�����
 * @author waggag
 * 2018��4��18�� ����2:28:55
 */
public class Rabbit extends Thread {
	
	@Override
	public void run() 
	{
		//�߳���
		for(int i=0; i<100; i++)
		{
			System.out.println("��������"+i+"��!");
		}
	}
} 

class Tortoise extends Thread {
	@Override
	public void run() 
	{
		//�߳���
		for(int i=0; i<100; i++)
		{
			System.out.println("�ڹ�����"+i+"��!");
		}
	}
}