package cn.waggag.Thread;
/**
 * ��̬����,���ģʽ
 * 1.��ʵ��ɫ
 * 2.�����ɫ: ������ʵ��ɫ������
 * 3.����ʵ����ͬ�Ľӿ�
 * @author waggag
 * 2018��4��18�� ����8:04:48
 */
public class StaticProxy {
	
	public static void main(String[] args) {
		//������ʵ��ɫ
		Me Me = new Me();
		//���������ɫ
		WeddingCompary company = new WeddingCompary(Me);
		//ִ������
		company.marry();
	}
	
}
interface Marry{
	void marry();
}
//��ʵ��ɫ
class Me implements Marry{

	@Override
	public void marry() {
		System.out.println("�ҽ����!");
	}
}

//�����ɫ  
class WeddingCompary implements Marry{

	private Marry Me;
	
	public WeddingCompary() {
	}

	public WeddingCompary(Marry Me) {
		super();
		this.Me = Me;
	}
	
	private void before() {
		System.out.println("׼���·�!");
	}
	
	private void after() {
		System.out.println("�������!");
	}

	@Override
	public void marry() {
		before();
		Me.marry();
		after();
	}
	
}







