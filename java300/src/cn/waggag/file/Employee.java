package cn.waggag.file;
/**
 * 空接口，只是标识
 * @author waggag
 * 2018年4月17日上午7:04:13
 */
@SuppressWarnings("serial")
public class Employee  implements java.io.Serializable{
	//表示name不需要序列化
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
