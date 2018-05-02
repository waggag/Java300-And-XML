package cn.waggag.collections;
/**
 * Map底层实现: 数组+链表
 * @author 王港
 * 2018年4月8日 下午7:35:11
 */
public class MyArrayMap {
	
	MyLinkList[]  array = new MyLinkList[999];
	int size;
	
	public void put(Object key, Object value)
	{
		MyEntry newEntry = new MyEntry(key, value);
		//取得hash值可能为负数,需要做个判断
		int hash = key.hashCode()%999;
		//hash值取正，方便对应数组
		hash = hash < 0 ? -hash : hash;
		
		if(array[hash] == null)
		{
			MyLinkList list = new MyLinkList();
			array[hash] = list;
			array[hash].add(newEntry);
		}else 
		{
			//键重复,直接覆盖原来的值
			MyLinkList list = array[hash];
			for(int i=0;i<list.size();i++)
			{
				MyEntry e = (MyEntry)list.get(i);
				if(e.key.equals(key))
				{
					e.value = value;
					return ;
				}
			}
			array[hash].add(newEntry);
		}
	}
	
	public Object get(Object key)
	{
		int a = key.hashCode()%999;
		
		if(array[a] != null)
		{
			MyLinkList list = array[a];
			for(int i=0;i<list.size();i++)
			{
				MyEntry e = (MyEntry)list.get(i);
				if(e.key.equals(key))
				{
					return e.value;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		MyArrayMap m = new MyArrayMap();
		m.put("王港", "孟爽");
		m.put("王港", "孟  爽");
		System.out.println(m.get("王港"));
	}
}
