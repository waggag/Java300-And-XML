package cn.waggag.jvm;

import cn.waggag.url.TestUrl;

/**
 * �߳������ļ�����������ʹ��SerContextClassLoader�����޸��µļ�����
 * @author waggag
 * 2018��4��28�� ����9:16:40
 */
public class ThreadLoader {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException {
		
		ClassLoader loader = ThreadLoader.class.getClassLoader();
		System.out.println(loader);
		
		ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
		System.out.println(loader2);
		
		Thread.currentThread().setContextClassLoader(new FileSystemClassLoader("E:/myjava/"));
		System.out.println(Thread.currentThread().getContextClassLoader());
		
		Class<TestUrl> c = (Class<TestUrl>) Thread.currentThread().getContextClassLoader().loadClass("cn.waggag.url.TestUrl");
		System.out.println(c);
		System.out.println(c.getClassLoader());
	
	
	}
	
	
	
}
