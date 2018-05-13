package cn.waggag.jdk9;

public interface NewFeature<T> {
	
	//java7及以前特性  全局变量 和抽象方法
	public static final String a = "22";
	boolean process(T t);
	
	//java 8 特性 静态方法和默认方法
	default void love() {
		System.out.println("java8 特性默认方法");
	}
	static void haha() {
		System.out.println("java8 特性静态方法");
	}
	
	//java8特性支持私有方法
	@SuppressWarnings("unused")
	private void java9(){}
	
	
}
