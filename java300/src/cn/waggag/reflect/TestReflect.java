package cn.waggag.reflect;
/**
 * ����Reflect��ʹ��
 * 
 * ��ȡ�ṹ��ϢClass����Դͷ��
 * @author wagga
 * 2018��4��22�� ����7:27:22
 */
public class TestReflect {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException {
		String str = "abc";
		//Class����
		Class <?> clz = str.getClass();
		//��.class
		clz = String.class;
		//����·��
		clz = Class.forName("java.lang.String");
	}
}
