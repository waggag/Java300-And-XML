package cn.waggag.file2;
/**
 * ������
 * ������֮��Ĺ�ϵ
 * 1.����:�βλ�ֲ�����
 * 2.����:����
 * 		�ۺ�: ���������벿�ֲ�һ�µ���������
 * 		���	���������벿��һ�µ���������
 * 3.�̳�	:���ӹ�ϵ
 * 4.ʵ��  :�ӿ���ʵ����
 * @author waggag
 * 2018��4��17�� ����7:59:09
 */
public class App {
	public static void main(String[] args) {
		Voice v = new Voice();
		v.say();
		Amplifier am = new Amplifier(v);
		am.say();
	}
}
