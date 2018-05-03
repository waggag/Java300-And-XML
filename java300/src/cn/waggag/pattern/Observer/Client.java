package cn.waggag.pattern.Observer;
/**
 * ���Թ۲���ģʽ
 * @author waggag
 * 2018��5��3�� ����10:17:28
 */
public class Client {
	
	public static void main(String[] args) {
		//Ŀ�����
		ConcreteSubject subject = new ConcreteSubject();
		//��������۲��� 
		FirstObserver obs1 = new FirstObserver();
		FirstObserver obs2 = new FirstObserver();
		FirstObserver obs3 = new FirstObserver();
		
		//�������۲�����ӵ��۲��߶�����
		subject.register(obs1);
		subject.register(obs2);
		subject.register(obs3);
		//�ı�subject��״̬
		subject.setState(1000);
		//�鿴�۲��ߵ�״̬
		System.out.println("===========");
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
		
		subject.setState(100);
		//�鿴�۲��ߵ�״̬
		System.out.println("===========");
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
				
	}
	
}
