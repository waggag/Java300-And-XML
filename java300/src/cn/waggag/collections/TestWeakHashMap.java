package cn.waggag.collections;

import java.util.WeakHashMap;

/**
 * WeakHashMap ��Ϊ�����ͣ�gc���к���������
 * @author wagga
 * 2018��4��14������1:08:33
 */
public class TestWeakHashMap {
	public static void main(String[] args) {
		WeakHashMap<String,String> map = new WeakHashMap<String, String>();
		//��������
		//�����ض��󲻻����
		map.put("abc", "a");
		map.put("d", "test");
		
		//gc���У��ѱ�����
		map.put(new String("waggag"), "c");
		map.put(new String("wggag"), "d");
		
		//֪ͨ����
		System.out.println(map.size());
		System.gc();
		System.runFinalization();
		//
		System.out.println(map.size());
	}
}
