package cn.waggag.jvm;
/**
 * �����Զ����FileSystemClassLoader
 * @author waggag
 * 2018��4��27�� ����2:06:48
 */
public class Test {
	
	public static void main(String[] args) throws ClassNotFoundException {
		FileSystemClassLoader loader = new FileSystemClassLoader("E:/myjava");
		FileSystemClassLoader loader2 = new FileSystemClassLoader("E:/myjava");
		
		Class<?> c = loader.loadClass("cn.waggag.jvm.Hello");
		//ͬһ���౻��ͬ�ļ���������,JvmҲ��Ϊ�ǲ�ͬ����
		Class<?> c2 = loader.loadClass("cn.waggag.jvm.Hello");
		Class<?> c3 = loader2.loadClass("cn.waggag.jvm.Hello");
		
		Class<?> c4 = loader2.loadClass("java.lang.String");
		
		
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		System.out.println(c4.getClassLoader());//�����������
		System.out.println(c3.getClassLoader());//�Զ��������
		
	}




}
