package cn.waggag.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
/**
 * �������еĶ��󶼿������л�   java.io.Serializable
 * �������е����Զ���Ҫ���л�   transient
 * @author waggag
 * 2018��4��17������7:19:41
 */
public class SaveObject {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
		seri("E:/1.txt");
		read("E:/1.txt");
	}
	/**
	 * ��ȡ
	 * @param destPath
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void read(String destPath) throws ClassNotFoundException, IOException {
		//����Դ
		File dest = new File(destPath);
		//ѡ����
		ObjectInputStream dos = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(dest)) 
				);
		//����
		Object obj = dos.readObject();
		if(obj instanceof Employee) {
			Employee emp = (Employee)obj;
			System.out.println(emp.getName());
			System.out.println(emp.getSalary());
		}
		int[] arr = (int[]) dos.readObject();
		System.out.println(Arrays.toString(arr));
		dos.close();
	}
	/**
	 * ���л�
	 * @param destPath
	 * @throws IOException
	 */
	public static void seri(String destPath) throws IOException {
		Employee emp = new Employee("����", 1000000);
		int [] arr= {1, 2, 3, 4};
  		//����Դ
		File dest = new File(destPath);
		//ѡ����
		ObjectOutputStream dos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(dest)) 
				);
		//����
		dos.writeObject(emp);
		dos.writeObject(arr);
		dos.flush();
		FileUtilClose.closeAll(dos);	
	}	
}
