package cn.waggag.pattern.Observer2;

import java.util.Observable;
/**
 * 目标对象
 * @author waggag
 * 2018年5月3日 上午10:26:49
 */
@SuppressWarnings("all")
public class ConcreteSubject extends Observable{
	private int state;
	
	public void set(int s) {
		state = s; //目标状态发生变化
		setChanged(); //表示目标对象已经做出更改
		notifyObservers(state);
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
}
