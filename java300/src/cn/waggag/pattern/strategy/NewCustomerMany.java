package cn.waggag.pattern.strategy;

public class NewCustomerMany implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("��9��!");
		return standardPrice*0.9;
	}

}
