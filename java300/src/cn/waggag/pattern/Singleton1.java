package cn.waggag.pattern;
/**
 * 饿汉式模式的实现   单例对象立即加载
 * 特点：线程安全，调用效率高，
 * 缺点：没有延时加载的优势
 * @author waggag
 * 2018年4月29日 下午4:25:32
 */
public class Singleton1 {
	//立即初始化这个对象
	private static Singleton1 instacnce = new Singleton1();
	
	//私有化构造器
	private Singleton1 () {} 
	
	public static Singleton1  getInstance() {
		return instacnce;
	}
}
