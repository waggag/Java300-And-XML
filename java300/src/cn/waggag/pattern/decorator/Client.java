package cn.waggag.pattern.decorator;
/**
 * ����װ��ģʽ
 * @author waggag
 * 2018��5��2�� ����4:54:43
 */
public class Client {
	public static void main(String[] args) {
		Car car = new Car();
		car.move();
		
		System.out.println("���ӷ��й���:");
		FlyCar flycar = new FlyCar(car);
		flycar.move();
	}
}
