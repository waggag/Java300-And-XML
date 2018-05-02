package cn.waggag.chainOfResp;
/**
 * 总经理
 * @author waggag
 * 2018年4月30日 下午10:42:00
 */
public class GeneralManger extends Leader{

	public GeneralManger(String name) {
		super(name);
	}

	@Override
	public void handRequest(LeaveRequest request) {
		if(request.getLeaveDay() <= 30) {
			System.out.println("员工:"+request.getEmpName()+"请假天数"+request.getLeaveDay());
			System.out.println("总经理："+this.name+"审批通过");
		}else {
			System.out.println("员工："+request.getEmpName()+"想辞职!");
		}
	}
	

}
