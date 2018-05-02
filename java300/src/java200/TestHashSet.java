package java200;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 测试Set常用方法
 * @author 王港
 * 2018年4月9日 下午8:00:54
 */
public class TestHashSet {

	@SuppressWarnings({ "rawtypes", "unchecked"})
	public static void main(String[] args) {
		/*
		 * Set中不能有重复的元素
		 */
		Set set = new HashSet();
		set.add("aaa");
		set.add("bbb");
		set.add(new Date());
		set.add(new String("aaa"));
		set.remove("aaa");
		System.out.println(set.contains("aaa"));
		System.out.println(set.size());
		
	}
}
