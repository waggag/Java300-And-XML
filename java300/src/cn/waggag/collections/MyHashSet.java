package cn.waggag.collections;

import java.util.HashMap;

/**
 * 自定义自己的HashSet
 * @author 王港
 * 2018年4月9日 下午8:16:39
 */
public class MyHashSet {
	
	@SuppressWarnings("rawtypes")
	HashMap map;
	private static final Object PRESENT = new Object();
	
	@SuppressWarnings("rawtypes")
	public MyHashSet() 
	{
		map = new HashMap();
	}
	
	public int size() 
	{
		return map.size();
	}
	//set的不可重复就是利用了map里面的键对象不可重复
	@SuppressWarnings("unchecked")
	public void add(Object obj)
	{
		map.put(obj, PRESENT);
	}
	
	public static void main(String[] args) 
	{
		MyHashSet s = new MyHashSet();
		s.add("aaa");
		s.add(new String("aaa"));
		System.out.println(s.size());
		
	}
}
