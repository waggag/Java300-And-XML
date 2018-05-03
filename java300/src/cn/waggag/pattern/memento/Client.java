package cn.waggag.pattern.memento;

public class Client {
	public static void main(String[] args) {
		
		CareTaker taker = new CareTaker();
		
		Emp emp = new Emp("王港", 20, 20000);
		System.out.println("第一次创建对象:"+emp.getName()+"年龄"+emp.getAge()+"薪水"+emp.getSalary());
		
		//备份一次
		taker.setMemento(emp.memento());
		emp.setAge(22);
		System.out.println("第二次创建对象:"+emp.getName()+"年龄"+emp.getAge()+"薪水"+emp.getSalary());
		
		//恢复到原有状态
		emp.recovery(taker.getMemento());
		
		System.out.println("第三次创建对象:"+emp.getName()+"年龄"+emp.getAge()+"薪水"+emp.getSalary());
	
	}
	
}
