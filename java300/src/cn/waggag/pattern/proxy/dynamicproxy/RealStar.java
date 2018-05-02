package cn.waggag.pattern.proxy.dynamicproxy;

public class RealStar implements Star{

	@Override
	public void confer() {
		System.out.println("RealStar.confer()");
	}

	@Override
	public void signContract() {
		System.out.println("RealStar.signContract");
	}

	@Override
	public void bookTicket() {
		System.out.println("RealStar.bookTicket");
	}

	@Override
	public void sing() {
		System.out.println("RealStar(ÖÜ½ÜÂ×).sing");
	}

	@Override
	public void collectMoney() {
		System.out.println("RealStar.collectMoney");
	}
	
}
