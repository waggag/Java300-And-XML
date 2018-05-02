package cn.waggag.collections;

import java.util.NoSuchElementException;

/**
 * 自己实现一个ArrayList,加深对于容器的理解
 * @author 王港
 * 2018年4月8日 下午1:22:35
 */
public class MyArrayList{
	/**
	 * 所有方法经过测试,可以使用
	 */
	private Object[] elementData;
	
	private int size;
	
	public MyArrayList() {
		
	}
	
	public MyArrayList(int initalCapacity) 
	{
		if(initalCapacity < 0) 
		{	
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		elementData = new Object[initalCapacity];
	}
	
	public void add(int index,Object obj)
	{
		RangeCheck(index);
		ensureCapacity();
		for(int i=index;i<elementData.length;i++)
		{
			elementData[i+1]=elementData[i];
		}
		elementData[index] = obj;	
		size++;
	}
	
	public void add(Object obj) 
	{
		ensureCapacity();
		elementData[size++] = obj;
	}
	
	public int size() 
	{
		return size;
	}
	
	public boolean isEmpty() 
	{
		return size==0;
	}
	
	public Object get(int index) 
	{
		RangeCheck(index);
		return elementData[index];
	}
	
	public void remove(int index) 
	{
		RangeCheck(index);
		//nun=mMove代表需要移动的元素个数
		int numMove = size-index-1;
		//加上判断,没有想到,确定是否需要移动元素
		if(numMove>0)
		{
			for(int i=index;i<elementData.length-1;i++)
			{
				elementData[i]=elementData[i+1];
			}
		}
		/**
		 * 使用size--,在数组满的时候,size 会越界
		 */
		elementData[--size]=null;
	}
	
	public void remove(Object obj)
	{
		/**
		 * 把所有的元素判断一遍,使用equals方法,判断元素的实际内容
		 */
		for(int i=0;i<size;i++)
		{
			if(get(i).equals(obj)) 
			{
				this.remove(i);
			}
		}
	}
	
	//在指定位置放入新值,并返回旧值
	public Object set(int index,Object obj)
	{
		/**
		 * 替换指定位置的元素
		 */
		RangeCheck(index);
		Object oldValue = elementData[index];
		elementData[index] = obj;
		return oldValue;
	}
	/**
	 * 确定索引范围的正确
	 * @param index
	 */
	private void RangeCheck(int index) 
	{
		if(index >= size) 
		{
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 确保数组列表的容量大小
	 */
	private void ensureCapacity()
	{
		//在添加元素之前判断是否元素容量充足
		if(size>elementData.length) 
		{
			Object[] newArray = new Object[size*2+1];
			//把原数组的所有内容拷贝到新数组
			//System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			for(int i=0;i<elementData.length;i++)
			{
				newArray[i] = elementData[i];
			}
			elementData = newArray;
		}
	}
		/**
		 * 返回元素在数组中的位置
		 * @param obj
		 * @return
		 */
	   public int indexOf(Object obj) 
	   {
	        if (obj == null) 
	        {
	            for (int i = 0; i < size; i++)
	                if (elementData[i]==null)
	                    {
	                		return i;
	                    }
	        } else {
	            for (int i = 0; i < size; i++)
	                if (obj.equals(elementData[i]))
	                    {
	                		return i;
	                    }
	        }
	        return -1;
	    }
	   
	   public int lastIndexOf(Object obj) 
	   {
	        if (obj == null) 
	        {
	            for (int i = size-1; i >= 0; i--)
	                if (elementData[i]==null)
	                    {
	                		return i;
	                    }
	        } else {
	            for (int i = size-1; i >= 0; i--)
	                if (obj.equals(elementData[i]))
	                    {
	                		return i;
	                    }
	        }
	        return -1;
	    }
	   /**
	    * 定义一个iterator方法
	    * @return  A Object is MyIterator
	    */
	   public MyIterator iterator()
	   {
		   return new MyIterator();
	   }
	 /**
	  * 定义一个内部类实现简单的Iterator
	  * @author 王港
	  * 2018年4月10日 下午4:25:25
	  */
	private class MyIterator 
	{
	       /*
	        * 指针当前所指的内容
	        */
	        int cursor = 0;
	        /*
	         * 指针的上一个位置
	         */
	        int lastRet = -1;

	        public boolean hasNext() {
	            return cursor != size();
	        }

	        public Object next() {
	            try {
	                int i = cursor;
	                Object current = get(i);
	                lastRet = i;
	                cursor = i + 1;
	                return current;
	            } catch (IndexOutOfBoundsException e) {
	              
	                throw new NoSuchElementException();
	            }
	        }

	        public void remove() 
	        {
	            if (lastRet < 0)
	                throw new IllegalStateException();  
	            try {
	                MyArrayList.this.remove(lastRet);
	                //移除一个元素，cursor应该减少1
	                if (lastRet < cursor)
	                    cursor--;
	                lastRet = -1;
	            } catch (IndexOutOfBoundsException e) {
	                e.printStackTrace();
	            }
	        }

	    }
	    
	   
	public static void main(String[] args) 
	{
		MyArrayList list = new MyArrayList(3);
		list.add("323");
		list.add("333");
		list.add("343");
		for(int i = 0;i < list.size();i++)
		{
			System.out.println(list.get(i));
		}
		System.out.println("=======iterator方法===============");
		MyIterator iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
			iter.remove();
		}
		
		System.out.println(list.size());
	}

}
