package cn.waggag.jdk9;

public interface NewFeature<T> {
	
	//java7����ǰ����  ȫ�ֱ��� �ͳ��󷽷�
	public static final String a = "22";
	boolean process(T t);
	
	//java 8 ���� ��̬������Ĭ�Ϸ���
	default void love() {
		System.out.println("java8 ����Ĭ�Ϸ���");
	}
	static void haha() {
		System.out.println("java8 ���Ծ�̬����");
	}
	
	//java8����֧��˽�з���
	@SuppressWarnings("unused")
	private void java9(){}
	
	
}
