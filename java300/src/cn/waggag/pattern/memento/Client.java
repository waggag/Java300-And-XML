package cn.waggag.pattern.memento;

public class Client {
	public static void main(String[] args) {
		
		CareTaker taker = new CareTaker();
		
		Emp emp = new Emp("����", 20, 20000);
		System.out.println("��һ�δ�������:"+emp.getName()+"����"+emp.getAge()+"нˮ"+emp.getSalary());
		
		//����һ��
		taker.setMemento(emp.memento());
		emp.setAge(22);
		System.out.println("�ڶ��δ�������:"+emp.getName()+"����"+emp.getAge()+"нˮ"+emp.getSalary());
		
		//�ָ���ԭ��״̬
		emp.recovery(taker.getMemento());
		
		System.out.println("�����δ�������:"+emp.getName()+"����"+emp.getAge()+"нˮ"+emp.getSalary());
	
	}
	
}
