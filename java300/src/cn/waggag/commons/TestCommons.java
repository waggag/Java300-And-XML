package cn.waggag.commons;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.EqualPredicate;

/**
 * ���� Apache Commons Collections
 * ����ʽ���֮Predicate ����
 * @author waggag
 * 2018��4��14������7:40:06
 */
public class TestCommons {
	
	public static void main(String[] args) {
		System.out.println("=========����ж�========");
		Predicate<String> pre = new EqualPredicate<String>("waggag");
		boolean flag = pre.evaluate("wag");
		System.out.println(flag);
	}
}
