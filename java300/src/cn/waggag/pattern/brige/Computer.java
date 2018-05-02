package cn.waggag.pattern.brige;
/**
 * 电脑类型
 * @author waggag
 * 2018年5月2日 上午9:43:59
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
		System.out.println("销售台式机");
	}

}

class LapTop extends Computer{

	public LapTop(Brand brand) {
		super(brand);
	}

	@Override
	void sale() {
		super.sale();
		System.out.println("销售笔记本");
	}

}