package cn.waggag.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ���÷����Api,���������Ϣ(�������,����,����,��������)
 * @author waggag
 * 2018��4��24�� ����2:12:45
 */
public class TestReflect3 {
	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		String path = "cn.waggag.reflect.User";
		try {
			Class clazz = Class.forName(path);
			//��ȡ�������
			System.out.println(clazz.getName());//��ȡ����+����
			System.out.println(clazz.getSimpleName());//��ȡ����
			//�����ص�����
			//ֻ�ܻ��public��filed
			Field[] filed = clazz.getFields();
			//������е�Filed
			Field[] fileds = clazz.getDeclaredFields();
			System.out.println(fileds.length);
			for(Field temp: fileds)
			{
				System.out.println("����"+temp);
			}
			
			//������Ϣ
			Method[] methods = clazz.getDeclaredMethods();
			Method m1 = clazz.getDeclaredMethod("getName", null);
			Method m2 = clazz.getDeclaredMethod("setName", String.class);
			for(Method m: methods)
			{
				System.out.println("����:"+m);
			}
			//������
			Constructor[] constructors = clazz.getDeclaredConstructors();
			//��ȡָ���Ĺ�����
			Constructor c = clazz.getDeclaredConstructor(null);
			Constructor c2 = clazz.getDeclaredConstructor(int.class,int.class,String.class);
			System.out.println("ָ��������"+c);
			System.out.println("ָ��������"+c2);
			
			for(Constructor temp: constructors)
			{
				System.out.println("������:"+temp);
			}
			
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
	}
}
