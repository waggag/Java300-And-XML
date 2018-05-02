package java200;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 一个容器可以创建多个迭代对象,并且加入泛型,可以对多种数据操作
 * @author 王港
 * 2018年4月10日 下午7:50:11
 */

public class DeepIterator<E> implements  java.lang.Iterable<E> {
	
	private Object[] elem = new Object[2];
	
	private int size = 0;
	
	/**
	 * 内部类,实现Iterator
	 * @author 王港
	 * 2018年4月10日 下午7:51:14
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
		
		//判断是否存在下一个
		public boolean hasNext() {
			return coursor+1<this.size();
		}
		//获取下一个
		@SuppressWarnings("unchecked")
		public E next() {
			coursor++;
			return (E)elem[coursor];
		}
		//删除下一个
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
	 * 使用方法返回一个内部类
	 * @return
	 */
	public Iterator<E> iterator() {
		return new MyIterator<E>();
	}
	/**
	 * 使用内部类,相当于局部变量
	 * @return
	 */
	public Iterator<E> iterator2() {
		@SuppressWarnings("hiding")
		class MyIterator<E> implements Iterator<E>
		{
			private int coursor = -1;
			
			//判断是否存在下一个
			public boolean hasNext() {
				return coursor+1<this.size();
			}
			//获取下一个
			@SuppressWarnings("unchecked")
			public E next() {
				coursor++;
				return (E)elem[coursor];
			}
			//删除下一个
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
	 * 使用匿名内部类
	 * @return
	 */
	public Iterator<E> iterator3() {
		return new Iterator<E>() 
			{
				private int coursor = -1;
				//判断是否存在下一个
				public boolean hasNext() {
					return coursor+1<this.size();
				}
				//获取下一个
				@SuppressWarnings("unchecked")
				public E next() {
					coursor++;
					return (E)elem[coursor];
				}
				//删除下一个
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
		 * 加入泛型,可以使用多种类型
		 */
		DeepIterator<Integer> list = new DeepIterator<Integer>();
		list.add(1);  //int--->Integer
		list.add(2);
		list.add(3);
		Iterator<Integer> it = list.iterator3();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//增强For循环必须实现iterator方法
		for(Object str: list)
		{
			System.out.println(str);
		}
		System.out.println("------------------");
		DeepIterator<String> list1 = new DeepIterator<String>();
		list1.add("王港");
		list1.add("马云");
		list1.add("马化腾");
		list1.add("马士兵");
		for(Object obj: list1) {
			System.out.println(obj);
		}
	}
}
