package cn.waggag.Thread;
/**
 * �Ƽ�ʹ��ʵ��Runnable
 * 1.���ⵥ�̳еľ�����
 * 2.���׹�����Դ
 * @author waggag
 * 2018��4��18�� ����8:38:17
 */
public class RunnableApp {
	
	public static void main(String[] args) {
		//������ʵ��ɫ
		TestRunnable ra = new TestRunnable();
		//���������ɫ,��ʵ��ɫ����
		Thread proxy = new Thread(ra);
		//����start(),�����߳�
		proxy.start();
		for(int i=0; i<100; i++)
		{
			System.out.println("һ����QQ !");
		}

	}
}
