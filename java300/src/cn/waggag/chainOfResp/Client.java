package cn.waggag.chainOfResp;
/**
 * ������,��������������֯
 * @author waggag
 * 2018��4��30�� ����10:44:15
 */
public class Client {
	
	public static void main(String[] args) {
		Leader a = new Director("����");
		Leader b = new Manger("С��");
		Leader c = new GeneralManger("����");
		
		//��֯��������ϵ
		a.setNextLeader(b);;
		b.setNextLeader(c);
		
		//��ʼ����
		LeaveRequest req = new LeaveRequest("Tom", 20, "�ؼ�̸��");
		a.handRequest(req);
	}
}
