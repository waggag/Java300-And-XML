package cn.waggag.pattern.proxy.staticproxy;

public class Client {
	
	public static void main(String[] args) {
		RealStar realstar = new RealStar();
		
		ProxyStar proxy = new ProxyStar(realstar);
		
		proxy.confer();
		proxy.signContract();
		proxy.bookTicket();
		proxy.sing();
		proxy.collectMoney();
	}
}
