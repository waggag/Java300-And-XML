package cn.waggag.nestedclass;

public class Demo1 {
	public static void main(String[] args) {
		//����ֱ��new �ڲ������
		Out out = new Out();
		Out.InnerClass ic = out.new InnerClass();
		ic.test();
	}
	
}

class Out{
	
	private int a = 3;
	int b = 10;
	//��Ա�ڲ���(�����о�̬��Ա������Ϊ����final,��ֵ���ʽ����ҲΪ����)
	//1.����ֱ�Ӹ����ⲿ��ĳ�Ա  
	//2.����ֱ�Ӹ����ⲿ��
	class InnerClass{
		void test() {
			System.out.println(a);
			//���������ⲿ���������ڲ������
			System.out.println("�ڲ������"+this);
			//�������ⲿ��Ķ���
			System.out.println("�ⲿ�����"+Out.this);
		}
	}
}