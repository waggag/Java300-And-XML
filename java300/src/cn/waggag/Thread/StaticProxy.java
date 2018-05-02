package cn.waggag.Thread;
/**
 * 静态代理,设计模式
 * 1.真实角色
 * 2.代理角色: 持有真实角色的引用
 * 3.二者实现相同的接口
 * @author waggag
 * 2018年4月18日 下午8:04:48
 */
public class StaticProxy {
	
	public static void main(String[] args) {
		//创建真实角色
		Me Me = new Me();
		//创建代理角色
		WeddingCompary company = new WeddingCompary(Me);
		//执行任务
		company.marry();
	}
	
}
interface Marry{
	void marry();
}
//真实角色
class Me implements Marry{

	@Override
	public void marry() {
		System.out.println("我结婚了!");
	}
}

//代理角色  
class WeddingCompary implements Marry{

	private Marry Me;
	
	public WeddingCompary() {
	}

	public WeddingCompary(Marry Me) {
		super();
		this.Me = Me;
	}
	
	private void before() {
		System.out.println("准备新房!");
	}
	
	private void after() {
		System.out.println("婚后整理!");
	}

	@Override
	public void marry() {
		before();
		Me.marry();
		after();
	}
	
}







