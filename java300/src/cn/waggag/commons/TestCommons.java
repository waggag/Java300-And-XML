package cn.waggag.commons;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.EqualPredicate;

/**
 * 测试 Apache Commons Collections
 * 函数式编程之Predicate 断言
 * @author waggag
 * 2018年4月14日下午7:40:06
 */
public class TestCommons {
	
	public static void main(String[] args) {
		System.out.println("=========相等判断========");
		Predicate<String> pre = new EqualPredicate<String>("waggag");
		boolean flag = pre.evaluate("wag");
		System.out.println(flag);
	}
}
