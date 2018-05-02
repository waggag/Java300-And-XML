package cn.waggag.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * �Զ���ʵ��Linklist
 * @author ����
 * 2018��4��9�� ����8:51:49
 */
@SuppressWarnings({ "serial", "rawtypes" })
public class MyLinkList extends LinkedList{
	
	private Node first;
	private Node last;
	private int size;
	
	public MyLinkList() {
	}
	
	public boolean add(Object obj) 
	{
		Node n = new Node();
		if(first == null) {
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);
			first = n;
			last = n;
		}else {
			//ֱ����last�ڵ��������µĽڵ�
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);
			last.setNext(n);
			last = n;
		}
		size++;
		return true;
	}
	
	public void add(int index,Object obj)
	{
		RangeCheck(index);
		Node temp = findnode(index);
		Node newNode = new Node();
		newNode.obj = obj;
		if(temp != null) 
		{
			temp.previous.next = newNode ;
			newNode.previous = temp.previous;
			newNode.next = temp;
			temp.previous=newNode;
		}
	}
	public int size() 
	{
		return size;
	}	
	
	public Object get(int index)
	{
		RangeCheck(index);
		Node temp = findnode(index);
		if(temp != null) 
		{
			return temp.obj;
		}
		return null;
	}
	
	public Object remove(int index) 
	{
		Node temp = findnode(index);
		//�ڵ��ɾ��
		if(temp != null)
		{
			temp.previous.next = temp.next;
			temp.next.previous = temp.previous;
		}
		size--;
		return temp;
	}
	//ʹ�ö��ַ��ҵ�node,Ч�ʸ���
	private Node findnode(int index)
	{
		RangeCheck(index);
		Node temp = null;
		if(first != null)
		{
			if(index < (size >> 1)){
				temp = first;
				for(int i=0;i < index;i++) 
				{
					temp = temp.next;	
				}
			}else {
				temp = last;
				for(int i = size-1;i > index;i--) 
				{
					temp = temp.previous;	
				}
			}
			
		}
		return temp;
	}
	
	/**
	 * ȷ��������Χ����ȷ
	 * @param index
	 */
	private void RangeCheck(int index) 
	{
		if(index>=size) 
		{
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		MyLinkList list = new MyLinkList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add(1, "BBB");
		MyIterator iter = list.iterator();
		
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		System.out.println(list.size);
		System.out.println(list.get(1));
	}
	/**
	 * ����һ���Զ���Iterator����
	 */
	 public MyIterator iterator()
	   {
		   return new MyIterator();
	   }
	 /**
	  * �Լ�ʵ�ּ򵥵�Iterator
	  * @author ����
	  * 2018��4��10�� ����4:06:13
	  */
	private class MyIterator implements Iterator<Object> {
	        /**
	         * Index of element to be returned by subsequent call to next.
	         */
	        int cursor = 0;

	        public boolean hasNext() {
	            return cursor != size();
	        }

	        public Object next() {
	            try {
	                int i = cursor;
	                Object next = get(i);
	                cursor = i + 1;
	                return next;
	            } catch (IndexOutOfBoundsException e) {
	              
	                throw new NoSuchElementException();
	            }
	        }
	}
}