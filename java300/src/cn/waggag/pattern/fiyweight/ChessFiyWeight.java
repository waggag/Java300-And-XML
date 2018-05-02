package cn.waggag.pattern.fiyweight;
/**
 * ��Ԫ��
 * @author waggag
 * 2018��5��2�� ����5:14:29
 */
public interface ChessFiyWeight {
	void setColor(String color);
	String getColor();
	void display(Coordinate c);
}

class ConcreteChess implements ChessFiyWeight{
	
	private String color;
	
	public ConcreteChess(String color) {
		super();
		this.color = color;
	}

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void display(Coordinate c) {
		System.out.println("������ɫ"+color+"����λ��"+c.getX()+"------>"+c.getY());
	}
	
	
}
