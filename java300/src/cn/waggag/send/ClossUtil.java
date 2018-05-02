package cn.waggag.send;

import java.io.Closeable;
import java.io.IOException;

public class ClossUtil {
	
	public static void closeAll(Closeable... io) {
		for(Closeable temp : io) {
			if(temp != null)
			{
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
