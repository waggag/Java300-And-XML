package cn.waggag.collections;

import java.lang.ref.WeakReference;

/**
 * ���÷��ࣺ ǿ����������
 * 
 * @author wagga
 * 2018��4��14������1:01:57
 */
public class RefStyle {
	public static void main(String[] args) {
		
		String str = new String("wanggang is very good!");
		//�����ã��������
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc����ǰ��"+wr.get());
		//�Ͽ�����
		str = null;
		//֪ͨ����
		System.gc();
		System.runFinalization();
		//���󱻻���
		System.out.println("gc���к�"+wr.get());
	}
	public static void testStrong() {
		//�ַ��������أ��������ܻ���
		String str = "wanggang is very good!";
		//�����ã��������
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc����ǰ��"+wr.get());
		//�Ͽ�����
		str = null;
		//֪ͨ����
		System.gc();
		System.runFinalization();
		System.out.println("gc���к�"+wr.get());
	}
}
