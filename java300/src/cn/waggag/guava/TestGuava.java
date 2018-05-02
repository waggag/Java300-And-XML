package cn.waggag.guava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * 只读设置
 * @author wagga
 * 2018年4月14日下午3:59:33
 */
public class TestGuava {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		//对原有的list进行包装，相当于一个视图，不够安全
		List<String> readList = Collections.unmodifiableList(list);
		readList.add("d");
		//改变原有的List,视图也一起改变
		list.add("d");
		
		//对比查看 初始化List
		List<String> immutableList = ImmutableList.of("a", "b", "c");
		//不能添加元素
		immutableList.add("d");
	}
}
