package cn.waggag.pattern.Observer;
/**
 * 测试观察者模式
 * @author waggag
 * 2018年5月3日 上午10:17:28
 */
public class Client {
	
	public static void main(String[] args) {
		//目标对象
		ConcreteSubject subject = new ConcreteSubject();
		//创建多个观察者 
		FirstObserver obs1 = new FirstObserver();
		FirstObserver obs2 = new FirstObserver();
		FirstObserver obs3 = new FirstObserver();
		
		//将三个观察者添加到观察者队伍中
		subject.register(obs1);
		subject.register(obs2);
		subject.register(obs3);
		//改变subject的状态
		subject.setState(1000);
		//查看观察者的状态
		System.out.println("===========");
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
		
		subject.setState(100);
		//查看观察者的状态
		System.out.println("===========");
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
				
	}
	
}
