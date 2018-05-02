package cn.waggag.pattern.fiyweight;
/**
 * 享元类
 * @author waggag
 * 2018年5月2日 下午5:14:29
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
		System.out.println("棋子颜色"+color+"棋子位置"+c.getX()+"------>"+c.getY());
	}
	
	
}
