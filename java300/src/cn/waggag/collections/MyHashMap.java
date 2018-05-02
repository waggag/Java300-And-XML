package cn.waggag.collections;
/**
 * 自定义实现Map的功能
 * Map,存放价值对,根据键对象找值对象
 * @author 王港
 * 2018年4月8日 下午6:27:45
 */
public class MyHashMap {
	
	MyEntry[]  array = new MyEntry[10];
	int size;
	
	public void put(Object key, Object value) 
	{	
		/**
		 * map中规定,键值不能重复
		 */	
		MyEntry enty = new MyEntry(key,value);
		for(int i=0;i<size;i++)
		{
			if(array[i].key.equals(key))
			{
				array[i].value = value;
				return ;
			}
		}
		array[size++] = enty;
	}
	
	public Object get(Object key)
	{
		for(int i=0;i<size;i++)
		{
			if(array[i].key.equals(key))
				{
					return array[i].value;
				}
		}
		return null;
	}
	
	public void remove(Object key)
	{
		for(int i=0;i<size;i++)
		{
			if(array[i].key.equals(key))
			{
				for(int j=i;i<size-1;j++)
				{
					array[j]=array[j+1];
				}
			}
		}
		size--;
	}
	
	public boolean containsKey(Object key) 
	{
		for(int i=0;i<size;i++)
		{
			if(array[i].key.equals(key))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean containsValue(Object value) 
	{
		for(int i=0;i<size;i++)
		{
			if(array[i].value.equals(value))
			{
				return true;
			}
		}
		return false;
	}
	
	public int size() 
	{
		return size;
	}
	
	public static void main(String[] args) {
		
		MyHashMap m = new MyHashMap();
		m.put("王港", "孟爽");
		m.put("王港", "孟  爽");
		Object w = m.get("王港");
		System.out.println(w);
		System.out.println(m.size);
		
	}
}
