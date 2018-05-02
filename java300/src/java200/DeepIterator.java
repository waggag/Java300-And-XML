package java200;

import java.util.Arrays;
import java.util.Iterator;

/**
 * һ���������Դ��������������,���Ҽ��뷺��,���ԶԶ������ݲ���
 * @author ����
 * 2018��4��10�� ����7:50:11
 */

public class DeepIterator<E> implements  java.lang.Iterable<E> {
	
	private Object[] elem = new Object[2];
	
	private int size = 0;
	
	/**
	 * �ڲ���,ʵ��Iterator
	 * @author ����
	 * 2018��4��10�� ����7:51:14
	 */
	
	public void add(E str)
	{	
		if(this.size == elem.length)
		{
			elem = Arrays.copyOf(elem, elem.length*2);
		}
		elem[size++] = str;
	}
	
	@SuppressWarnings("hiding")
	private class MyIterator<E> implements Iterator<E>
	{
		private int coursor = -1;
		
		//�ж��Ƿ������һ��
		public boolean hasNext() {
			return coursor+1<this.size();
		}
		//��ȡ��һ��
		@SuppressWarnings("unchecked")
		public E next() {
			coursor++;
			return (E)elem[coursor];
		}
		//ɾ����һ��
		public void remove() {
			System.arraycopy(elem, coursor+1, elem, coursor, size-coursor-1);
			size--;
			coursor--;
		}
		public int size() {
			return size;
		}
	}
	/**
	 * ʹ�÷�������һ���ڲ���
	 * @return
	 */
	public Iterator<E> iterator() {
		return new MyIterator<E>();
	}
	/**
	 * ʹ���ڲ���,�൱�ھֲ�����
	 * @return
	 */
	public Iterator<E> iterator2() {
		@SuppressWarnings("hiding")
		class MyIterator<E> implements Iterator<E>
		{
			private int coursor = -1;
			
			//�ж��Ƿ������һ��
			public boolean hasNext() {
				return coursor+1<this.size();
			}
			//��ȡ��һ��
			@SuppressWarnings("unchecked")
			public E next() {
				coursor++;
				return (E)elem[coursor];
			}
			//ɾ����һ��
			public void remove() {
				System.arraycopy(elem, coursor+1, elem, coursor, size-coursor-1);
				size--;
				coursor--;
			}
			public int size() {
				return size;
			}
		}
		return new MyIterator<E>();
	}
	/**
	 * ʹ�������ڲ���
	 * @return
	 */
	public Iterator<E> iterator3() {
		return new Iterator<E>() 
			{
				private int coursor = -1;
				//�ж��Ƿ������һ��
				public boolean hasNext() {
					return coursor+1<this.size();
				}
				//��ȡ��һ��
				@SuppressWarnings("unchecked")
				public E next() {
					coursor++;
					return (E)elem[coursor];
				}
				//ɾ����һ��
				public void remove() {
					System.arraycopy(elem, coursor+1, elem, coursor, size-coursor-1);
					size--;
					coursor--;
				}
				public int size() {
					return size;
				}
		};
	}
	
	public static void main(String[] args) {
		/**
		 * ���뷺��,����ʹ�ö�������
		 */
		DeepIterator<Integer> list = new DeepIterator<Integer>();
		list.add(1);  //int--->Integer
		list.add(2);
		list.add(3);
		Iterator<Integer> it = list.iterator3();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//��ǿForѭ������ʵ��iterator����
		for(Object str: list)
		{
			System.out.println(str);
		}
		System.out.println("------------------");
		DeepIterator<String> list1 = new DeepIterator<String>();
		list1.add("����");
		list1.add("����");
		list1.add("����");
		list1.add("��ʿ��");
		for(Object obj: list1) {
			System.out.println(obj);
		}
	}
}
