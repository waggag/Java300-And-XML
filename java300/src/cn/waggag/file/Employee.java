package cn.waggag.file;
/**
 * �սӿڣ�ֻ�Ǳ�ʶ
 * @author waggag
 * 2018��4��17������7:04:13
 */
@SuppressWarnings("serial")
public class Employee  implements java.io.Serializable{
	//��ʾname����Ҫ���л�
	private transient  String name;
	private double salary;
	public Employee() {
	}
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
