package cn.waggag.pattern.strategy;
/**
 * ����;�����ཻ��
 * @author waggag
 * 2018��5��2�� ����8:36:15
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
