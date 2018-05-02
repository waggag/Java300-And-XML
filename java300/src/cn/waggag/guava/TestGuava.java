package cn.waggag.guava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * ֻ������
 * @author wagga
 * 2018��4��14������3:59:33
 */
public class TestGuava {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		//��ԭ�е�list���а�װ���൱��һ����ͼ��������ȫ
		List<String> readList = Collections.unmodifiableList(list);
		readList.add("d");
		//�ı�ԭ�е�List,��ͼҲһ��ı�
		list.add("d");
		
		//�ԱȲ鿴 ��ʼ��List
		List<String> immutableList = ImmutableList.of("a", "b", "c");
		//�������Ԫ��
		immutableList.add("d");
	}
}
