package cn.waggag.chario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * �ַ������� + ��������(���ܷ�����̬)
 * @author waggag
 * 2018��4��15������8:06:53
 */
public class BufferReadAndWrite {
	public static void copyPlainText() {
		//����Դ
		File src = new File("G:/2.txt");
		File dest = new File("G:/1.txt");
		//ѡ����
		BufferedWriter wr = null;
		BufferedReader reader = null;
		
		try {
			//�����ַ�������
			reader = new BufferedReader (new FileReader(src));
			wr = new BufferedWriter(new FileWriter(dest, true));
			//��ȡ����
			/*char[] flush = new char[10];
			int len = 0;
			//ѭ���������е�����
			while((len = reader.read(flush)) != -1)
			{
				wr.write(flush, 0, len);
			}*/
			//��������
			String line = null;
			while((line = reader.readLine()) != null)
			{
				wr.write(line);
				wr.newLine();
			}
			wr.flush(); //ǿ��ˢ��
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("Դ�ļ�������");
		} catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("�ļ���ȡʧ��");
		} finally 
		{
			if(wr != null) {
				try {
					wr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
		
	}
}
