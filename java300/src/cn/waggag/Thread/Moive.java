package cn.waggag.Thread;
/**
 * 一个场景,共同的资源
 * wait() :等待,释放资源
 * @author waggag
 * 2018年4月19日 下午2:16:37
 */
public class Moive {
	private String pic;
	private boolean flag = true;
	/**flag -->T 生产者生成,消费者等待
	 * flag -->F 生产者等待,消费者消费
	 */
	
	public synchronized void play(String pic)
	{
		if(!flag)//等待
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始生成
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("生产了"+pic);
		//生产完毕
		this.pic = pic;
		this.notify();
		//生产者停下
		this.flag = false;
	}
	
	public synchronized void watch() {
		if(flag)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始消费
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//消费完毕
		System.out.println("消费了"+pic);
		//通知生成
		this.notify();
		//消费停止
		this.flag = true;	
	}
	
}
