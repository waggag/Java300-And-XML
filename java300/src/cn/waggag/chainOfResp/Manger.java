package cn.waggag.chainOfResp;
/**
 * 经理
 * @author waggag
 * 2018年4月30日 下午10:42:00
 */
public class Manger extends Leader{

	public Manger(String name) {
		super(name);
	}

	@Override
	public void handRequest(LeaveRequest request) {
		if(request.getLeaveDay() <= 10) {
			System.out.println("员工:"+request.getEmpName()+"请假天数"+request.getLeaveDay());
			System.out.println("经理："+this.name+"审批通过");
		}else {
			if(this.nextLeader != null) {
				this.nextLeader.handRequest(request);
			}
		}
	}
	

}
