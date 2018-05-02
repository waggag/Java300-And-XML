package cn.waggag.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author waggag
 * 2018��4��15������3:21:22
 */
public class ReadAndWriteFile {
	
	public static void main(String[] args) {
		readFile();
		writeFile();
	}
	public static void writeFile() {
		//1.������ϵ File���� Ŀ�ĵ�
		File dest = new File("G:/1.txt");
		//2.ѡ���� �ļ�������  OutputStream  FileOutputStream
		OutputStream os = null;
		try {
			//��׷�ӵ���ʽд���ļ�,����Ϊtrue,���򸲸�ԭ���ļ�
			os = new FileOutputStream(dest, true);
			//3.����
			String str = "waggag is very goods!\r\n";
			//�ַ���ת�Լ�����
			byte[] data = str.getBytes();
			os.write(data, 0, data.length);
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}finally{
			//�ͷ���Դ
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
		
	}

	/**
	 * ���ļ��Ĳ���
	 * 	1.������ϵ  File����
	 *	2.ѡ����  �ļ�������  InputStream  FileInputStream
	 * 	3.����	��ȡ�ļ��Ĵ�С
	 *	4.�ͷ���Դ
	 */
	public static void readFile() {
		//1.������ϵ
		File src = new File("G:/1.txt");
		InputStream is = null;
		//2.ѡ����
		try {
			is= new FileInputStream(src);
			//3.�������ϵĶ�ȡ�ļ��е���Ϣ
			byte[] car = new byte[5];
			int len = 0; // ʵ�ʶ�ȡ�Ĵ�С
			//ѭ����ȡ
			while((len = is.read(car)) != -1)
			{
				//����ֽ�����ת�����ַ���
				String info = new String(car, 0, len);
				System.out.println(info);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//�ͷ���Դ
			if(is != null)
			{
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
