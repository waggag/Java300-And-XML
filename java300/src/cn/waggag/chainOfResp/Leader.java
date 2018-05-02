package cn.waggag.chainOfResp;
/**
 * ������
 * @author waggag
 * 2018��4��30�� ����10:27:57
 */
public abstract class Leader {
	protected String name;
	protected Leader nextLeader;  //�������ϵĺ�̶���
	
	public Leader(String name) {
		super();
		this.name = name;
	}
	//�����������ϵĺ�̶���

	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}
	/**
	 * ��������ĺ���ҵ�񷽷�
	 */
	public abstract void handRequest(LeaveRequest request);
	
}
