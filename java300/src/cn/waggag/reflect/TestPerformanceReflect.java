package cn.waggag.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试reflect的性能差距
 * @author waggag
 * 2018年4月24日 下午7:23:43
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
		System.out.println("普通方法执行10亿次耗时:"+(endTime-startTime)+"ms");
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
		System.out.println("反射动态方法执行10亿次耗时:"+(endTime-startTime)+"ms");

	}
	
public static void testPerformance3() throws Exception{
		
		User u =new User();
		Class clazz = u.getClass();
	
		Method m =clazz.getDeclaredMethod("getName", null);
		//不执行访问安全检查
		m.setAccessible(true);
		long startTime = System.currentTimeMillis();
		for(int i=0; i<1000000000L;i++)
		{
			m.invoke(u, null);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("反射动态方法禁用检查执行10亿次耗时:"+(endTime-startTime)+"ms");
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
