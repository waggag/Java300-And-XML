package cn.waggag.collections;

import java.util.HashMap;

/**
 * �Զ����Լ���HashSet
 * @author ����
 * 2018��4��9�� ����8:16:39
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
	//set�Ĳ����ظ�����������map����ļ����󲻿��ظ�
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
