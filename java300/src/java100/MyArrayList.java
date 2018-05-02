package java100;

import java.util.Date;

/**
 * ģ��jdk���ṩ��ArrayList
 * @author ����
 *
 */
public class MyArrayList {
	/**
	 * The value is used for object storage
	 */
	private Object[] value;
	/**
	 * The size is the number of Object used
	 */
	private int size;
	//���췽��
	public MyArrayList() 
	{
		this(10);//������һ��������
	}
	public MyArrayList(int size) 
	{
		if(size < 0)
		{
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		value = new Object[size];
	}
	
	/**
	 * ���һ��Ԫ��
	 * @param obj
	 */
	public void add(Object obj)
	{
		
		value[size] = obj;
		size++;
		if(size>=value.length-1)
		{
			/**
			 * ������������,����
			 */
			int newCapacity = value.length*2;
			Object[] newlist = new Object[newCapacity];
			//System.arraycopy(src, srcPos, dest, destPos, length);
			for(int i=0;i<value.length-1;i++)
			{
				newlist[i] = value[i];
			}
			value = newlist;
		}
	}
	/**
	 * ���ж�index�ڷ�Χ֮��
	 * @param index  
	 * @return
	 */
	public Object get(int index)
	{
		/**
		 * �ֶ��׳�һ���쳣
		 */
		this.rangeCheck(index);
		return value[index];
	}
	/**
	 * ��������Ԫ�صĸ���
	 * @return
	 */
	public int size()
	{
		return size;
	}
	public boolean isEmpty() 
	{
		return size == 0;
	}
	/**
	 * �����ض�Ԫ�ص�����
	 * @param obj
	 * @return
	 */
	public int indexOf(Object obj)
	{
		if(obj == null)
			return -1;
		else {
			for(int i=0;i<value.length;i++)
			{
				if(obj==value[i])
					return i;
			}
			return -1;
		}
	}
	/**
	 * ����Ԫ�شӺ��������
	 * @param obj
	 * @return
	 */
	public int lastindexOf(Object obj)
	{
		if(obj == null)
			return -1;
		else {
			for(int i=value.length;i>0;i--)
			{
				if(obj==value[i])
					return i;
			}
			return -1;
		}
	}
	/**
	 * �����ƶ�λ�õ�Ԫ��
	 * @param index
	 * @param obj
	 * @return 
	 */
	public Object set(int index,Object obj)
	{
		this.rangeCheck(index);
		Object old = value[index];
		value[index] = obj;
		return old;
	}
	private void rangeCheck(int index) 
	{
		if(index<0 || index>size)
		{
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * �ж��Ƿ����һ��Ԫ��
	 * @param obj
	 * @return
	 */
	public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }
	/**
	 * �����б��һ������
	 * @param value
	 * @param size
	 * @return
	 */
	public Object[] toArray(MyArrayList value,int size)
	{
		Object[] newArray =new Object[size];
		for(int i=0;i<value.size;i++)
		{
			newArray[i]=value.get(i);
		}
		return newArray;
	}
	/*public void remove(int index)
	{
		this.rangeCheck(index);
		Object[] newlist=new Object[value.length];
		for(int i=0,j=0;i<value.length;i++,j++)
		{
			if(i==index)
			{
				continue;
			}
			newlist[j]=value[i];
		}
		size--;
	}*/
	public static void main(String[] args) {
		MyArrayList list=new MyArrayList(2);
		list.add("aaa");
		list.add(new Human("����"));
		/**
		 * ����ָ����������Сʱ,�Զ�����
		 */
		list.add(new Date());
		list.add(1);
		System.out.println(list.size);
		System.out.println(list.get(3));
	}
	
}

