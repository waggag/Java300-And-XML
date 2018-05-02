package cn.waggag.Thread;
/**
 * 消费者
 * @author waggag
 * 2018年4月19日 下午2:19:43
 */
public class Watcher  implements Runnable{
	private Moive m;
	
	public Watcher(Moive m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++)
		{
			m.watch();
		}
	}
}
