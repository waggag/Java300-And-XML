package cn.waggag.reflect;
/**
 * 测试各种类型的对象的获取方式
 * @author waggag
 * 2018年4月24日 下午1:54:46
 */
@SuppressWarnings("all")
public class TestReflect2 {
	
	public static void main(String[] args) {
		String path = "cn.waggag.reflect.User";
		try {
			
			Class clazz = Class.forName(path);
			Class clazz2 = Class.forName(path);
			//对象,表示或封装一些数据,一个类被加载后,Jvm会创建一个对应的该类的Class对象
			//类的整个结构信息会加载到对应的Class对象中
			System.out.println(clazz.hashCode());//一个类只对应的一个反射对象
			System.out.println(clazz2.hashCode());
			
			Class strClazz = String.class;
			Class strClazz2 = path.getClass();
			System.out.println(strClazz==strClazz2);
			
			Class intClazz = int.class;
			
			int[] a = new int[10];
			int[] b = new int[30];
			int[][] c = new int[30][30];
			
			System.out.println(a.getClass().hashCode());
			System.out.println(b.getClass().hashCode());
			System.out.println(c.getClass().hashCode());
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
}
