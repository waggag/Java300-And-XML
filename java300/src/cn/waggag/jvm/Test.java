package cn.waggag.jvm;
/**
 * 测试自定义的FileSystemClassLoader
 * @author waggag
 * 2018年4月27日 下午2:06:48
 */
public class Test {
	
	public static void main(String[] args) throws ClassNotFoundException {
		FileSystemClassLoader loader = new FileSystemClassLoader("E:/myjava");
		FileSystemClassLoader loader2 = new FileSystemClassLoader("E:/myjava");
		
		Class<?> c = loader.loadClass("cn.waggag.jvm.Hello");
		//同一个类被不同的加载器加载,Jvm也认为是不同的类
		Class<?> c2 = loader.loadClass("cn.waggag.jvm.Hello");
		Class<?> c3 = loader2.loadClass("cn.waggag.jvm.Hello");
		
		Class<?> c4 = loader2.loadClass("java.lang.String");
		
		
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		System.out.println(c4.getClassLoader());//引导类加载器
		System.out.println(c3.getClassLoader());//自定义加载器
		
	}




}
