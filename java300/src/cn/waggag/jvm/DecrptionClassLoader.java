package cn.waggag.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ����   ���ܵ����ļ�
 * ���ؽ��ܺ���ļ�
 * @author waggag
 * 2018��4��28�� ����4:40:45
 */
public class DecrptionClassLoader extends ClassLoader{
	
	private String rootDir;
	public DecrptionClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	protected Class<?> findClass(String name) {
		Class<?> c = findLoadedClass(name);
		//��ѯ�Ƿ���ع������
		if(c != null)
		{
			return c;
		}else {
			ClassLoader parent = this.getParent();
			try {
				//ί�ɸ��������
				c = parent.loadClass(name);
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
			}
			if(c != null)
			{
				return c;
			}else {
				byte[] classData = getClassData(name);
				if(classData == null) {
					//throw new ClassNotFoundException();
				}else {
					c = defineClass(name, classData, 0, classData.length);
				}
			}
		}
		return c;
	}
	private byte[] getClassData(String classname)
	{
		String path = rootDir + "/" + classname.replace(".", "/")+".class";		
		//IOUtils,���԰����е�����ת��Ϊ�ֽ�����
		InputStream is = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			is = new FileInputStream(path);
			
			//�����ļ��Ľ��ܴ���(ȡ������)
			int temp = -1;
			while((temp = is.read()) != -1) {
				baos.write(temp^0xff);
			}

			return baos.toByteArray();
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(is != null || baos != null)
			{
				try {
					is.close();
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
	}
}
