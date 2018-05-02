package cn.waggag.collections;

import java.lang.ref.WeakReference;

/**
 * 引用分类： 强，软，弱，虚
 * 
 * @author wagga
 * 2018年4月14日下午1:01:57
 */
public class RefStyle {
	public static void main(String[] args) {
		
		String str = new String("wanggang is very good!");
		//弱引用，管理对象
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc运行前："+wr.get());
		//断开引用
		str = null;
		//通知引用
		System.gc();
		System.runFinalization();
		//对象被回收
		System.out.println("gc运行后："+wr.get());
	}
	public static void testStrong() {
		//字符串常量池，共享，不能回收
		String str = "wanggang is very good!";
		//弱引用，管理对象
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("gc运行前："+wr.get());
		//断开引用
		str = null;
		//通知引用
		System.gc();
		System.runFinalization();
		System.out.println("gc运行后："+wr.get());
	}
}
