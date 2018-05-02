package cn.waggag.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射api动态的操作:构造器,方法,属性
 * @author waggag
 * 2018年4月24日 下午2:35:48
 */
public class TestReflect4 {
	@SuppressWarnings("all")
	public static void main(String[] args) 
			throws InstantiationException, IllegalAccessException, 
			NoSuchMethodException, NoSuchFieldException {
		String path = "cn.waggag.reflect.User";
		try {
			
			Class<User> clazz = (Class<User>) Class.forName(path);
			//通过反射API动态调用构造方法
			User u =clazz.newInstance();//其实时调用了User的无参构造方法
			System.out.println(u);
			Constructor<User> c = clazz.getConstructor(int.class,int.class,String.class);
			
			User u2 = c.newInstance(1001,18,"wanggang");
			System.out.println(u2.getName());
			
			//通过反射API动态调用普通方法
			User u3 = clazz.newInstance();
			//u3.setName("王港");
			Method method = clazz.getDeclaredMethod("setName", String.class);
			method.invoke(u3, "王港");
			System.out.println(u3.getName());
			
			//通过反射API动态操作属性
			User u4 = clazz.newInstance();
			Field f = clazz.getDeclaredField("name");
			f.setAccessible(true);   //不需要安全检查,直接访问
			f.set(u4, "王港爱");
			//通过反射得到值
			System.out.println(f.get(u4));

		} catch (SecurityException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
}
