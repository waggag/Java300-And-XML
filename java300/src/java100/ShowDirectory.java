package java100;

import java.io.File;

/**
 * ѭ����ӡĿ¼����״�ṹ
 * @author ����
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
		 * ��ӡ�ļ��������ļ���Ŀ¼
		 */
		System.out.println(file.getName());
		/**
		 * ���õݹ�,��ӡĿ¼
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
