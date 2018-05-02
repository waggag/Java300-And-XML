package cn.waggag.javabean;

import java.util.ArrayList;
import java.util.List;
/**
 * javaBean,实体类
 * 一个对象对应一行记录,一个类对应一个表的结构
 * @author 王港
 * 2018年4月10日 下午2:33:30
 */
public class TestJavaBean {
	public static void main(String[] args) {
		
		Students s =new Students(1601110241,"王港",30000,"信息工程学院","2016-09");
		Students s2 =new Students(1601110241,"孟爽",30000,"信息工程学院","2016-09");
		Students s3 =new Students(1601110241,"王港",30000,"信息工程学院","2016-09");
		
		List<Students> list = new ArrayList<Students>();
		list.add(s);
		list.add(s2);
		list.add(s3);
		printStudents(list);
	}
	/**
	 * 打印所有的元素
	 * @param list 存放了很多的数据
	 */
	public static void printStudents(List<Students> list) {
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getName());
			System.out.println(list.get(i).getSno());
		}
	}
}
