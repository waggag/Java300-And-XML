package cn.waggag.collections;

import java.util.NoSuchElementException;

/**
 * �Լ�ʵ��һ��ArrayList,����������������
 * @author ����
 * 2018��4��8�� ����1:22:35
 */
public class MyArrayList{
	/**
	 * ���з�����������,����ʹ��
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
		//nun=mMove������Ҫ�ƶ���Ԫ�ظ���
		int numMove = size-index-1;
		//�����ж�,û���뵽,ȷ���Ƿ���Ҫ�ƶ�Ԫ��
		if(numMove>0)
		{
			for(int i=index;i<elementData.length-1;i++)
			{
				elementData[i]=elementData[i+1];
			}
		}
		/**
		 * ʹ��size--,����������ʱ��,size ��Խ��
		 */
		elementData[--size]=null;
	}
	
	public void remove(Object obj)
	{
		/**
		 * �����е�Ԫ���ж�һ��,ʹ��equals����,�ж�Ԫ�ص�ʵ������
		 */
		for(int i=0;i<size;i++)
		{
			if(get(i).equals(obj)) 
			{
				this.remove(i);
			}
		}
	}
	
	//��ָ��λ�÷�����ֵ,�����ؾ�ֵ
	public Object set(int index,Object obj)
	{
		/**
		 * �滻ָ��λ�õ�Ԫ��
		 */
		RangeCheck(index);
		Object oldValue = elementData[index];
		elementData[index] = obj;
		return oldValue;
	}
	/**
	 * ȷ��������Χ����ȷ
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
	 * ȷ�������б��������С
	 */
	private void ensureCapacity()
	{
		//�����Ԫ��֮ǰ�ж��Ƿ�Ԫ����������
		if(size>elementData.length) 
		{
			Object[] newArray = new Object[size*2+1];
			//��ԭ������������ݿ�����������
			//System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			for(int i=0;i<elementData.length;i++)
			{
				newArray[i] = elementData[i];
			}
			elementData = newArray;
		}
	}
		/**
		 * ����Ԫ���������е�λ��
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
	    * ����һ��iterator����
	    * @return  A Object is MyIterator
	    */
	   public MyIterator iterator()
	   {
		   return new MyIterator();
	   }
	 /**
	  * ����һ���ڲ���ʵ�ּ򵥵�Iterator
	  * @author ����
	  * 2018��4��10�� ����4:25:25
	  */
	private class MyIterator 
	{
	       /*
	        * ָ�뵱ǰ��ָ������
	        */
	        int cursor = 0;
	        /*
	         * ָ�����һ��λ��
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
	                //�Ƴ�һ��Ԫ�أ�cursorӦ�ü���1
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
		System.out.println("=======iterator����===============");
		MyIterator iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
			iter.remove();
		}
		
		System.out.println(list.size());
	}

}
