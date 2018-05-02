package cn.waggag.nestedclass;

public class Demo1 {
	public static void main(String[] args) {
		//不能直接new 内部类对象
		Out out = new Out();
		Out.InnerClass ic = out.new InnerClass();
		ic.test();
	}
	
}

class Out{
	
	private int a = 3;
	int b = 10;
	//成员内部类(不能有静态成员，除非为常量final,赋值表达式必须也为常量)
	//1.可以直接辅助外部类的成员  
	//2.可以直接辅助外部类
	class InnerClass{
		void test() {
			System.out.println(a);
			//必须先又外部类对象才有内部类对象
			System.out.println("内部类对象"+this);
			//引用了外部类的对象
			System.out.println("外部类对象"+Out.this);
		}
	}
}