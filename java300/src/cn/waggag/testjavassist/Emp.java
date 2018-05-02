package cn.waggag.testjavassist;

public class Emp {
	private int pno;
	private String name;

	public Emp(int pno, String name) {
		super();
		this.pno = pno;
		this.name = name;
	}
	
	public Emp() {
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
