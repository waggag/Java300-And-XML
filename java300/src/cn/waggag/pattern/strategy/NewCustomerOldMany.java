package cn.waggag.pattern.strategy;

public class NewCustomerOldMany implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("��85��!");
		return standardPrice*0.85;
	}

}
