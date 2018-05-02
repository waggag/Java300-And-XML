package cn.waggag.Thread;
/**
 * 生产者
 * @author waggag
 * 2018年4月19日 下午2:19:05
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
				m.play("左青龙");
			else
				m.play("右白虎");
		}
	}
	
}
