package cn.waggag.Thread;
/**
 * ������
 * @author waggag
 * 2018��4��19�� ����2:19:05
 */
public class Player implements Runnable{
	private Moive m;
	public Player() {
	}

	public Player(Moive m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		for(int i=0; i<20 ;i++)
		{
			if(i%2 == 0)
				m.play("������");
			else
				m.play("�Ұ׻�");
		}
	}
	
}
