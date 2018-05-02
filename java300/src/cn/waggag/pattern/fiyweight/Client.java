package cn.waggag.pattern.fiyweight;
/**
 * ������Ԫģʽ,ʵ���ڲ�״̬�Ĺ���,�ⲿ״̬�Ĺ���
 * @author waggag
 * 2018��5��2�� ����5:23:24
 */
public class Client {
	public static void main(String[] args) {
		//һ������
		ChessFiyWeight chess1 = ChessFiyWeightFactory.getChess("��ɫ");
		ChessFiyWeight chess2 = ChessFiyWeightFactory.getChess("��ɫ");
		System.out.println(chess1);
		System.out.println(chess2);
		System.out.println("�ⲿ״̬�Ĵ���!");
		chess1.display(new Coordinate(10, 10));
		chess2.display(new Coordinate(20, 20));
	}
}
