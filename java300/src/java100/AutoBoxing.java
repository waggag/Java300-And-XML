package java100;
/**
 * �����Զ�װ��Ͳ���
 * @author ����
 *
 */
public class AutoBoxing {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//Integer i = new Integer(123);
		/**
		 * jdk5.0֮��,���������Զ��Ľ�����Integer a=new Integer(1000);
		 */
		Integer a = 1000; 
		System.out.println(a);
		//�������Ľ�Ϊ new Integer(100).intValue
		int c = new Integer(100);
		System.out.println(c);
		
		Integer d=1234;
		Integer d2=1234;
		System.out.println(d==d2);
		System.out.println(d.equals(d2));
		System.out.println("###############");
		/**
		 * [-128,127]֮�����,��Ȼ����������������������
		 */
		Integer d3=-128;
		Integer d4=-128;
		System.out.println(d3==d4);
		System.out.println(d3.equals(d4));
	}
}
