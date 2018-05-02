package cn.waggag.pattern.brige;
/**
 * 电脑品牌
 * @author waggag
 * 2018年5月2日 上午9:37:29
 */
public interface Brand {
	void sale();
}

class Leveno implements Brand{

	@Override
	public void sale() {
		System.out.println("销售联想品牌");
	}
	
}

class Dell implements Brand{

	@Override
	public void sale() {
		System.out.println("销售Dell品牌");
	}
	
}
