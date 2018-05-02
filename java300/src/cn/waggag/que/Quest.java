package cn.waggag.que;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ʹ�ö���ģ�����д��ҵ��
 * @author wagga
 * 2018��4��14������10:59:27
 */
public class Quest {
	public static void main(String[] args) {
		Queue<Request> que = new ArrayDeque<Request>();
		//ģ���Ŷ����
		for(int i=0;i<10;i++)
		{
			final int num = i;
			que.offer(new Request(){
				@Override
				public void deposit() 
				{
					System.out.println("��"+num+"���ˣ�������ҵ�񣬴����Ϊ"+(Math.random()*1000));
				}
				
			});
		}
		dealWith(que);
	}
	
	//����ҵ��
	public static void dealWith(Queue<Request> que) {
		Request req = null;
		while((req=que.poll()) != null) {
			req.deposit();
		}
	}
	
	
	
}
interface Request{
	//���
	void deposit();
}
