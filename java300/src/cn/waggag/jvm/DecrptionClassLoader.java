package cn.waggag.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 解密   加密的类文件
 * 加载解密后的文件
 * @author waggag
 * 2018年4月28日 下午4:40:45
 */
public class DecrptionClassLoader extends ClassLoader{
	
	private String rootDir;
	public DecrptionClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
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
			
			//对于文件的解密处理(取反操作)
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
