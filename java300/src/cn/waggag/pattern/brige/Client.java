package cn.waggag.pattern.brige;
/**
 * ���Զ�̳�ģʽ
 * @author waggag
 * 2018��5��2�� ����9:48:16
 */
public class Client {
	
	public static void main(String[] args) {
		//��������ıʼǱ�
		Computer c = new DeskTop(new Leveno());
		c.sale();
		
		//����Dell�ıʼǱ�
		Computer c2 = new LapTop(new Dell());
		c2.sale();
	}
}
