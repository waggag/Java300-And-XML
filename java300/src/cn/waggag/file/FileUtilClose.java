package cn.waggag.file;

import java.io.Closeable;
import java.io.IOException;

/**
 * 工具关闭流
 * 可变参数...只能放在最后一个位置
 * @author waggag
 * 2018年4月17日上午7:27:56
 */
public class FileUtilClose {
	
	public static void close(Closeable ... io) {
		for(Closeable temp: io)
		{
			if(temp != null) {
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 使用泛型方法
	 * @param io
	 */
	@SafeVarargs
	public static <T extends Closeable> void closeAll(T ... io) {
		for(Closeable temp: io)
		{
			if(temp != null) {
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
