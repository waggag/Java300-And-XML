package cn.waggag.pattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 测试反射和反序列化破解单例模式
 * @author waggag
 * 2018年4月29日 下午6:50:01
 */
@SuppressWarnings("all")
public class Client2 {
	public static void main(String[] args) throws Exception {
		Singleton2 s1 = Singleton2.getInstance();
		Singleton2 s2 = Singleton2.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		
		//通过反射，跳过了单例模式,直接调用私有构造器
//		Class<Singleton2> clazz = (Class<Singleton2>) Class.forName("cn.waggag.pattern.Singleton2");
//		Constructor<Singleton2> c = clazz.getDeclaredConstructor();
//		c.setAccessible(true);
//		Singleton2 s3 = c.newInstance();
//		Singleton2 s4 = c.newInstance();
//		System.out.println(s3);
//		System.out.println(s4);
		
		//通过反序列化破解单例模式
		FileOutputStream fos = new FileOutputStream("E:/a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.close();
		fos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e:/a.txt"));
		Singleton2 s3 = (Singleton2) ois.readObject();
		System.out.println(s3);
		
		
	}
}
