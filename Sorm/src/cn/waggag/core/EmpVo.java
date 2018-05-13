package cn.waggag.core;

public class EmpVo {
	
	private int Id;
	private String Empname;
	private String DeptAddr;
	
	public String getDeptAddr() {
		return DeptAddr;
	}
	public void setDeptAddr(String deptAddr) {
		DeptAddr = deptAddr;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEmpname() {
		return Empname;
	}
	public void setEmpname(String empname) {
		Empname = empname;
	}
	
}
