package cn.waggag.reflect;
/**
 * ����ʵ�������ÿչ���
 * @author wagga
 * 2018��4��22�� ����7:32:34
 */
public class Test {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz = Class.forName("java.lang.String");
		//���ÿչ���
		String str = (String) clz.newInstance();
		System.out.println(str);
	}
}
