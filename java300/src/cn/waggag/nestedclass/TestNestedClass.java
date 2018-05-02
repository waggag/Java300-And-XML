package cn.waggag.nestedclass;
/**
 * 测试内部类
 * @author waggag
 * 2018年4月28日 下午9:52:07
 */
@SuppressWarnings("all")
public class TestNestedClass {
	
	public static void main(String[] args) {
		TestNestedClass c = new TestNestedClass();
	}
	
	//静态内部类，让外部类使用
	@SuppressWarnings("all")
	private static class StaticNestedClass{
		
	}
	
	//成员内部类
	@SuppressWarnings("all")
	private class FiledInnerClass{
		
	}
	
	void sayHello() {
		
		//局部内部类
		@SuppressWarnings("all")
		class LocalClass{
			
		}
		
		//匿名内部类  定义了内部类，创建了内部类的对象
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
			}
		};
		
		
	}
	
	
	
}
