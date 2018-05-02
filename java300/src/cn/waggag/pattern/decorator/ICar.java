package cn.waggag.pattern.decorator;
/**
 * 抽象组件
 * @author waggag
 * 2018年5月2日 下午4:49:00
 */
public interface ICar {
	void move();
}
//真实构建
class Car implements ICar{

	@Override
	public void move() {
		System.out.println("陆上跑!");
	}
}
//装饰角色
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
//具体装饰对象
class FlyCar extends SuperCar{

	public FlyCar(ICar car) {
		super(car);
	}
	
	public void fly() {
		System.out.println("天上飞");
	}

	@Override
	public void move() {
		super.move();
		fly();
	}
}

//具体装饰对象
class WaterCar extends SuperCar{

	public WaterCar(ICar car) {
		super(car);
	}
	
	public void fly() {
		System.out.println("水里游!");
	}

	@Override
	public void move() {
		super.move();
		fly();
	}
}