package com.kin.test.springboot.util;

import java.util.UUID;

/**
 * 获取字符串类型的UUID值的工具类
 * @author Administrator
 *
 */
public class UUIDUtil {
	
	/**
	 * 获取字符串类型的原生UUID值的工具方法
	 * @return
	 */
	public static synchronized String getUUIDString(){
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 获取字符串类型的没有"_"的UUID值的工具方法
	 * @return
	 */
	public static synchronized String getUUIDStringNo_(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	
	//测试
	public static void main(String[] args) {
		System.out.println(UUIDUtil.getUUIDString());
		System.out.println(UUIDUtil.getUUIDStringNo_());
	}
	
}
