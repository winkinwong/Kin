package com.kin.test.springboot.global.basic;

/**
 * 常量配置类
 * @author father
 *
 */
public class ConstantConfiguration {
	/** 当前页默认值 */
	public static final String PAGE_NO="1";
	/** 分页默认值 */
	public static final String PAGE_SIZE="10";
	/** 文件的统一存放地址 */
	public static final String FILE_PATH="/Users/bd_mac/Desktop/patrolInspectSystemFiles/";
	/** 巡检类型的默认值:[日常巡检] */
	public static final Integer INSPECT_TYPE=1;
	/** 巡检任务的巡检状态选择值[待巡检] */
	public static final Integer INSPECT_STATUS_INT=1;
	/** 审核任务的审核状态选择值:[待审核] */
	public static final Integer REVIEW_STATUS_INT=1;
	/** 文件的统一访问路径的固定部分 */
	public static final String FILE_URL="file/";
	
}
