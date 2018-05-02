package cn.waggag.chario;

import java.io.UnsupportedEncodingException;

/**
 * 编码与解码
 * @author waggag
 * 2018年4月15日下午8:19:03
 */
public class Conver {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String str = "中国";
		byte[] data = str.getBytes();
		//字节数不完整造成乱码
		System.out.println(new String(data, 0, 3));
	}
	/**
	 * 解码与编码字符集必须相同，否则乱码
	 * @throws UnsupportedEncodingException 
	 */
	public static void test() throws UnsupportedEncodingException {
		
		//解码 byte --> char
		String str = "王港";  //gbk
		//编码 char --> byte
		byte[] data = str.getBytes();	
		//编码与解码的字符同意
		System.out.println(str);
		try {
			data = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} //设定编码字符集
		//不统一出线乱码
		System.out.println(data);
		System.out.println("==============");
		
		//解码 byte --> char
		byte[] data2 = "王港".getBytes("utf-8");  //gbk
		//编码 char --> byte
		str = new String(data2, "utf-8");
		System.out.println(str);
		
		
	}
	
	
}
