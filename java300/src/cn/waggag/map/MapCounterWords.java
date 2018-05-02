package cn.waggag.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * ͳ�Ƶ��ʵĴ���
 * this is a cat that this is a mice 
 * ˼·:
 *1.�ָ��ַ���
 *2.�ּ�洢
 *3.�鿴���ʴ���
 * * @author ����
 * 2018��4��10�� ����8:40:23
 */
public class MapCounterWords {
	
	public static void main(String[] args) {
		//�ָ��ַ���
		String[] arr = "this is a cat that this is a mice".split(" ");
		//�ּ�洢
		Map<String,Integer> map = new HashMap<String, Integer>();
		//ÿ������
		for(String key: arr)
		{
			System.out.println(key);
			//�鿴�Ƿ���ڸõ���
//			if(!map.containsKey(key))
//			{
//				map.put(key, 1);
//			}else { 	//����
//				map.put(key, map.get(key)+1);
//			}
			Integer value = map.get(key);
			if(value == null) {
				map.put(key, 1);
			}else {
				map.put(key, map.get(key)+1);
			}
		}
		//3.�鿴ÿ�����ʳ��ֵĴ���
		Set<String> keyset = map.keySet();
		Iterator<String> it = keyset.iterator();
		//��ȡ����
		while(it.hasNext())
		{
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(key+"-->"+value);
		}
		
	}
}
