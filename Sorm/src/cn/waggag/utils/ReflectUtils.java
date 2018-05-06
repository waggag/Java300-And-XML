package cn.waggag.utils;

import java.lang.reflect.Method;

/**
 * ��װ�˷��䳣�õĲ���
 * @author waggag
 * 2018��5��5�� ����12:17:16
 */
@SuppressWarnings("all")
public class ReflectUtils {
	
	/**
	 * ����obj�����Ӧ����fieldName��get����
	 */
	public static Object invokeGet(String fieldName,Object obj){
		try {
			Class c = obj.getClass();
			Method m = c.getDeclaredMethod("get"+StringUtils.firstChar2UpperCase(fieldName), null);
			return m.invoke(obj, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public static void invokeSet(Object obj,String columnName,Object columnValue){
		try {
			if(columnValue != null)
			{
				Method m = obj.getClass().getDeclaredMethod("set"+StringUtils.firstChar2UpperCase(columnName), 
						columnValue.getClass());
				m.invoke(obj, columnValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
}
