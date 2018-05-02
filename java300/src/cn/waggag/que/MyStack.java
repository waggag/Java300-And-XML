package cn.waggag.que;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ʹ�ö����Զ����ջ
 * @author wagga
 * 2018��4��14������11:45:36
 * @param <E>
 */
public class MyStack<E> {
	//����
	private Deque<E> container = new ArrayDeque<E>();
	//����
	private int cap;
	public MyStack(int cap)
	{
		super();
		this.cap=cap;
	}
	//ѹջ
	public boolean push(E e)
	{
		if(container.size()+1 > cap) {
			return false;
		}
		return container.offerLast(e);
	}
	//��ջ
	public E pop() {
		return container.pollLast();
	}
	
	//��ȡ
	public E peek() {
		return container.peekLast();
	}
	public int size() {
		return this.container.size();
	}

}
