package cn.waggag.nestedclass;
/**
 * �����ڲ���
 * @author waggag
 * 2018��4��28�� ����9:52:07
 */
@SuppressWarnings("all")
public class TestNestedClass {
	
	public static void main(String[] args) {
		TestNestedClass c = new TestNestedClass();
	}
	
	//��̬�ڲ��࣬���ⲿ��ʹ��
	@SuppressWarnings("all")
	private static class StaticNestedClass{
		
	}
	
	//��Ա�ڲ���
	@SuppressWarnings("all")
	private class FiledInnerClass{
		
	}
	
	void sayHello() {
		
		//�ֲ��ڲ���
		@SuppressWarnings("all")
		class LocalClass{
			
		}
		
		//�����ڲ���  �������ڲ��࣬�������ڲ���Ķ���
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
			}
		};
		
		
	}
	
	
	
}
