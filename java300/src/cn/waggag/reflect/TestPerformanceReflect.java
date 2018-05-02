package cn.waggag.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ����reflect�����ܲ��
 * @author waggag
 * 2018��4��24�� ����7:23:43
 */
@SuppressWarnings("all")
public class TestPerformanceReflect {
	
	public static void testPerformance() {
		
		User u =new User();
		
		long startTime = System.currentTimeMillis();
		for(int i=0; i<1000000000L;i++)
		{
			u.getName();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("��ͨ����ִ��10�ڴκ�ʱ:"+(endTime-startTime)+"ms");
	}
	public static void testPerformance2() throws Exception{
		
		User u =new User();
		Class clazz = u.getClass();
		Method m =clazz.getDeclaredMethod("getName", null);
		long startTime = System.currentTimeMillis();
		for(int i=0; i<1000000000L;i++)
		{
			m.invoke(u, null);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("���䶯̬����ִ��10�ڴκ�ʱ:"+(endTime-startTime)+"ms");

	}
	
public static void testPerformance3() throws Exception{
		
		User u =new User();
		Class clazz = u.getClass();
	
		Method m =clazz.getDeclaredMethod("getName", null);
		//��ִ�з��ʰ�ȫ���
		m.setAccessible(true);
		long startTime = System.currentTimeMillis();
		for(int i=0; i<1000000000L;i++)
		{
			m.invoke(u, null);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("���䶯̬�������ü��ִ��10�ڴκ�ʱ:"+(endTime-startTime)+"ms");
	}
	
	public static void main(String[] args) {
		
		testPerformance();
		
		try {
			testPerformance2();
			testPerformance3();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
