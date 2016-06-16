package org.zjz.util;
/**
 * 字符判断工具类
 * @author liyan
 *
 */
public class StringUtil {
	public static boolean isEmpty(String s)
	{
		if("".equals(s) || s == null) return true;
		else return false;
	}

	public static boolean isNotEmpty(String s) {
		// TODO Auto-generated method stub
		if(!"".equals(s) && s != null) return true;
		else return false;
	}
}
