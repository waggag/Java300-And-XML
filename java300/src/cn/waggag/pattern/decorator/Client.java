package cn.waggag.pattern.decorator;
/**
 * 测试装饰模式
 * @author waggag
 * 2018年5月2日 下午4:54:43
 */
public class Client {
	public static void main(String[] args) {
		Car car = new Car();
		car.move();
		
		System.out.println("增加飞行功能:");
		FlyCar flycar = new FlyCar(car);
		flycar.move();
	}
}
