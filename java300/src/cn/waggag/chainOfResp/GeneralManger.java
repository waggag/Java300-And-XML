package cn.waggag.chainOfResp;
/**
 * �ܾ���
 * @author waggag
 * 2018��4��30�� ����10:42:00
 */
public class GeneralManger extends Leader{

	public GeneralManger(String name) {
		super(name);
	}

	@Override
	public void handRequest(LeaveRequest request) {
		if(request.getLeaveDay() <= 30) {
			System.out.println("Ա��:"+request.getEmpName()+"�������"+request.getLeaveDay());
			System.out.println("�ܾ���"+this.name+"����ͨ��");
		}else {
			System.out.println("Ա����"+request.getEmpName()+"���ְ!");
		}
	}
	

}
