package cn.waggag.pattern.decorator;
/**
 * �������
 * @author waggag
 * 2018��5��2�� ����4:49:00
 */
public interface ICar {
	void move();
}
//��ʵ����
class Car implements ICar{

	@Override
	public void move() {
		System.out.println("½����!");
	}
}
//װ�ν�ɫ
class SuperCar implements ICar{
	protected ICar car;
	
	public SuperCar(ICar car) {
		super();
		this.car = car;
	}

	@Override
	public void move() {
		car.move();
	}
}
//����װ�ζ���
class FlyCar extends SuperCar{

	public FlyCar(ICar car) {
		super(car);
	}
	
	public void fly() {
		System.out.println("���Ϸ�");
	}

	@Override
	public void move() {
		super.move();
		fly();
	}
}

//����װ�ζ���
class WaterCar extends SuperCar{

	public WaterCar(ICar car) {
		super(car);
	}
	
	public void fly() {
		System.out.println("ˮ����!");
	}

	@Override
	public void move() {
		super.move();
		fly();
	}
}