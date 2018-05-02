package cn.waggag.pattern.fiyweight;
/**
 * 外部状态,非共享的享元类
 * @author waggag
 * 2018年5月2日 下午5:12:05
 */
public class Coordinate {
	private int x, y;

	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
