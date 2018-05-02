package cn.waggag.chainOfResp;
/**
 * ����
 * @author waggag
 * 2018��4��30�� ����10:42:05
 */
public class Director extends Leader{

	public Director(String name) {
		super(name);
	}

	@Override
	public void handRequest(LeaveRequest request) {
		if(request.getLeaveDay() <= 3) {
			System.out.println("Ա��:"+request.getEmpName()+"�������"+request.getLeaveDay());
			System.out.println("���Σ�"+this.name+"����ͨ��");
		}else {
			if(this.nextLeader != null) {
				this.nextLeader.handRequest(request);
			}
		}
	}
	

}
