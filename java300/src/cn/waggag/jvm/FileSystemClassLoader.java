package cn.waggag.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义文件系统类加载器
 * @author waggag
 * 2018年4月27日 上午11:04:23
 */
public class FileSystemClassLoader extends ClassLoader{
	
	private String rootDir;
	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	@Override
	protected Class<?> findClass(String name) {
		Class<?> c = findLoadedClass(name);
		//查询是否加载过这个类
		if(c != null)
		{
			return c;
		}else {
			ClassLoader parent = this.getParent();
			try {
				//委派给父类加载
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
		//IOUtils,可以把流中的数据转化为字节数组
		InputStream is = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			is = new FileInputStream(path);
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
