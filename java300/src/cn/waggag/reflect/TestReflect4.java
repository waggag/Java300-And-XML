package cn.waggag.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ͨ������api��̬�Ĳ���:������,����,����
 * @author waggag
 * 2018��4��24�� ����2:35:48
 */
public class TestReflect4 {
	@SuppressWarnings("all")
	public static void main(String[] args) 
			throws InstantiationException, IllegalAccessException, 
			NoSuchMethodException, NoSuchFieldException {
		String path = "cn.waggag.reflect.User";
		try {
			
			Class<User> clazz = (Class<User>) Class.forName(path);
			//ͨ������API��̬���ù��췽��
			User u =clazz.newInstance();//��ʵʱ������User���޲ι��췽��
			System.out.println(u);
			Constructor<User> c = clazz.getConstructor(int.class,int.class,String.class);
			
			User u2 = c.newInstance(1001,18,"wanggang");
			System.out.println(u2.getName());
			
			//ͨ������API��̬������ͨ����
			User u3 = clazz.newInstance();
			//u3.setName("����");
			Method method = clazz.getDeclaredMethod("setName", String.class);
			method.invoke(u3, "����");
			System.out.println(u3.getName());
			
			//ͨ������API��̬��������
			User u4 = clazz.newInstance();
			Field f = clazz.getDeclaredField("name");
			f.setAccessible(true);   //����Ҫ��ȫ���,ֱ�ӷ���
			f.set(u4, "���۰�");
			//ͨ������õ�ֵ
			System.out.println(f.get(u4));

		} catch (SecurityException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
}
