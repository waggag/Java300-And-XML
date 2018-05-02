package cn.waggag.pattern.strategy;

public class Client {
	
	public static void main(String[] args) {
		Strategy s1 = new NewCustomerOldMany();
		Context ctx = new Context(s1);
		
		ctx.printPrice(500);
	}
}
