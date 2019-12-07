package com.kin.test.springboot.dao;



import com.kin.test.springboot.model.InspectHistory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 巡检历史表(标准报表) DAO层
 * 
 * @author  fangcheng and ja
 * 2019-06-06 16:06
 */
@Repository("inspectHistoryDao")
public interface InspectHistoryDao
{
	/**
	 * 根据条件分页查询全部的巡检历史记录
	 * @param inspectHistory
	 * @return
	 */
	List<InspectHistory> selectByPageAndConditions(InspectHistory inspectHistory);
	
	//导出excel用到的
	List<InspectHistory> selectByConditions(InspectHistory inspectHistory);
	
	/**
	 * 根据条件查询全部的巡检历史记录的数量
	 * @param inspectHistory
	 * @return
	 */
	Integer countByExampleAndConditions(InspectHistory inspectHistory);
	
	/**
	 * 根据条件查询全部的巡检历史记录
	 * @param inspectHistory
	 * @return
	 */
	List<InspectHistory> selectByExampleAndConditions(InspectHistory inspectHistory);
	
	/**
	 * 查询指定巡检任务对应的时间最近的一条巡检历史记录
	 * @param inspectHistory
	 * @return
	 */
	List<InspectHistory> selectOneByInspectIdOfLastTime(InspectHistory inspectHistory);
	
	/**
	 * 查询指定的危险源中的时间最近的一条巡检历史记录
	 * @param inspectHistory
	 * @return
	 */
	List<InspectHistory> selectOneByDangeroussourceIdOfLastTime(InspectHistory inspectHistory);
	
	/**
	 * 查询指定巡检任务对应的时间最久的一条巡检历史(为了查询当前巡检是否有[未按期巡检]的情况)
	 * @param inspectHistory
	 * @return
	 */
	List<InspectHistory> selectOneByInspectIdOfBeforeTime(InspectHistory inspectHistory);
	
	/**
	 * 查询指定危险源地点的未按期点检次数统计
	 * @param inspectHistory
	 * @return
	 */
	Integer selectNoInspectSummarySum(InspectHistory inspectHistory);
	
	/**
	 * 查询指定危险源地点的发现隐患数量统计
	 * @param inspectHistory
	 * @return
	 */
	Integer selectNeedRectifySummarySum(InspectHistory inspectHistory);
	
	
	/**
	 * 查询指定危险源地点下的指定巡检类型的巡检历史记录中的最近时间
	 * @param inspectHistory
	 * @return
	 */
	Date selectMaxInspectDatetime(InspectHistory inspectHistory);
	
	/**
	 * 查询指定危险源地点下的指定巡检类型的巡检历史记录中的最久时间
	 * @param inspectHistory
	 * @return
	 */
	Date selectMinInspectDatetime(InspectHistory inspectHistory);

}