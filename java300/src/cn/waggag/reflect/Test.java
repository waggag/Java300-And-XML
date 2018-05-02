package cn.waggag.reflect;
/**
 * 创建实例，调用空构造
 * @author wagga
 * 2018年4月22日 下午7:32:34
 */
public class Test {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz = Class.forName("java.lang.String");
		//调用空构造
		String str = (String) clz.newInstance();
		System.out.println(str);
	}
}
