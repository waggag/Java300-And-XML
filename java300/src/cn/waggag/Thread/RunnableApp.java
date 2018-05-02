package cn.waggag.Thread;
/**
 * 推荐使用实现Runnable
 * 1.避免单继承的局限性
 * 2.容易共享资源
 * @author waggag
 * 2018年4月18日 下午8:38:17
 */
public class RunnableApp {
	
	public static void main(String[] args) {
		//创建真实角色
		TestRunnable ra = new TestRunnable();
		//创建代理角色,真实角色引用
		Thread proxy = new Thread(ra);
		//调用start(),启动线程
		proxy.start();
		for(int i=0; i<100; i++)
		{
			System.out.println("一起聊QQ !");
		}

	}
}
