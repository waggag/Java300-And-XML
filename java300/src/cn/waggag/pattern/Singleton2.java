package cn.waggag.pattern;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * ����ʽģʽ��ʵ��   ����������������
 * �ص㣺�̰߳�ȫ������Ч�ʸߣ���ʱ���ص�����
 * @author waggag
 * 2018��4��29�� ����4:36:08
 */
@SuppressWarnings("serial")
public class Singleton2 implements Serializable{
	
	//���ʼ��ʱ������ʼ��������������õ���ʱ��ż���
	private static Singleton2 instance;
	
	//˽�л�������
	private Singleton2() {
		//��ֹ�����ƻ�����
		if(instance != null) {
			throw new RuntimeException();
		}
	}
	
	//ʹ��ͬ��������Ч�ʵ�
	public static synchronized Singleton2 getInstance() {
		if(instance == null){
			instance = new Singleton2();
		}
		return instance;
	}
	
	//�����л�-------------ʱֱ�ӷ����Ѿ�������ʵ��,ʵ��readResolve()
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}
	
}
