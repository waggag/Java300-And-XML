package java200;

import java.util.ArrayList;
import java.util.List;

/**
 * ���͵�����
 * 1.����: ��ǩ,��������
 * @author ����
 * 2018��4��10�� ����5:18:25
 */
public class Simple {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		//��ȫ
		//list.add(1);  ���Զ��Ľ�������ת��
		list.add("So easy!");
		String str = list.get(0);
		System.out.println(str);
		
		//jdk1.4֮ǰ
//		List list2 = new ArrayList();
//		list2.add(1);
//		list2.add("old");
//		Integer num = (Integer)list.get(1);
	}
}
