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

/**����������չ
 * 1.MapIterator,����ʹ��map.KeySet,iterator����
 * 	IterableMap, HashedMap
 * 2.UniqueFilterIterator ȥ�ص�����
 * 3.FilterIterator �Զ������ + Pridicate
 * 4.˫��Map,Ҫ��Key �� Value �����ظ�
 * 		1.DualTreeBidMap  : ����
 * 		2.DualHashBidMap  : ����
 * ����Commons��Iterator�ķ���
 * @author waggag
 * 2018��4��15������9:07:29
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
	 * ����˫��Map
	 */
	public static void treeMap() {
		System.out.println("=====����˫��Map======");
		BidiMap<String, String> map = new DualTreeBidiMap<String, String>();
		map.put("wag", "www.waggag.cn");
		map.put("gag", "www.google.com");
		map.put("waggag", "www.baidu.com");
		//�����鿴
		MapIterator<String, String> iter = map.inverseBidiMap().mapIterator();
		while(iter.hasNext()) {
			String key = iter.next();
			String value = iter.getValue();
			System.out.println(key+"-->"+value);
		}
	}
	
	
	/**
	 * ����˫��Map
	 */
	public static void hashMap() {
		System.out.println("=====����˫��Map======");
		BidiMap<String, String> map = new DualHashBidiMap<String, String>();
		map.put("wag", "www.waggag.cn");
		map.put("gag", "www.google.com");
		map.put("waggag", "www.baidu.com");
		//��ת,key��value����
		System.out.println(map.inverseBidiMap().get("www.google.com"));
		MapIterator<String, String> iter = map.inverseBidiMap().mapIterator();
		while(iter.hasNext()) {
			String key = iter.next();
			String value = iter.getValue();
			System.out.println(key+"-->"+value);
		}
	}
	
	
	
	/**
	 * ���������
	 */
	public static void arrayIt() {
		System.out.println("=========���������======");
		int[] str = {1,2,3,4,5};
		//���������,������ָ����ʼ�ͽ���λ��
		Iterator<Integer> iter = new ArrayListIterator<Integer>(str);
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	
	/**
	 * ѭ��������
	 */
	public static void loopIt() {
		System.out.println("======ѭ��������======");
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
	 * �Զ��������
	 */
	public static void filterIt() {
		
		System.out.println("=======�Զ��������======");
		List<String> list = new ArrayList<String>();
		list.add("aefer");
		list.add("dad");
		list.add("moom");
		//�Զ��������ж�
		Predicate<String> pre = new Predicate<String>() 
		{
			@Override
			public boolean evaluate(String value) {
				//�����ж�
				return new StringBuilder(value).reverse().toString().equals(value);
			}
		};
		//ʹ���Զ���ĵ�����
		Iterator<String> it =  new FilterIterator<String>(list.iterator(), pre);
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static void uniqueIt() {
		System.out.println("=====ȥ�ص�����======");
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		//ȥ���ظ��Ĺ����� UniqueFilterIterator
		Iterator<String> it =  new UniqueFilterIterator<String>(list.iterator());
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	
	/**
	 * Map������
	 */
	public static void Mapit() {
		System.out.println("=======map������======");
		IterableMap<String, String> map= new HashedMap<String, String>();
		map.put("a", "waggag");
		map.put("b", "wag");
		map.put("c", "gag");
		//ʹ��MapIterator
		MapIterator<String, String> iter = map.mapIterator();
		while(iter.hasNext()) {
			//it.next()�᷵��һ����ǰvalue
			String key = iter.next();
			String value = iter.getValue();
			System.out.println(key+"-->"+value);
		}
	}

}
