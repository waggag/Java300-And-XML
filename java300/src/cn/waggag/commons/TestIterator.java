package cn.waggag.commons;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestIterator {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		//通过索引遍历List
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
		//通过迭代器遍历List
		for(Iterator iter = list.iterator();iter.hasNext();)
		{
			System.out.println(iter.next());
		}
		
		Set set = new HashSet();
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		
		//通过迭代器遍历Set,while and For two Methods
 		Iterator iter = set.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
		for(Iterator iter1 = set.iterator();iter1.hasNext();)
		{
			System.out.println(iter1.next());
		}
	}
}
