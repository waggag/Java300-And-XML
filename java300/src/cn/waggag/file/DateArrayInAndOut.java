package cn.waggag.file;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件内容不用太大
 * 1.文件 --> 程序 --> 字节数组
 * 2.字节数组 --> 程序 -->文件
 * 字节数组的节点流
 * @author waggag
 * 2018年4月16日 下午7:25:09
 */
public class DateArrayInAndOut {
	
	public static void main(String[] args) {
		try {
			read(write());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 输出流,操作与文件输出流有些不同,有新增方法,不能使用多态
	 * 向字节数组写入字符串转换的内容
	 * @return 
	 */
	public static byte[] write() {
		//目的地
		byte[] dest;
		//选择流   不同点
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//写出
		String meg = "王港   is very good!";
		byte[] info = meg.getBytes();
		bos.write(info, 0, info.length);
		//获取数据
		dest = bos.toByteArray();
		try {
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest;
	}
	
	/**
	 * 输入流,操作与文件输入流一致
	 * 读取字节数组
	 * @throws IOException 
	 */
	 public static void read(byte[] src) throws IOException {
		 //数据源传入
		 //选择流
		 InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		 //操作
		 byte[] flush = new byte[1024];
		 int len = 0;
		 while((len = is.read(flush)) != -1)
		 {
			 System.out.println(new String(flush, 0, len));
		 }
		 //释放资源
		 is.close(); 
	 }
}
