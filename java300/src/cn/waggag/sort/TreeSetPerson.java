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
		 * ���δ�ŵ�TreeSet������,ʹ�������ҵ����:�����ڲ���
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
			//��������ݵ�ʱ���Ѿ�����
			persons.add(p1);
			persons.add(p2);
			persons.add(p3);
			persons.add(p4);
			//�ı�����
			p3.setHandsome(-100);
			
			System.out.println(persons);
	}
}
