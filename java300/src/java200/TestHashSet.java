package java200;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ����Set���÷���
 * @author ����
 * 2018��4��9�� ����8:00:54
 */
public class TestHashSet {

	@SuppressWarnings({ "rawtypes", "unchecked"})
	public static void main(String[] args) {
		/*
		 * Set�в������ظ���Ԫ��
		 */
		Set set = new HashSet();
		set.add("aaa");
		set.add("bbb");
		set.add(new Date());
		set.add(new String("aaa"));
		set.remove("aaa");
		System.out.println(set.contains("aaa"));
		System.out.println(set.size());
		
	}
}
