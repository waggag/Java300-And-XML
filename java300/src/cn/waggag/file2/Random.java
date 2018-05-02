package cn.waggag.file2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import cn.waggag.file.FileUtil;

/**
 * @author waggag
 * 2018年4月17日 下午8:12:16
 */
public class Random {
	public static void main(String[] args) throws IOException {
		RandomAccessFile rnd = new RandomAccessFile(new File("E:1.txt"),"r");
		rnd.seek(100);
		//定义缓冲大小
		byte[] flush = new byte[1024];
		//定义接受长度
		int len = 0;
		while((len = rnd.read(flush)) != -1)
		{
			if(len>=200)
			{
				System.out.println(new String(flush, 0, 200));
				break;
			}else {
				System.out.println(new String(flush, 0, len));
			}
				
		}
		FileUtil.close(rnd);	
	}
}
