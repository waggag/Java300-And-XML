package cn.waggag.chainOfResp;
/**
 * ����
 * @author waggag
 * 2018��4��30�� ����10:42:00
 */
public class Manger extends Leader{

	public Manger(String name) {
		super(name);
	}

	@Override
	public void handRequest(LeaveRequest request) {
		if(request.getLeaveDay() <= 10) {
			System.out.println("Ա��:"+request.getEmpName()+"�������"+request.getLeaveDay());
			System.out.println("����"+this.name+"����ͨ��");
		}else {
			if(this.nextLeader != null) {
				this.nextLeader.handRequest(request);
			}
		}
	}
	

}
