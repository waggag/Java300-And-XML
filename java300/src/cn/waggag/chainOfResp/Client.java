package cn.waggag.chainOfResp;
/**
 * 测试类,测试责任链的组织
 * @author waggag
 * 2018年4月30日 下午10:44:15
 */
public class Client {
	
	public static void main(String[] args) {
		Leader a = new Director("张三");
		Leader b = new Manger("小杨");
		Leader c = new GeneralManger("王港");
		
		//组织责任链关系
		a.setNextLeader(b);;
		b.setNextLeader(c);
		
		//开始操作
		LeaveRequest req = new LeaveRequest("Tom", 20, "回家谈情");
		a.handRequest(req);
	}
}
