package cn.waggag.pattern.strategy;

public class NewCustomerOldMany implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("Дђ85ел!");
		return standardPrice*0.85;
	}

}
