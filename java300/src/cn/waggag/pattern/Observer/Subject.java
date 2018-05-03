package cn.waggag.pattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * �������
 * @author waggag
 * 2018��5��3�� ����10:06:29
 */
public class Subject {
	
	protected List<Observer>  list = new ArrayList<Observer>();
	
	public void register(Observer obs) {
		list.add(obs);
	}
	
	public void remove(Observer obs) {
		list.remove(obs);
	}
	//֪ͨ���еĹ۲��߸���״̬,��ΪĿ��ı��״̬
	public void notifyAllObservers() {
		
		for(Observer obs : list) {
			obs.update(this);
		}
		
	}
	
}
