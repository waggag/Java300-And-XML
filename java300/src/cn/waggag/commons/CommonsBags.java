package cn.waggag.commons;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;

/**
 * Bag 包 允许重复
 * 1. HashBag 无序
 * 2. TreeBag 有序
 * 统计单词的出现次数
 * @author waggag
 * 2018年4月15日上午9:58:21
 */
public class CommonsBags {
	
	public static void main(String[] args) {
		//hashBag();
		//treeBag();
		//统计单词的次数
		String[] arr = "this is a cat that this is a mice".split(" ");
		Bag<String> bag = new TreeBag<String>();
		for(String temp: arr) {
			bag.add(temp);
		}
		System.out.println("统计次数");
		Set<String> keys = bag.uniqueSet();
		for(String letter: keys) {
			System.out.println(letter+"-->"+bag.getCount(letter));
		}
		
		
	}
	
	public static void treeBag() {
		System.out.println("=========无序的包========");
		Bag<String> bag = new TreeBag<String>();
		bag.add("a");
		bag.add("a", 5);
		bag.remove("a", 3);
		bag.add("b",5);
		bag.add("c",5);
		
		Iterator<String> iter = bag.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}
	
	public static void hashBag() {
		System.out.println("=========无序的包========");
		Bag<String> bag = new HashBag<String>();
		bag.add("a");
		bag.add("a", 5);
		bag.remove("a", 3);
		bag.add("b",5);
		bag.add("c",5);
		
		Iterator<String> iter = bag.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}
}
