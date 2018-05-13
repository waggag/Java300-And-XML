package cn.waggag.pattern;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 懒汉式模式的实现   单例对象立即加载
 * 特点：线程安全，调用效率高，延时加载的优势
 * @author waggag
 * 2018年4月29日 下午4:36:08
 */
@SuppressWarnings("serial")
public class Singleton2 implements Serializable{
	
	//类初始化时，不初始化这个对象，真正用到的时候才加载
	private static Singleton2 instance;
	
	//私有化构造器
	private Singleton2() {
		//防止反射破坏单例
		if(instance != null) {
			throw new RuntimeException();
		}
	}
	
	//使用同步，调用效率低
	public static synchronized Singleton2 getInstance() {
		if(instance == null){
			instance = new Singleton2();
		}
		return instance;
	}
	
	//反序列化-------------时直接返回已经创建的实例,实现readResolve()
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}
	
}
