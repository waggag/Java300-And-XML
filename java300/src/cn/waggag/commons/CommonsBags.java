package cn.waggag.commons;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;

/**
 * Bag �� �����ظ�
 * 1. HashBag ����
 * 2. TreeBag ����
 * ͳ�Ƶ��ʵĳ��ִ���
 * @author waggag
 * 2018��4��15������9:58:21
 */
public class CommonsBags {
	
	public static void main(String[] args) {
		//hashBag();
		//treeBag();
		//ͳ�Ƶ��ʵĴ���
		String[] arr = "this is a cat that this is a mice".split(" ");
		Bag<String> bag = new TreeBag<String>();
		for(String temp: arr) {
			bag.add(temp);
		}
		System.out.println("ͳ�ƴ���");
		Set<String> keys = bag.uniqueSet();
		for(String letter: keys) {
			System.out.println(letter+"-->"+bag.getCount(letter));
		}
		
		
	}
	
	public static void treeBag() {
		System.out.println("=========����İ�========");
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
		System.out.println("=========����İ�========");
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
