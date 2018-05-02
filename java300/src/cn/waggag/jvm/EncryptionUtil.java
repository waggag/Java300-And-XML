package cn.waggag.jvm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 加密工具类
 * @author waggag
 * 2018年4月28日 下午4:22:59
 */
public class EncryptionUtil {
	
	public static void main(String[] args) {
		encrpt("e:/myjava/Hello.class", "e:/myjava/temp/Hello.class");
	}
	
	public static void encrpt(String src, String dest) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			
			//对于class文件的加密处理，对于文件的取反操作
			int temp = -1;
			while((temp = fis.read()) != -1) {
				fos.write(temp^0xff);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
