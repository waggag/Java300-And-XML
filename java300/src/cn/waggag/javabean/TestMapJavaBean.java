package cn.waggag.javabean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMapJavaBean {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		/**
		 * һ��Map�����Ӧһ�м�¼
		 */
		Map map = new HashMap();
		map.put("id", 1601110241);
		map.put("name", "����");
		map.put("salary", 30000);
		map.put("department", "��Ϣ����ѧԺ");
		
		Map map1 = new HashMap();
		map1.put("id", 1601110241);
		map1.put("name", "��");
		map1.put("salary", 30000);
		map1.put("department", "��Ϣ����ѧԺ");
		
		List<Map> list = new ArrayList<Map>();
		list.add(map);
		list.add(map1);
	}
	
	@SuppressWarnings("rawtypes")
	public static void printStudentsName (List<Map> list) {
		for(int i=0;i<list.size();i++)
		{
			Map temp = list.get(i);
			System.out.println(temp.get("����"));
		}
	}
}
