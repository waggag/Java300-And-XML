package cn.waggag.pattern.brige;
/**
 * ��������
 * @author waggag
 * 2018��5��2�� ����9:43:59
 */
public class Computer {
	protected Brand brand;
	
	public Computer() {
	}
	
	public Computer(Brand brand) {
		super();
		this.brand = brand;
	}
	
	void sale() {
		brand.sale();
	}
}

class DeskTop extends Computer{

	public DeskTop(Brand brand) {
		super(brand);
	}

	@Override
	void sale() {
		super.sale();
		System.out.println("����̨ʽ��");
	}

}

class LapTop extends Computer{

	public LapTop(Brand brand) {
		super(brand);
	}

	@Override
	void sale() {
		super.sale();
		System.out.println("���۱ʼǱ�");
	}

}