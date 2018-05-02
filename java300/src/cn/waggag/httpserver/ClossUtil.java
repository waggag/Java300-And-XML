package cn.waggag.httpserver;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClossUtil {
	
	public static void closeSocketAll(Closeable... io) {
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
	/**
	 * 使用泛型方法
	 */
	public static void closeSocket(Socket io) {
		
			if(io != null)
			{
				try {
					((Closeable) io).close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
	public static void closeSocket(ServerSocket server) {
		
		if(server != null)
		{
			try {
				((Closeable) server).close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
