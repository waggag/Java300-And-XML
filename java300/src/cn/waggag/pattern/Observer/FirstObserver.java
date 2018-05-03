package cn.waggag.pattern.Observer;

public class FirstObserver implements Observer{
	//需要与目标对象的值保持一致
	private int myState;
	
	public int getMyState() {
		return myState;
	}

	public void setMyState(int myState) {
		this.myState = myState;
	}

	@Override
	public void update(Subject subject) {
		myState = ((ConcreteSubject)subject).getState();
	}
}
