package cn.waggag.nestedclass;

import cn.waggag.nestedclass.Outer.StaticInnerClass;

/**
 * 测试静态内部类的详细用法
 * @author waggag
 * 2018年4月28日 下午10:04:08
 */
@SuppressWarnings("all")
public class TestStaticClass {
	
	public static void main(String[] args) {
		//Outer.StaticInnerClass osic = new Outer.StaticInnerClass();
		//静态内部类外部类的联系很少，外部类就如同一个包
		StaticInnerClass osic = new StaticInnerClass();
		
	}
	
}

@SuppressWarnings("all")
class Outer{
	
	int c = 5;
	static int d = 6;
	
	void t() {
		StaticInnerClass s= new StaticInnerClass();
	}
	//静态内部类
	public static class StaticInnerClass{
		int a = 3;
		static int b = 5;
		public void test() {
			System.out.println(d);
			//静态内部类不能调用普通成员
			//System.out.println(c);
		}
	}
	
	
	
	
	
	
}
