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
 * 不是所有的对象都可以序列化   java.io.Serializable
 * 不是所有的属性都需要序列化   transient
 * @author waggag
 * 2018年4月17日上午7:19:41
 */
public class SaveObject {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
		seri("E:/1.txt");
		read("E:/1.txt");
	}
	/**
	 * 读取
	 * @param destPath
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void read(String destPath) throws ClassNotFoundException, IOException {
		//创建源
		File dest = new File(destPath);
		//选择流
		ObjectInputStream dos = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(dest)) 
				);
		//操作
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
	 * 序列化
	 * @param destPath
	 * @throws IOException
	 */
	public static void seri(String destPath) throws IOException {
		Employee emp = new Employee("王港", 1000000);
		int [] arr= {1, 2, 3, 4};
  		//创建源
		File dest = new File(destPath);
		//选择流
		ObjectOutputStream dos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(dest)) 
				);
		//操作
		dos.writeObject(emp);
		dos.writeObject(arr);
		dos.flush();
		FileUtilClose.closeAll(dos);	
	}	
}
