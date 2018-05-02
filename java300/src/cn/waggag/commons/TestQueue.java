package cn.waggag.commons;

import java.util.Queue;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

/**
 * 1.ѭ������
 * 
 * @author waggag
 * 2018��4��14������8:30:29
 */
public class TestQueue {
	public static void main(String[] args) {
		circular();
		readOnlyQueue();
		predicate();
	}
	/**
	 * ���Զ���
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void  predicate() {
		CircularFifoQueue<String> que = new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Predicate notNull = NotNullPredicate.INSTANCE;
		//��װ�ɶ�Ӧ�Ķ�����
		Queue<String> que2 = PredicatedQueue.predicatedQueue(que, notNull);
		que2.add(null);
	}
	
	
	
	/**
	 * ѭ������
	 */
	public static void circular() {
		
		CircularFifoQueue<String> que = new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		//�鿴
		for(int i=0;i<que.size();i++)
		{
			System.out.println(que.get(i));
		}	
	}
	
	/**
	 * ֻ������
	 */
	public static void readOnlyQueue() {
		CircularFifoQueue<String> que = new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Queue<String> readOnlyQue = UnmodifiableQueue.unmodifiableQueue(que);
		readOnlyQue.add("d");
	}
}

