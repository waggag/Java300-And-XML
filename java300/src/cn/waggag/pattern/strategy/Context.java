package cn.waggag.pattern.strategy;
/**
 * 负责和具体的类交互
 * @author waggag
 * 2018年5月2日 下午8:36:15
 */
public class Context {
	
	private Strategy strategy;

	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void printPrice(double s) {
		System.out.println(strategy.getPrice(s));
	}
}
