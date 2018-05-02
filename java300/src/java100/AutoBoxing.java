package java100;
/**
 * 测试自动装箱和拆箱
 * @author 王港
 *
 */
public class AutoBoxing {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//Integer i = new Integer(123);
		/**
		 * jdk5.0之后,编译器会自动改进代码Integer a=new Integer(1000);
		 */
		Integer a = 1000; 
		System.out.println(a);
		//编译器改进为 new Integer(100).intValue
		int c = new Integer(100);
		System.out.println(c);
		
		Integer d=1234;
		Integer d2=1234;
		System.out.println(d==d2);
		System.out.println(d.equals(d2));
		System.out.println("###############");
		/**
		 * [-128,127]之间的数,仍然当作基本数据类型来处理
		 */
		Integer d3=-128;
		Integer d4=-128;
		System.out.println(d3==d4);
		System.out.println(d3.equals(d4));
	}
}
