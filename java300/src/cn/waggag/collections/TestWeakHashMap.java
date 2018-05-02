package cn.waggag.collections;

import java.util.WeakHashMap;

/**
 * WeakHashMap 键为弱类型，gc运行后立即回收
 * @author wagga
 * 2018年4月14日下午1:08:33
 */
public class TestWeakHashMap {
	public static void main(String[] args) {
		WeakHashMap<String,String> map = new WeakHashMap<String, String>();
		//测试数据
		//常量池对象不会回收
		map.put("abc", "a");
		map.put("d", "test");
		
		//gc运行，已被回收
		map.put(new String("waggag"), "c");
		map.put(new String("wggag"), "d");
		
		//通知回收
		System.out.println(map.size());
		System.gc();
		System.runFinalization();
		//
		System.out.println(map.size());
	}
}
