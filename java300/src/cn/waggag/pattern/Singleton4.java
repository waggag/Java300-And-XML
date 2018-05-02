package cn.waggag.pattern;
/**
 * 测试枚举模式实现单例模式（没有延时）好于懒汉式
 * @author waggag
 * 2018年4月29日 下午6:31:04
 */
public enum Singleton4 {
	
	//枚举元素本身就是单例对象
	INSTANCE;
	
	//添加自己需要的操作
	public void singletonOperation() {
		
	}
	
}
