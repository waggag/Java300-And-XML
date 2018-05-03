package cn.waggag.pattern.Observer;

public class FirstObserver implements Observer{
	//��Ҫ��Ŀ������ֵ����һ��
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
