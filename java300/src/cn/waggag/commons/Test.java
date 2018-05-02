package cn.waggag.commons;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

/**
 * 1.交集
 * 2.并集
 * 3.差集
 * @author waggag
 * 2018年4月14日下午8:21:23
 */
public class Test {
	
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		Set<Integer> set2 = new HashSet<Integer>();
		set2.add(2);
		set2.add(3);
		set2.add(4);
		
		//并集
		System.out.println("======并集=======");
		Collection<Integer> col = CollectionUtils.union(set1,set2);
		for(Integer temp: col) {
			System.out.println(temp);
		}
		//交集
		System.out.println("=====交集=======");
		//col = CollectionUtils.intersection(set1, set2);
		col = CollectionUtils.retainAll(set1, set2);
		for(Integer temp: col) {
			System.out.println(temp);
		}
		//差集
		System.out.println("=====差集=======");
		col = CollectionUtils.subtract(set1, set2);
		for(Integer temp: col) {
			System.out.println(temp);
		}
	}
}
