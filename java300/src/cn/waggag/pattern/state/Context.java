package cn.waggag.pattern.state;
/**
 * �������������ͬ��״̬
 * @author waggag
 * 2018��5��2�� ����8:53:55
 */
public class Context {
	
	private State state;
	
	public void setState(State s) {
		System.out.println("�޸�״̬!");
		state = s;
		state.hander();
	}
}
