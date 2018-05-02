package cn.waggag.commons;

import java.util.Queue;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

/**
 * 1.循环队列
 * 
 * @author waggag
 * 2018年4月14日下午8:30:29
 */
public class TestQueue {
	public static void main(String[] args) {
		circular();
		readOnlyQueue();
		predicate();
	}
	/**
	 * 断言队列
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void  predicate() {
		CircularFifoQueue<String> que = new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Predicate notNull = NotNullPredicate.INSTANCE;
		//包装成对应的队列了
		Queue<String> que2 = PredicatedQueue.predicatedQueue(que, notNull);
		que2.add(null);
	}
	
	
	
	/**
	 * 循环队列
	 */
	public static void circular() {
		
		CircularFifoQueue<String> que = new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		//查看
		for(int i=0;i<que.size();i++)
		{
			System.out.println(que.get(i));
		}	
	}
	
	/**
	 * 只读队列
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

