package cn.waggag.jvm;
/**
 * ���Լ򵥵ļ��ܽ��ܣ�ȡ����
 * @author waggag
 * 2018��4��28�� ����4:19:41
 */
public class EncryptionAndDecryption {
	
	public static void main(String[] args) {
		//����ȡ������
//		int a = 3; //00000011
//		System.out.println(Integer.toBinaryString(a^0xff));
		
		//���ܵ�class�ļ�����������������޷�����
//		FileSystemClassLoader loader = new FileSystemClassLoader("E:/myjava/temp");
//		try {
//			Class<?> c = loader.loadClass("Hello");
//			System.out.println(c);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		DecrptionClassLoader loader = new DecrptionClassLoader("e:/myjava/temp");
		try {
			Class<?> c = loader.loadClass("Hello");
			System.out.println(c);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
