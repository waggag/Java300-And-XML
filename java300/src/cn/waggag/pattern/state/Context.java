package cn.waggag.pattern.state;
/**
 * 根据这个类做不同的状态
 * @author waggag
 * 2018年5月2日 下午8:53:55
 */
public class Context {
	
	private State state;
	
	public void setState(State s) {
		System.out.println("修改状态!");
		state = s;
		state.hander();
	}
}
