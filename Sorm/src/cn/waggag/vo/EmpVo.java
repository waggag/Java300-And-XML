package cn.waggag.vo;
/**
 * ͨ��VO��Ѹ��ӵ�����һһ��Ӧ,�����븴�ӵĲ�ѯ
 * @author waggag
 * 2018��5��6�� ����8:15:06
 */
public class EmpVo {
	
	private Integer id;
	private String empname;
	private Double xinshui; 
	private Integer age;
	private String deptName;
	private String deptAddr;
	
	public EmpVo() {
		
	}
	
	public EmpVo(Integer id, String empname, Double xinshui, Integer age, String deptName, String deptAddr) {
		super();
		this.id = id;
		this.empname = empname;
		this.xinshui = xinshui;
		this.age = age;
		this.deptName = deptName;
		this.deptAddr = deptAddr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Double getXinshui() {
		return xinshui;
	}

	public void setXinshui(Double xinshui) {
		this.xinshui = xinshui;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptAddr() {
		return deptAddr;
	}

	public void setDeptAddr(String deptAddr) {
		this.deptAddr = deptAddr;
	}
	
	
}
