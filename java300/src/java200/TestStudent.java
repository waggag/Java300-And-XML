package java200;
/**
 * �Զ��巺������ʹ��ʱ,������������Ͳ���Ϊ������������
 * @author ����
 * 2018��4��10�� ����5:38:21
 */
public class TestStudent {
	public static void main(String[] args) {
		MyStudent<Integer> stu = new MyStudent<Integer>();
		stu.setJavase(80);
		Integer score = stu.getJavase();
		System.out.println(score);
	}
}
