package cn.waggag.que;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration的使用
 * 1.判断 hasMoreElements()
 * 2.获取 nextElement()
 * 
 * Vector的elements()的方法
 * @author wagga
 * 2018年4月14日下午12:00:22
 */
public class UsingEnumeration {
	public static void main(String[] args) {
		Vector<String> vector = new Vector<String>();
		vector.add("javase");
		vector.add("html");
		vector.add("oracle");
		
		//便利Vector
		Enumeration<String> en = vector.elements();
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
	}
}
