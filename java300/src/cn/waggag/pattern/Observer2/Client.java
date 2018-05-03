package cn.waggag.pattern.Observer2;
/**
 * java�ṩ�����ʹ��
 * @author waggag
 * 2018��5��3�� ����10:36:55
 */
@SuppressWarnings("all")
public class Client {
	public static void main(String[] args) {
		
		//����Ŀ�����
		ConcreteSubject subject = new ConcreteSubject();
		
		//�����۲���
		ObserverA obs1 = new ObserverA();
		ObserverA obs2 = new ObserverA();
		ObserverA obs3 = new ObserverA();
		
		//��ӹ۲���
		subject.addObserver(obs1);
		subject.addObserver(obs2);
		subject.addObserver(obs3);
		
		//�ı�subject��ֵ
		subject.set(50);
		
		//�鿴�۲���
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
	}
	
}
