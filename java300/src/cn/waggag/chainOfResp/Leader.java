package cn.waggag.chainOfResp;
/**
 * 抽象类
 * @author waggag
 * 2018年4月30日 下午10:27:57
 */
public abstract class Leader {
	protected String name;
	protected Leader nextLeader;  //责任链上的后继对象
	
	public Leader(String name) {
		super();
		this.name = name;
	}
	//设置责任链上的后继对象

	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}
	/**
	 * 处理请求的核心业务方法
	 */
	public abstract void handRequest(LeaveRequest request);
	
}
