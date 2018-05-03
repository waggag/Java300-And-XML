package cn.waggag.pattern.memento;
/**
 * ��Ա��Ϣ
 * Դ������
 * @author waggag
 * 2018��5��3�� ����7:42:38
 */
public class Emp {
	private String name;
	private int age;
	private double salary;
	
	//���б���¼����,���ر���¼����
	public EmpMemento memento() {
		return new EmpMemento(this);
	}
	
	//�������ݻָ�,�ָ���ָ������¼�����ֵ
	public void recovery(EmpMemento mnt) {
		this.name = mnt.getName();
		this.age = mnt.getAge();
		this.salary = mnt.getSalary();
	}
	
	public Emp(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
