package cn.waggag.pattern;

import java.io.Serializable;

/**
 * ���Ծ�̬�ڲ��࣬ʵ�ֵ���ģʽ  ��������ʽ
 * 1.�̰߳�ȫ
 * 2.����Ч�ʸ�
 * 3.ʵ�����ӳټ���
 * @author waggag
 * 2018��4��29�� ����5:44:04
 */
@SuppressWarnings("all")
public class Singleton3 implements Serializable{
	
	private Singleton3() {
	}
	
	private static class SingletonClassInstance{
		private static final Singleton3 instance = new Singleton3();
	}
	
	public static Singleton3 getInstance() {
		return SingletonClassInstance.instance;
	}
}
