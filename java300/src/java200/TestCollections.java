package java200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ʹ��Collections�ĳ��÷���
 * 1.ϴ��,ģ�⶷����
 * @author ����
 * 2018��4��13�� ����9:03:53
 */
public class TestCollections {
	
		public static void main(String[] args) {
			List<Integer>  list = new ArrayList<Integer>();
			//shuffle ϴ��,ģ�⶷����
			for(int i=0;i < 54;i++)
			{
				list.add(i);
			}
			//ϴ��
			Collections.shuffle(list);
			//���η���
			List<Integer> p1 = new ArrayList<Integer>();
			List<Integer> p2 = new ArrayList<Integer>();
			List<Integer> p3 = new ArrayList<Integer>();
			List<Integer> last = new ArrayList<Integer>();
			for(int i=0;i<54;i+=3)
			{
				p1.add(list.get(i));
				p2.add(list.get(i+1));
				p3.add(list.get(i+2));
			}
			//�������Ϊ����
			last.add(list.get(51));
			last.add(list.get(52));
			last.add(list.get(53));
			//��������˵ĸ�����
			System.out.println("��һ����:"+p1);
			System.out.println("�ڶ�����:"+p2);
			System.out.println("��������:"+p3);
			System.out.println("����:"+last);
		}
}
