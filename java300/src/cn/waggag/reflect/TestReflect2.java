package cn.waggag.reflect;
/**
 * ���Ը������͵Ķ���Ļ�ȡ��ʽ
 * @author waggag
 * 2018��4��24�� ����1:54:46
 */
@SuppressWarnings("all")
public class TestReflect2 {
	
	public static void main(String[] args) {
		String path = "cn.waggag.reflect.User";
		try {
			
			Class clazz = Class.forName(path);
			Class clazz2 = Class.forName(path);
			//����,��ʾ���װһЩ����,һ���౻���غ�,Jvm�ᴴ��һ����Ӧ�ĸ����Class����
			//��������ṹ��Ϣ����ص���Ӧ��Class������
			System.out.println(clazz.hashCode());//һ����ֻ��Ӧ��һ���������
			System.out.println(clazz2.hashCode());
			
			Class strClazz = String.class;
			Class strClazz2 = path.getClass();
			System.out.println(strClazz==strClazz2);
			
			Class intClazz = int.class;
			
			int[] a = new int[10];
			int[] b = new int[30];
			int[][] c = new int[30][30];
			
			System.out.println(a.getClass().hashCode());
			System.out.println(b.getClass().hashCode());
			System.out.println(c.getClass().hashCode());
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
}
