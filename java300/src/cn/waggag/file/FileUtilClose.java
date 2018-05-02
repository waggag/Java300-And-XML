package cn.waggag.file;

import java.io.Closeable;
import java.io.IOException;

/**
 * ���߹ر���
 * �ɱ����...ֻ�ܷ������һ��λ��
 * @author waggag
 * 2018��4��17������7:27:56
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
	 * ʹ�÷��ͷ���
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
