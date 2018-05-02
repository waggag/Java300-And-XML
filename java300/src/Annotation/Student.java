package Annotation;

@StudentTable("ta_student")
public class Student {
	@StudentFiled(columName = "id", length = 10, type = "int")
	private int id;
	@StudentFiled(columName = "sname", length = 10, type = "varchar")
	private String studentName;
	@StudentFiled(columName = "age", length = 3, type = "int")
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
