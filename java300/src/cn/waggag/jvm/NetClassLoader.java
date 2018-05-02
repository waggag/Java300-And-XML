package cn.waggag.jvm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * �����������    ���ݵ���Url
 * @author waggag
 * 2018��4��27�� ����11:04:23
 */
public class NetClassLoader  extends ClassLoader{
	
	private String rootUrl;
	public NetClassLoader(String rootUrl) {
		this.rootUrl = rootUrl;
	}
	@Override
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
		String path = rootUrl + "/" + classname.replace(".", "/")+".class";		
		//IOUtils,���԰����е�����ת��Ϊ�ֽ�����
		InputStream is = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			URL url = new URL(path);
			is = url.openStream();
			byte[] buffer = new byte[1024];
			int temp = 0;
			while((temp = is.read(buffer)) != -1)
			{
				baos.write(buffer, 0, temp);
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
