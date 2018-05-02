package cn.waggag.Thread;
/**
 * һ������,��ͬ����Դ
 * wait() :�ȴ�,�ͷ���Դ
 * @author waggag
 * 2018��4��19�� ����2:16:37
 */
public class Moive {
	private String pic;
	private boolean flag = true;
	/**flag -->T ����������,�����ߵȴ�
	 * flag -->F �����ߵȴ�,����������
	 */
	
	public synchronized void play(String pic)
	{
		if(!flag)//�ȴ�
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//��ʼ����
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������"+pic);
		//�������
		this.pic = pic;
		this.notify();
		//������ͣ��
		this.flag = false;
	}
	
	public synchronized void watch() {
		if(flag)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//��ʼ����
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//�������
		System.out.println("������"+pic);
		//֪ͨ����
		this.notify();
		//����ֹͣ
		this.flag = true;	
	}
	
}
