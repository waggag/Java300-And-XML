package java100;

import java.io.File;

/**
 * 循环打印目录的树状结构
 * @author 王港
 *
 */
public class ShowDirectory {
	public static void main(String[] args) {
		File file = new File("G:/");
		printFileDirectory(file, 0);
		
	}
	static void printFileDirectory(File file,int level) 
	{
		for(int i = 0;i < level;i++)
		{
			System.out.print("-");
		}
		/**
		 * 打印文件的所有文件和目录
		 */
		System.out.println(file.getName());
		/**
		 * 利用递归,打印目录
		 */
		if(file.isDirectory())
		{
			File[] files = file.listFiles();
			for(File temp : files)
			{
				printFileDirectory(temp, level+1);
			}
		}
	}
	
}
