package cn.waggag.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 利用反射的Api,操作类的信息(类的名字,属性,方法,构造器等)
 * @author waggag
 * 2018年4月24日 下午2:12:45
 */
public class TestReflect3 {
	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		String path = "cn.waggag.reflect.User";
		try {
			Class clazz = Class.forName(path);
			//获取类的名字
			System.out.println(clazz.getName());//获取包名+类名
			System.out.println(clazz.getSimpleName());//获取类名
			//获得相关的属性
			//只能获得public的filed
			Field[] filed = clazz.getFields();
			//获得所有的Filed
			Field[] fileds = clazz.getDeclaredFields();
			System.out.println(fileds.length);
			for(Field temp: fileds)
			{
				System.out.println("属性"+temp);
			}
			
			//方法信息
			Method[] methods = clazz.getDeclaredMethods();
			Method m1 = clazz.getDeclaredMethod("getName", null);
			Method m2 = clazz.getDeclaredMethod("setName", String.class);
			for(Method m: methods)
			{
				System.out.println("方法:"+m);
			}
			//构造器
			Constructor[] constructors = clazz.getDeclaredConstructors();
			//获取指定的构造器
			Constructor c = clazz.getDeclaredConstructor(null);
			Constructor c2 = clazz.getDeclaredConstructor(int.class,int.class,String.class);
			System.out.println("指定构造器"+c);
			System.out.println("指定构造器"+c2);
			
			for(Constructor temp: constructors)
			{
				System.out.println("构造器:"+temp);
			}
			
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
	}
}
