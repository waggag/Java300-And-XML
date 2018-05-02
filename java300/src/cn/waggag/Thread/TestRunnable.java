package cn.waggag.Thread;
/**
 * 使用Runnable创建线程
 * 1.类实现Runable接口 + 重写run() --->真实角色类
 * 2.启动多线程,使用代理角色
 * 		创建真实角色
 * 		创建代理角色,真实角色引用
 * 		调用start(),启动线程
 * @author waggag
 * 2018年4月18日 下午8:23:02
 */
public class TestRunnable implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<100; i++)
		{
			System.out.println("一起打代码!");
		}
	}
}
