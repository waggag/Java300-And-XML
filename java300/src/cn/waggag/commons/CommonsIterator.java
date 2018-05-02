package cn.waggag.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;
import org.apache.commons.collections4.map.HashedMap;

/**迭代器的扩展
 * 1.MapIterator,不再使用map.KeySet,iterator访问
 * 	IterableMap, HashedMap
 * 2.UniqueFilterIterator 去重迭代器
 * 3.FilterIterator 自定义过滤 + Pridicate
 * 4.双向Map,要求Key 和 Value 不能重复
 * 		1.DualTreeBidMap  : 有序
 * 		2.DualHashBidMap  : 无序
 * 测试Commons的Iterator的方法
 * @author waggag
 * 2018年4月15日上午9:07:29
 */
public class CommonsIterator {
	
	public static void main(String[] args) {
		//Mapit();
		//filterIt();
		//loopIt();
		//arrayIt();
		//hashMap();
		treeMap();
	}
	/**
	 * 有序双向Map
	 */
	public static void treeMap() {
		System.out.println("=====有序双向Map======");
		BidiMap<String, String> map = new DualTreeBidiMap<String, String>();
		map.put("wag", "www.waggag.cn");
		map.put("gag", "www.google.com");
		map.put("waggag", "www.baidu.com");
		//遍历查看
		MapIterator<String, String> iter = map.inverseBidiMap().mapIterator();
		while(iter.hasNext()) {
			String key = iter.next();
			String value = iter.getValue();
			System.out.println(key+"-->"+value);
		}
	}
	
	
	/**
	 * 无序双向Map
	 */
	public static void hashMap() {
		System.out.println("=====无序双向Map======");
		BidiMap<String, String> map = new DualHashBidiMap<String, String>();
		map.put("wag", "www.waggag.cn");
		map.put("gag", "www.google.com");
		map.put("waggag", "www.baidu.com");
		//反转,key与value互换
		System.out.println(map.inverseBidiMap().get("www.google.com"));
		MapIterator<String, String> iter = map.inverseBidiMap().mapIterator();
		while(iter.hasNext()) {
			String key = iter.next();
			String value = iter.getValue();
			System.out.println(key+"-->"+value);
		}
	}
	
	
	
	/**
	 * 数组迭代器
	 */
	public static void arrayIt() {
		System.out.println("=========数组迭代器======");
		int[] str = {1,2,3,4,5};
		//数组迭代器,还可以指定开始和结束位置
		Iterator<Integer> iter = new ArrayListIterator<Integer>(str);
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	
	/**
	 * 循环迭代器
	 */
	public static void loopIt() {
		System.out.println("======循环迭代器======");
		List<String> list = new ArrayList<String>();
		list.add("aefer");
		list.add("dad");
		list.add("moom");
		Iterator<String> iter = new LoopingIterator<String>(list);
		for(int i=0;i < 5;i++) {
			System.out.println(iter.next());
		}
	}
	/**
	 * 自定义迭代器
	 */
	public static void filterIt() {
		
		System.out.println("=======自定义迭代器======");
		List<String> list = new ArrayList<String>();
		list.add("aefer");
		list.add("dad");
		list.add("moom");
		//自定义条件判断
		Predicate<String> pre = new Predicate<String>() 
		{
			@Override
			public boolean evaluate(String value) {
				//回文判断
				return new StringBuilder(value).reverse().toString().equals(value);
			}
		};
		//使用自定义的迭代器
		Iterator<String> it =  new FilterIterator<String>(list.iterator(), pre);
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static void uniqueIt() {
		System.out.println("=====去重迭代器======");
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		//去除重复的过滤器 UniqueFilterIterator
		Iterator<String> it =  new UniqueFilterIterator<String>(list.iterator());
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	
	/**
	 * Map迭代器
	 */
	public static void Mapit() {
		System.out.println("=======map迭代器======");
		IterableMap<String, String> map= new HashedMap<String, String>();
		map.put("a", "waggag");
		map.put("b", "wag");
		map.put("c", "gag");
		//使用MapIterator
		MapIterator<String, String> iter = map.mapIterator();
		while(iter.hasNext()) {
			//it.next()会返回一个当前value
			String key = iter.next();
			String value = iter.getValue();
			System.out.println(key+"-->"+value);
		}
	}

}
