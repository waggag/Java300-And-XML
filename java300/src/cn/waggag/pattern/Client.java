package cn.waggag.pattern;
/**
 * 客户端
 * @author waggag
 * 2018年5月2日 上午1:24:16
 */
public class Client {
	public static void main(String[] args) {
		Singleton3 s1 = Singleton3.getInstance();
		Singleton3 s2 = Singleton3.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println(Singleton4.INSTANCE);
	}
}
