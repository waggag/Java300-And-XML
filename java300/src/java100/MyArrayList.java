package java100;

import java.util.Date;

/**
 * 模拟jdk中提供的ArrayList
 * @author 王港
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
	//构造方法
	public MyArrayList() 
	{
		this(10);//调用另一个构造器
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
	 * 添加一个元素
	 * @param obj
	 */
	public void add(Object obj)
	{
		
		value[size] = obj;
		size++;
		if(size>=value.length-1)
		{
			/**
			 * 数组容量不够,扩容
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
	 * 先判断index在范围之类
	 * @param index  
	 * @return
	 */
	public Object get(int index)
	{
		/**
		 * 手动抛出一个异常
		 */
		this.rangeCheck(index);
		return value[index];
	}
	/**
	 * 返回数组元素的个数
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
	 * 返回特定元素的索引
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
	 * 返回元素从后面的索引
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
	 * 设置制定位置的元素
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
	 * 判断是否包含一个元素
	 * @param obj
	 * @return
	 */
	public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }
	/**
	 * 返回列表的一个数组
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
		list.add(new Human("王港"));
		/**
		 * 超过指定的容量大小时,自动扩容
		 */
		list.add(new Date());
		list.add(1);
		System.out.println(list.size);
		System.out.println(list.get(3));
	}
	
}

