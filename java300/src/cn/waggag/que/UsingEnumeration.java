package cn.waggag.que;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration��ʹ��
 * 1.�ж� hasMoreElements()
 * 2.��ȡ nextElement()
 * 
 * Vector��elements()�ķ���
 * @author wagga
 * 2018��4��14������12:00:22
 */
public class UsingEnumeration {
	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>();
		vector.add("javase");
		vector.add("html");
		vector.add("oracle");
		
		//����Vector
		Enumeration<String> en = vector.elements();
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
	}
}
