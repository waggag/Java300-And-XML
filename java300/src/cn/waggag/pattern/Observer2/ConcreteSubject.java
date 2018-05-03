package cn.waggag.pattern.Observer2;

import java.util.Observable;
/**
 * Ŀ�����
 * @author waggag
 * 2018��5��3�� ����10:26:49
 */
@SuppressWarnings("all")
public class ConcreteSubject extends Observable{
	private int state;
	
	public void set(int s) {
		state = s; //Ŀ��״̬�����仯
		setChanged(); //��ʾĿ������Ѿ���������
		notifyObservers(state);
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
}
