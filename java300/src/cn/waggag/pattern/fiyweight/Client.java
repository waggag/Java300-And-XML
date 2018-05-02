package cn.waggag.pattern.fiyweight;
/**
 * 测试享元模式,实现内部状态的共用,外部状态的共享
 * @author waggag
 * 2018年5月2日 下午5:23:24
 */
public class Client {
	public static void main(String[] args) {
		//一个对象
		ChessFiyWeight chess1 = ChessFiyWeightFactory.getChess("黑色");
		ChessFiyWeight chess2 = ChessFiyWeightFactory.getChess("黑色");
		System.out.println(chess1);
		System.out.println(chess2);
		System.out.println("外部状态的处理!");
		chess1.display(new Coordinate(10, 10));
		chess2.display(new Coordinate(20, 20));
	}
}
