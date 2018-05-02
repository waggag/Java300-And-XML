package cn.waggag.pattern.proxy.staticproxy;
/**
 * 代理角色，代理事物
 * @author waggag
 * 2018年4月30日 下午1:11:25
 */
public class ProxyStar implements Star{
	
	private Star star;

	public ProxyStar(Star star) {
		super();
		this.star = star;
	}

	@Override
	public void confer() {
		System.out.println("ProxyStar.confer()");
	}

	@Override
	public void signContract() {
		System.out.println("ProxyStar.signContract");
	}

	@Override
	public void bookTicket() {
		System.out.println("ProxyStar.bookTicket");
	}

	@Override
	public void sing() {
		star.sing();
	}

	@Override
	public void collectMoney() {
		System.out.println("ProxyStar.collectMoney");
	}
}
