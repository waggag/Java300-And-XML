package cn.waggag.utils;
/**
 * 封装了字符串查询常用的操作
 * @author waggag
 * 2018年5月5日 下午12:17:16
 */

public class StringUtils {
	
	/**
	 * 将目标字符串首字母变为大写
	 * @param str 目标字符串
	 * @return 首字母变为大写的字符串
	 */
	public static String firstChar2UpperCase(String str){
		//abcd-->Abcd
		//abcd-->ABCD-->Abcd
		return str.toUpperCase().substring(0, 1)+str.substring(1);
	}
}
