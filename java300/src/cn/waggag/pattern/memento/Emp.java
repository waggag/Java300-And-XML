package cn.waggag.pattern.memento;
/**
 * 雇员信息
 * 源发器类
 * @author waggag
 * 2018年5月3日 上午7:42:38
 */
public class Emp {
	private String name;
	private int age;
	private double salary;
	
	//进行备忘录操作,返回备忘录对象
	public EmpMemento memento() {
		return new EmpMemento(this);
	}
	
	//进行数据恢复,恢复到指定备忘录对象的值
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
