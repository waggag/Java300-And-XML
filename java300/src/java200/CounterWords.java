package java200;

import java.util.HashMap;
import java.util.Map;

public class CounterWords {
	
	public static void main(String[] args) {
		
		String[] arr = "this is a cat that this is a mice".split(" ");
		Map<String,Letter> map = new HashMap<String, Letter>();
		
		for(String key: arr)
		{
			/*第一种方法
			if(!map.containsKey(key))
			{
				map.put(key, new Letter(key));
			}
			Letter value = map.get(key);
			value.setCounter(value.getCounter()+1);
			*/
			Letter value = map.get(key);
			if(null == map.get(key))
			{
				value = new Letter();
				map.put(key, value);
			}
			//如果存在,则Counter的值++
			value.setCounter(value.getCounter()+1);
		}
		for(String key: map.keySet())
		{
			Letter value = map.get(key);
			System.out.println(key+"-->"+value.getCounter());
		}
		
	}	
	
}
