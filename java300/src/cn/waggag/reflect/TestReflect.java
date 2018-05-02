package cn.waggag.reflect;
/**
 * 测试Reflect的使用
 * 
 * 获取结构信息Class对象（源头）
 * @author wagga
 * 2018年4月22日 下午7:27:22
 */
public class TestReflect {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException {
		String str = "abc";
		//Class对象
		Class <?> clz = str.getClass();
		//类.class
		clz = String.class;
		//完整路径
		clz = Class.forName("java.lang.String");
	}
}
