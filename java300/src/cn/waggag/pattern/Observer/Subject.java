package cn.waggag.pattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题对象
 * @author waggag
 * 2018年5月3日 上午10:06:29
 */
public class Subject {
	
	protected List<Observer>  list = new ArrayList<Observer>();
	
	public void register(Observer obs) {
		list.add(obs);
	}
	
	public void remove(Observer obs) {
		list.remove(obs);
	}
	//通知所有的观察者更新状态,变为目标改变的状态
	public void notifyAllObservers() {
		
		for(Observer obs : list) {
			obs.update(this);
		}
		
	}
	
}
