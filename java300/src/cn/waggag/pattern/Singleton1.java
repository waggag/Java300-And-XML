package cn.waggag.pattern;
/**
 * ����ʽģʽ��ʵ��   ����������������
 * �ص㣺�̰߳�ȫ������Ч�ʸߣ�
 * ȱ�㣺û����ʱ���ص�����
 * @author waggag
 * 2018��4��29�� ����4:25:32
 */
public class Singleton1 {
	//������ʼ���������
	private static Singleton1 instacnce = new Singleton1();
	
	//˽�л�������
	private Singleton1 () {} 
	
	public static Singleton1  getInstance() {
		return instacnce;
	}
}
