package cn.waggag.Thread;
/**
 * �������ģʽ,ȷ��һ����ֻ��һ������
 * @author waggag
 * 2018��4��19�� ����1:16:12
 */
public class Design {
	
	public static void main(String[] args) {
		JvmThread  jt1 = new JvmThread(100);
		JvmThread  jt2 = new JvmThread(500);
		jt1.start();
		jt2.start();
	}
}
/**
 *  �������ģʽ,ȷ��һ����ֻ��һ������
 * 	ȷ��һ����ֻ��һ������
 * 	1.������˽�л�
 * 	2.����һ��˽�еľ�̬����
 * 	3.����һ������ľ�̬�������ʸı���
 * @author waggag
 * 2018��4��19�� ����1:19:02
 */
class Jvm{
	//������˽�л�,�����ⲿֱ�Ӵ�������
	private static Jvm instance = null;
	//������˽�л�,�����ⲿֱ�Ӵ�������
	private Jvm() {
	}
	//����һ������Ĺ�������
	//�Ŵ�������ĸ���
	public static  Jvm getInstance(long time){
		if(instance == null)
		{
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
	}	
	public static synchronized Jvm getInstance1(long time){
		if(instance == null)
		{
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
	}	
	
	public static  Jvm getInstance2(long time){
		//Ч�ʲ���,��ȡJvm���ֽ�����Ϣ
		synchronized(Jvm.class) {
			if(instance == null)
			{
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance = new Jvm();
			}
			return instance;
		}
	}
	
	public static  Jvm getInstance3(long time){
		//���ж��Ƿ���ڶ���,���ڶ�����Ҫ�ȴ�,����ֱ�ӷ���,���Ч��
		if(instance == null) {
			synchronized(Jvm.class) {
				if(instance == null)
				{
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new Jvm();
				}
			}
		}
		return instance;
	}
}

class JvmThread extends Thread{
	
	private long time;
	public JvmThread() {
	}
	public JvmThread(long time) {
		this.time = time;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+
				"--->����"+Jvm.getInstance1(time));
	}		
}
