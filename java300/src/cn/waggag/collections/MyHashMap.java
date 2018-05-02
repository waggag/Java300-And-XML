package cn.waggag.collections;
/**
 * �Զ���ʵ��Map�Ĺ���
 * Map,��ż�ֵ��,���ݼ�������ֵ����
 * @author ����
 * 2018��4��8�� ����6:27:45
 */
public class MyHashMap {
	
	MyEntry[]  array = new MyEntry[10];
	int size;
	
	public void put(Object key, Object value) 
	{	
		/**
		 * map�й涨,��ֵ�����ظ�
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
		m.put("����", "��ˬ");
		m.put("����", "��  ˬ");
		Object w = m.get("����");
		System.out.println(w);
		System.out.println(m.size);
		
	}
}
