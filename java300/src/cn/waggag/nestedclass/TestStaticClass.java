package cn.waggag.nestedclass;

import cn.waggag.nestedclass.Outer.StaticInnerClass;

/**
 * ���Ծ�̬�ڲ������ϸ�÷�
 * @author waggag
 * 2018��4��28�� ����10:04:08
 */
@SuppressWarnings("all")
public class TestStaticClass {
	
	public static void main(String[] args) {
		//Outer.StaticInnerClass osic = new Outer.StaticInnerClass();
		//��̬�ڲ����ⲿ�����ϵ���٣��ⲿ�����ͬһ����
		StaticInnerClass osic = new StaticInnerClass();
		
	}
	
}

@SuppressWarnings("all")
class Outer{
	
	int c = 5;
	static int d = 6;
	
	void t() {
		StaticInnerClass s= new StaticInnerClass();
	}
	//��̬�ڲ���
	public static class StaticInnerClass{
		int a = 3;
		static int b = 5;
		public void test() {
			System.out.println(d);
			//��̬�ڲ��಻�ܵ�����ͨ��Ա
			//System.out.println(c);
		}
	}
	
	
	
	
	
	
}
