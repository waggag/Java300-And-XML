package cn.waggag.pattern.strategy;

public class NewCustomer implements Strategy{

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("������,ԭ��!");
		return standardPrice;
	}

}
