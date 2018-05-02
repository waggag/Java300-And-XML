package cn.waggag.chainOfResp;
/**
 * 离职请求
 * @author waggag
 * 2018年4月30日 下午10:25:58
 */
public class LeaveRequest {
	
	private String empName;
	private int leaveDay;
	private String reason;
	
	public LeaveRequest() {
	}
	
	public LeaveRequest(String empName, int leaveDay, String reason) {
		super();
		this.empName = empName;
		this.leaveDay = leaveDay;
		this.reason = reason;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getLeaveDay() {
		return leaveDay;
	}
	public void setLeaveDay(int leaveDay) {
		this.leaveDay = leaveDay;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
