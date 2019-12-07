package com.kin.test.springboot.dao;

import com.kin.test.springboot.model.Inspect;
import com.kin.test.springboot.model.User2;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 巡检(任务)表 DAO层
 * 
 * @author  fangcheng and ja
 * 2019-06-06 16:06
 */
@Repository("inspectDao")
public interface InspectDao
{
	/**
	 * 根据指定的条件分页查询全部的巡检任务及其关联的字段
	 * @param inspect
	 * @return
	 */
	List<Inspect> selectByPageByConditions(Inspect inspect);
	
	/**
	 * 根据指定的条件查询全部的巡检任务的个数
	 * @param inspect
	 * @return
	 */
	Integer countByExampleByConditions(Inspect inspect);
	
	/**
	 * 根据指定的条件查询全部的巡检任务
	 * @param inspect
	 * @return
	 */
	List<Inspect> selectByExampleByConditions(Inspect inspect);
	
	/**
	 * 根据主键值查询一条巡检任务记录以及关联的字段值
	 * @param value
	 * @return
	 */
	Inspect selectOneByPrimaryKey(String value);
	
	/**
	 * 根据危险源id查询指定危险源下的类型为[日常巡检]的最久的一条[未巡检]的巡检任务
	 * @param inspect
	 * @return
	 */
	List<Inspect> selectBeforeOneByDangeroussourceId(Inspect inspect);
	
	/**
	 * 根据危险源地点id查询全部的点检次数
	 * @param inspect
	 * @return
	 */
	Integer selectInspectSummarySum(Inspect inspect);
	
	/**
	 * 根据危险源地点id查询全部的解决的隐患数量
	 * @param inspect
	 * @return
	 */
	Integer selectRectifedSummarySum(Inspect inspect);
	
	/**
	 * 根据危险源地点id查询全部的巡检人信息
	 * @param inspect
	 * @return
	 */
	List<User2> selectInspectUsers(Inspect inspect);
	
	/**
	 * 根据指定的时间和危险源id,查询一条或多条正在执行的[日常]巡检任务
	 * @param inspect
	 * @return
	 */
	List<Inspect> selectNowInspectByDId(Inspect inspect);
	
	/**
	 * 根据危险源id查询时间最近的已巡检的巡检任务记录
	 * @param inspect
	 * @return
	 */
	List<Inspect> selectLastTimeInspectedInspectByDId(Inspect inspect);
	
}