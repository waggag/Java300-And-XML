package java200;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型的入门
 * 1.泛型: 标签,泛化类型
 * @author 王港
 * 2018年4月10日 下午5:18:25
 */
public class Simple {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		//安全
		//list.add(1);  会自动的进行类型转换
		list.add("So easy!");
		String str = list.get(0);
		System.out.println(str);
		
		//jdk1.4之前
//		List list2 = new ArrayList();
//		list2.add(1);
//		list2.add("old");
//		Integer num = (Integer)list.get(1);
	}
}
