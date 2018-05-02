package cn.waggag.collections;
/**
 * Map�ײ�ʵ��: ����+����
 * @author ����
 * 2018��4��8�� ����7:35:11
 */
public class MyArrayMap {
	
	MyLinkList[]  array = new MyLinkList[999];
	int size;
	
	public void put(Object key, Object value)
	{
		MyEntry newEntry = new MyEntry(key, value);
		//ȡ��hashֵ����Ϊ����,��Ҫ�����ж�
		int hash = key.hashCode()%999;
		//hashֵȡ���������Ӧ����
		hash = hash < 0 ? -hash : hash;
		
		if(array[hash] == null)
		{
			MyLinkList list = new MyLinkList();
			array[hash] = list;
			array[hash].add(newEntry);
		}else 
		{
			//���ظ�,ֱ�Ӹ���ԭ����ֵ
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
		m.put("����", "��ˬ");
		m.put("����", "��  ˬ");
		System.out.println(m.get("����"));
	}
}
