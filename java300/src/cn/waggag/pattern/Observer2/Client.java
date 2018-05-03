package cn.waggag.pattern.Observer2;
/**
 * java提供的类的使用
 * @author waggag
 * 2018年5月3日 上午10:36:55
 */
@SuppressWarnings("all")
public class Client {
	public static void main(String[] args) {
		
		//创建目标对象
		ConcreteSubject subject = new ConcreteSubject();
		
		//创建观察者
		ObserverA obs1 = new ObserverA();
		ObserverA obs2 = new ObserverA();
		ObserverA obs3 = new ObserverA();
		
		//添加观察者
		subject.addObserver(obs1);
		subject.addObserver(obs2);
		subject.addObserver(obs3);
		
		//改变subject的值
		subject.set(50);
		
		//查看观察者
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
	}
	
}
