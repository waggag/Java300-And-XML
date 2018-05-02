package cn.waggag.javabean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMapJavaBean {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		/**
		 * 一个Map对象对应一行记录
		 */
		Map map = new HashMap();
		map.put("id", 1601110241);
		map.put("name", "王港");
		map.put("salary", 30000);
		map.put("department", "信息工程学院");
		
		Map map1 = new HashMap();
		map1.put("id", 1601110241);
		map1.put("name", "孟");
		map1.put("salary", 30000);
		map1.put("department", "信息工程学院");
		
		List<Map> list = new ArrayList<Map>();
		list.add(map);
		list.add(map1);
	}
	
	@SuppressWarnings("rawtypes")
	public static void printStudentsName (List<Map> list) {
		for(int i=0;i<list.size();i++)
		{
			Map temp = list.get(i);
			System.out.println(temp.get("名字"));
		}
	}
}
