package cn.waggag.pattern.memento;
/**
 * ����¼��
 * @author waggag
 * 2018��5��3�� ����7:45:46
 */
public class EmpMemento {
	private String name;
	private int age;
	private double salary;
	
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
	
	public EmpMemento(Emp e) {
		this.name = e.getName();
		this.age = e.getAge();
		this.salary = e.getSalary();
	}
	
	
}
