package cn.waggag.Thread;
/**
 * ʹ��Runnable�����߳�
 * 1.��ʵ��Runable�ӿ� + ��дrun() --->��ʵ��ɫ��
 * 2.�������߳�,ʹ�ô����ɫ
 * 		������ʵ��ɫ
 * 		���������ɫ,��ʵ��ɫ����
 * 		����start(),�����߳�
 * @author waggag
 * 2018��4��18�� ����8:23:02
 */
public class TestRunnable implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<100; i++)
		{
			System.out.println("һ������!");
		}
	}
}
