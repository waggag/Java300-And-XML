package cn.waggag.pattern;

import java.io.Serializable;

/**
 * 测试静态内部类，实现单例模式  好于懒汉式
 * 1.线程安全
 * 2.调用效率高
 * 3.实现了延迟加载
 * @author waggag
 * 2018年4月29日 下午5:44:04
 */
@SuppressWarnings("all")
public class Singleton3 implements Serializable{
	
	private Singleton3() {
	}
	
	private static class SingletonClassInstance{
		private static final Singleton3 instance = new Singleton3();
	}
	
	public static Singleton3 getInstance() {
		return SingletonClassInstance.instance;
	}
}
