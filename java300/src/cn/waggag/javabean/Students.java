package cn.waggag.javabean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 学生类,用于存储数据的
 * @author 王港
 * 2018年4月10日 下午2:12:03
 */
public class Students {
	private int sno;
	private String name;
	private int salary;
	private String department;
	private Date time;
	
	public Students() {
		
	}
	
	public Students(int sno, String name, int salary, String department, String time) {
		super();
		this.sno = sno;
		this.name = name;
		this.salary = salary;
		this.department = department;
		DateFormat format = new SimpleDateFormat("yyyy-MM");
		try {
			this.time=format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
