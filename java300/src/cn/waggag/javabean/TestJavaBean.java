package cn.waggag.javabean;

import java.util.ArrayList;
import java.util.List;
/**
 * javaBean,ʵ����
 * һ�������Ӧһ�м�¼,һ�����Ӧһ����Ľṹ
 * @author ����
 * 2018��4��10�� ����2:33:30
 */
public class TestJavaBean {
	public static void main(String[] args) {
		
		Students s =new Students(1601110241,"����",30000,"��Ϣ����ѧԺ","2016-09");
		Students s2 =new Students(1601110241,"��ˬ",30000,"��Ϣ����ѧԺ","2016-09");
		Students s3 =new Students(1601110241,"����",30000,"��Ϣ����ѧԺ","2016-09");
		
		List<Students> list = new ArrayList<Students>();
		list.add(s);
		list.add(s2);
		list.add(s3);
		printStudents(list);
	}
	/**
	 * ��ӡ���е�Ԫ��
	 * @param list ����˺ܶ������
	 */
	public static void printStudents(List<Students> list) {
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getName());
			System.out.println(list.get(i).getSno());
		}
	}
}
