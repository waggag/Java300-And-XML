package cn.waggag.jvm;

import cn.waggag.url.TestUrl;

/**
 * 线程上下文加载器，可以使用SerContextClassLoader可以修改新的加载器
 * @author waggag
 * 2018年4月28日 下午9:16:40
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
