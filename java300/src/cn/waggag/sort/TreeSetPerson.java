package cn.waggag.sort;

import java.util.TreeSet;

public class TreeSetPerson {
	
	public static void main(String[] args) 
	{
		Person p1 = new Person("wanggang", 100);
		Person p2 = new Person("meng", 1000);
		Person p3 = new Person("gang", 1500);
		Person p4 = new Person("wang", 1600);
		/**
		 * 依次存放到TreeSet容器中,使用排序的业务类:匿名内部类
		 */
		TreeSet<Person> persons = new TreeSet<Person>(
				new java.util.Comparator<Person>() {
					
					@Override
					public int compare(Person o1, Person o2) 
					{
						return o1.getHandsome()-o2.getHandsome();
					}
				}
			);
			//在添加数据的时候已经排序
			persons.add(p1);
			persons.add(p2);
			persons.add(p3);
			persons.add(p4);
			//改变数据
			p3.setHandsome(-100);
			
			System.out.println(persons);
	}
}
