package cn.waggag.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 统计单词的次数
 * this is a cat that this is a mice 
 * 思路:
 *1.分割字符串
 *2.分拣存储
 *3.查看单词次数
 * * @author 王港
 * 2018年4月10日 下午8:40:23
 */
public class MapCounterWords {
	
	public static void main(String[] args) {
		//分割字符串
		String[] arr = "this is a cat that this is a mice".split(" ");
		//分拣存储
		Map<String,Integer> map = new HashMap<String, Integer>();
		//每个单词
		for(String key: arr)
		{
			System.out.println(key);
			//查看是否存在该单词
//			if(!map.containsKey(key))
//			{
//				map.put(key, 1);
//			}else { 	//存在
//				map.put(key, map.get(key)+1);
//			}
			Integer value = map.get(key);
			if(value == null) {
				map.put(key, 1);
			}else {
				map.put(key, map.get(key)+1);
			}
		}
		//3.查看每个单词出现的次数
		Set<String> keyset = map.keySet();
		Iterator<String> it = keyset.iterator();
		//获取对象
		while(it.hasNext())
		{
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(key+"-->"+value);
		}
		
	}
}
