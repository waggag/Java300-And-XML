package cn.waggag.pattern.Observer;

public class ConcreteSubject extends Subject{
	
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		//目标对象值发生变化,更新所有的观察者
		this.notifyAllObservers();
	}
	
}
