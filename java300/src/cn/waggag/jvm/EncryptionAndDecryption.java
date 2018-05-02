package cn.waggag.jvm;
/**
 * 测试简单的加密解密（取反）
 * @author waggag
 * 2018年4月28日 下午4:19:41
 */
public class EncryptionAndDecryption {
	
	public static void main(String[] args) {
		//测试取反操作
//		int a = 3; //00000011
//		System.out.println(Integer.toBinaryString(a^0xff));
		
		//加密的class文件，正常的类加载器无法加载
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
