package cn.waggag.chainOfResp;
/**
 * 主任
 * @author waggag
 * 2018年4月30日 下午10:42:05
 */
public class Director extends Leader{

	public Director(String name) {
		super(name);
	}

	@Override
	public void handRequest(LeaveRequest request) {
		if(request.getLeaveDay() <= 3) {
			System.out.println("员工:"+request.getEmpName()+"请假天数"+request.getLeaveDay());
			System.out.println("主任："+this.name+"审批通过");
		}else {
			if(this.nextLeader != null) {
				this.nextLeader.handRequest(request);
			}
		}
	}
	

}
