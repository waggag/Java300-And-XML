package cn.waggag.pattern.brige;
/**
 * ����Ʒ��
 * @author waggag
 * 2018��5��2�� ����9:37:29
 */
public interface Brand {
	void sale();
}

class Leveno implements Brand{

	@Override
	public void sale() {
		System.out.println("��������Ʒ��");
	}
	
}

class Dell implements Brand{

	@Override
	public void sale() {
		System.out.println("����DellƷ��");
	}
	
}
