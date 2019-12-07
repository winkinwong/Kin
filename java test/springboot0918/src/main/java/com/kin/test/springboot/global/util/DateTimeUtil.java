package com.kin.test.springboot.global.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 对时间和日期进行各种格式化和转化操作的工具类
 *
 * @author Administrator
 */

public class DateTimeUtil {
	
	/**
	 * 求两个日期时间相差的天数(参数可以是表示日期时间的String类型数据,也可以是Date类型的数据)
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public static int DateMinus(Object date1,Object date2) throws ParseException{
		String date1String="";
		int n1=0;
		String date2String="";
		int n2=0;
		Date d1=new Date();
		int n3=0;
		Date d2=new Date();
		int n4=0;
		if(date1 instanceof String){
			date1String=(String)date1;
			n1=1;
		}else if(date1 instanceof Date){
			d1=(Date)date1;
			n3=1;
		}
		if(date2 instanceof String){
			date2String=(String)date2;
			n2=1;
		}else if(date2 instanceof Date){
			d2=(Date)date2;
			n4=1;
		}
		if(n1==1&&n2==1){//全是字符串类型的数据
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			d1=sdf.parse(date1String);
			d2=sdf.parse(date2String);
		}else if(n3==1&&n2==1){//第一个是日期类型,第二个是字符串类型
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			d2=sdf.parse(date2String);
		}else if(n1==1&&n4==1){//第一个是字符串类型,第二个是日期类型
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			d1=sdf.parse(date1String);
		}else if(n3==1&&n4==1){//全是日期类型
			//无需做处理
		}
		return (int) ((d1.getTime()-d2.getTime())/(60*60*1000*24));
	}
	
	/**
	 * 将指定的日期时间,转化为指定格式的表示日期时间的字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateTimeFormatToString(Date date,String format){
		
		if(format!=null&&!"".equals(format)){//如果给出了指定的日期时间转换格式,则按给出的指定格式进行转换
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			return sdf.format(date);
		}else{//如果没有给出指定的日期时间转换格式,则按本方法的默认格式进行转换
			format="yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			return sdf.format(date);
		}
	}
	
	/**
	 * 将指定的日期时间,转化为指定格式的表示日期的字符串(省略时间)
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateFormatToString(Date date,String format){
		if(date==null){//判空处理
			return null;
		}
		if(format!=null&&!"".equals(format)){
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			return sdf.format(date);
		}else{//如果未给定指定的格式,则按模式格式处理
			format="yyyy-MM-dd";
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			return sdf.format(date);
		}
	}
	
	/**
	 * 给指定的日期增加指定的天数
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date DateAddSomeDays(Date date,Integer days){
		Long ms=new Long(days*24*60*60*1000);
		date.setTime(date.getTime()+ms);
		
		return date;
	}
	
	/**
	 * 将表示[日期]的字符串按指定的格式转成Date对象
	 * @param dateString
	 * @param format
	 * @return
	 * @throws ParseException 
	 */
	public static Date dateStringFormatToDate(String dateString,String format) throws ParseException{
		if(format!=null&&!"".equals(format)){
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			Date date=sdf.parse(dateString);
			return date;
		}else{//若没有指定的格式,则按默认格式处理
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date=sdf.parse(dateString);
			return date;
		}
	}
	
	/**
	 * 将表示一段时间的秒数值转成指定格式的表示一段时间的字符串(00:00:00/00:00)
	 * @param seconds
	 * @return
	 */
	public static String secondsDoubleFormatToTimeString(Double seconds){
		if(seconds>3600){
			Integer hour=(int) Math.floor(seconds/3600);
			Integer minute=(int)Math.floor(seconds%3600/60);
			Integer second=(int)Math.floor(seconds%3600);
			
			String h=hour>=10?hour+"":"0"+hour;
			String m=minute>=10?minute+"":"0"+minute;
			String s=second>=10?second+"":"0"+second;
			return h+":"+m+":"+s;
		}else{
			Integer minute=(int)Math.floor(seconds/60);
			Integer second=(int)Math.floor(seconds%60);
			
			String m=minute>=10?minute+"":"0"+minute;
			String s=second>=10?second+"":"0"+second;
			return m+":"+s;
		}
		
	}
	
	/**
	 * 获取指定月份的天数
	 * @param date
	 * @return
	 */
	public static Integer getDaysOfMonth(Date date){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 获取指定年的天数
	 * @param year
	 * @return
	 */
	public static int getMaxDaysOfYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
	}
	
	
	/**
	 * 获得某个月最大天数
	 *
	 * @param year 年份
	 * @param month 月份 (1-12)
	 * @return 某个月最大天数
	 */
	public static int getMaxDaysOfYearMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		return calendar.getActualMaximum(Calendar.DATE);
	}
	
	/**
	 * 计算两个日期的月份差
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public static int getMonthSpace(String date1, String date2)
            throws ParseException {
        int result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return result == 0 ? 1 : Math.abs(result);
        //return result == 0 ? 0 : Math.abs(result);
    }
	
	/**
	 * 根据给定的前后两个日期,来计算相差的月份数并将每年每月输出来
	 * @return
	 */
	public static List<String> getMonthsOfDifferYear(){
		//待完成..
		return null;
	}
	
	public static void main(String[] args) throws ParseException {
//		String str="2019-08-03 12:05:23";
//		Date d=dateStringFormatToDate(str, "yyyy-MM-dd HH:mm:ss");
//		System.out.println(d);
//		String s=dateTimeFormatToString(d, null);
//		System.out.println(s);
		
		Date d=new Date();
		String str=dateFormatToString(d, "YYYY年MM月dd日");
		System.out.println(str);
	}
	
}
