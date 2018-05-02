package cn.waggag.Thread;
/**
 * 单例设计模式,确保一个类只有一个对象
 * @author waggag
 * 2018年4月19日 下午1:16:12
 */
public class Design {
	
	public static void main(String[] args) {
		JvmThread  jt1 = new JvmThread(100);
		JvmThread  jt2 = new JvmThread(500);
		jt1.start();
		jt2.start();
	}
}
/**
 *  单例设计模式,确保一个类只有一个对象
 * 	确保一个类只有一个对象
 * 	1.构造器私有化
 * 	2.声明一个私有的静态变量
 * 	3.创建一个对外的静态方法访问改变量
 * @author waggag
 * 2018年4月19日 下午1:19:02
 */
class Jvm{
	//构造器私有化,避免外部直接创建对象
	private static Jvm instance = null;
	//构造器私有化,避免外部直接创建对象
	private Jvm() {
	}
	//创建一个对外的公开方法
	//放大发生错误的概率
	public static  Jvm getInstance(long time){
		if(instance == null)
		{
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
	}	
	public static synchronized Jvm getInstance1(long time){
		if(instance == null)
		{
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
	}	
	
	public static  Jvm getInstance2(long time){
		//效率不高,获取Jvm的字节码信息
		synchronized(Jvm.class) {
			if(instance == null)
			{
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance = new Jvm();
			}
			return instance;
		}
	}
	
	public static  Jvm getInstance3(long time){
		//先判断是否存在对象,存在对象需要等待,否则直接返回,提高效率
		if(instance == null) {
			synchronized(Jvm.class) {
				if(instance == null)
				{
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new Jvm();
				}
			}
		}
		return instance;
	}
}

class JvmThread extends Thread{
	
	private long time;
	public JvmThread() {
	}
	public JvmThread(long time) {
		this.time = time;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+
				"--->创建"+Jvm.getInstance1(time));
	}		
}
