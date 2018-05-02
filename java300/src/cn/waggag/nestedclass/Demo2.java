package cn.waggag.nestedclass;

/**
 * 测试方法内部类，也叫局部内部类
 * @author waggag
 * 2018年4月28日 下午10:48:23
 */
@SuppressWarnings("all")
public class Demo2 {
	
	public static void main(String[] args) {
		
	}
	public void test() {
		//只在方法中可见，不能又修饰符
		int a = 3;
		class Inner{
			
		}
	}
}