package com.kin.test.springboot.global.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	
	/**
	 * 判断当前字符串对象是否为空
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value) {
		if(value==null||"".equals(value)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 将类型为Object的对象转成Integer类型的对象
	 * @param obj
	 * @return
	 */
	public static Integer strToInt(Object obj) {
		String str=null;
		if(obj==null){
			return null;
		}
		if(obj instanceof String) {
			str=(String)obj;
			if("".equals(str)) {
				return null;
			}else {
				return Integer.valueOf(str);
			}
		}else if(obj instanceof Integer) {
			
			return (Integer)obj;
		}else{
			return null;
		}
	}
	
	/**
	 * 将类型为Object的对象转成Double类型的对象
	 * @param obj
	 * @return
	 */
	public static Double strToDouble(Object obj) {
		String str=null;
		if(obj==null){
			return null;
		}
		if(obj instanceof String) {
			str=(String)obj;
		}else {
			return null;
		}
		
		return str==null?null:Double.valueOf(str);
	}
	
	/**
	 * 将类型为Object的对象转成String类型的对象
	 * @param obj
	 * @return
	 */
	public static String objToStr(Object obj){
		if(obj==null){
			return null;
		}
		if(obj instanceof String){
			return (String)obj;
		}
		return null;
	}
	
	/**
	 * 将类型为Object的对象转成Date类型的对象
	 * @param obj
	 * @return
	 */
	public static Date objToDate(Object obj){
		if(obj==null){
			return null;
		}
        try {
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			Date date=format.parse(obj.toString());
			return date;
		} catch (ParseException e) {
			System.err.println("将类型为Object的对象转成Date类型的对象发生异常");
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		Object obj="2019-3-05 11:11:11";
		Date d=objToDate(obj);
		System.out.println(d);
	}
	
}
