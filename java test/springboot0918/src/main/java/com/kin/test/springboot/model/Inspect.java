package com.kin.test.springboot.model;

import com.kin.test.springboot.global.util.DateTimeUtil;

import java.util.Date;
import java.util.List;

/**
 * 巡检(任务)表
 * @author fangcheng and ja
 * 2019-06-06 16:06
 */
public class Inspect extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5485952092410726384L;
	/** ID */
 	private Integer inspectId;
	/** 巡检时间 */
 	private Date inspectDatetime;
	/** 巡检时间 开始时间 */
 	private String inspectDatetimeBegin;
    /** 巡检时间 结束时间 */
 	private String inspectDatetimeEnd;
 	/** 巡检时间 结束时间(带时分秒的) */
 	private String inspectDatetimeEnd2;
	/** 巡检期限 */
 	private Date inspectDeadline;
	/** 巡检期限 开始时间 */
 	private String inspectDeadlineBegin;
    /** 巡检期限 结束时间 */
 	private String inspectDeadlineEnd;
 	/** 巡检期限 结束时间(带时分秒的) */
 	private String inspectDeadlineEnd2;
	/** 巡检状态 */
 	private String inspectStatus;
	/** 巡检结果 */
 	private String inspectResult;
	/** 问题描述 */
 	private String inspectQuestionDescribe;
	/** 整改建议 */
 	private String inspectRectifyAdvise;
 	/** 整改期限 */
 	private Date inspectRectifyDeadline;
 	/** 整改期限 开始时间 */
 	private String inspectRectifyDeadlineBegin;
 	/** 整改期限 结束时间 */
 	private String inspectRectifyDeadlineEnd;
 	/** 巡检开始通知标记 */
 	private String inspectStart;
 	/** 巡检期限确定状态 */
 	private String inspectRectifyDeadlineStatus;
	/** 创建时间 */
 	private Date createTime;
	/** 创建时间 开始时间 */
 	private String createTimeBegin;
    /** 创建时间 结束时间 */
 	private String createTimeEnd;
	/** 状态值 */
 	private String status;
	/** 危险源ID(dangeroussource表) */
 	private Integer dangeroussourceId;
	/** 事故类型ID(trouble_type表) */
 	private Integer troubleTypeId;
	/** 危险源-检查类型(复合中间表)ID(dangeroussource_place_inspect_type表) */
 	private Integer dangeroussourcePlaceInspectTypeId;
	/** (巡检人)用户ID(user表) */
 	private Integer userId;
 	/** 检查类型ID(inspect_type表) */
 	private Integer inspectTypeId;
 	/** 当前巡检任务对应的整改人ID(user表) */
 	private Integer rectifyUserId;
 	
 	//关联查询需要的额外属性
 	/** 所属公司id */
 	private Integer companyId;
 	/** 危险源地点名称 */
 	private String dangeroussourcePlaceName;
 	/** 危险源名称 */
 	private String dangeroussourceName;
 	/** 巡检人名称 */
 	private String inspectUserRealName;
 	/** 整改人名称 */
 	private String rectifyUserRealName;
 	/** 检查类型名称 */
 	private String inspectTypeName;
 	/** 事故类型名称 */
 	private String troubleTypeName;
 	/** 巡检任务的全部图片对象 */
 	//private List<InspectPicture> inspectPictures;
 	/** 所属危险源地点的地址 */
 	private String dangeroussourcePlacePlace;
 	/** 所属危险源地点的出勤日巡检频率 */
 	private Double dangeroussourcePlaceAttendanceWorkdayFrequency;
 	/** 所属危险源地点的非出勤日巡检频率 */
 	private Double dangeroussourcePlaceAttendanceRestdayFrequency;
 	/** 巡检任务的巡检部门名称 */
 	private String departmentName;
 	/** 巡检人电话 */
 	private String userPhoneNumber;
 	/** 所属的危险源的危险源描述 */
 	private String dangeroussourceDescribe;
 	/** 所属危险源地点的id */
 	private Integer dangeroussourcePlaceId;
 	/** 巡检任务所属危险源的所属部门id */
 	private Integer departmentId;
 	/** 跨公司查看所需要用到的多个公司id */
 	private List<Integer> companyIds;
 	/** 当前巡检任务对应的整改部门id */
 	private Integer rectifyDepartmentId;
 	/** 当前日期时间的字符串格式 */
 	private String nowStr;
 	
 	//前端传来的额外属性
 	/** 巡检任务的若干个巡检图片记录的id */
 	private List<Integer> inspectPictureIds;
 	/** 当前巡检任务中要删除的若干个巡检图片记录的id */
 	private List<Integer> deleteInspectPictureIds;
 	/** 巡检任务的巡检状态选择值 */
 	private Integer inspectStatusInt;
	/** 查询的关键词 */
 	private String key;
 	/** 添加的若干检查项id */
 	private List<Integer> inspectTermIds;
 	/** 若干检查项的检查结果 */
 	private List<String> inspectTermResults;
 	
 	
 	//前端需要的属性
 	/** 巡检时间的格式化字符串 */
 	private String inspectDatetimeStr;
 	/** 整改期限的格式化字符串 */
 	private String inspectRectifyDeadlineStr;
 	/** 跨公司查看的标记 */
 	private Integer flag;
 	/** 仅本部门的标记 */
 	private Integer inDepartmentFlag;
 	
 	
	/**
     * ID
     * @param inspectId
     */
    public void setInspectId(Integer inspectId)
    {
        this.inspectId = inspectId;
    }
    
    /**
     * ID
     * @return
     */
	public Integer getInspectId()
    {
        return inspectId;
    }
    
    
	/**
     * 巡检时间
     * @param inspectDatetime
     */
    public void setInspectDatetime(Date inspectDatetime)
    {
        this.inspectDatetime = inspectDatetime;
        this.inspectDatetimeStr=DateTimeUtil.dateTimeFormatToString(inspectDatetime, null);
    }
    
    /**
     * 巡检时间
     * @return
     */
	public Date getInspectDatetime()
    {
        return inspectDatetime;
    }
    
    
    /**
     * 巡检时间 开始时间
     * @param inspectDatetimeBegin
     */
    public void setInspectDatetimeBegin(String inspectDatetimeBegin)
    {
        this.inspectDatetimeBegin = inspectDatetimeBegin;
    }
    
 	/**
     * 巡检时间 开始时间
     * @return
     */
	public String getInspectDatetimeBegin()
    {
        return inspectDatetimeBegin;
    }
    
    /**
     * 巡检时间 结束时间
     * @param inspectDatetimeEnd
     */
    public void setInspectDatetimeEnd(String inspectDatetimeEnd)
    {
        this.inspectDatetimeEnd = inspectDatetimeEnd;
    }
 	
 	/**
     * 巡检时间 结束时间
     * @return
     */
	public String getInspectDatetimeEnd()
    {
        return inspectDatetimeEnd;
    }
    
	/**
     * 巡检期限
     * @param inspectDeadline
     */
    public void setInspectDeadline(Date inspectDeadline)
    {
        this.inspectDeadline = inspectDeadline;
    }
    
    /**
     * 巡检期限
     * @return
     */
	public Date getInspectDeadline()
    {
        return inspectDeadline;
    }
    
    
    /**
     * 巡检期限 开始时间
     * @param inspectDeadlineBegin
     */
    public void setInspectDeadlineBegin(String inspectDeadlineBegin)
    {
        this.inspectDeadlineBegin = inspectDeadlineBegin;
    }
    
 	/**
     * 巡检期限 开始时间
     * @return
     */
	public String getInspectDeadlineBegin()
    {
        return inspectDeadlineBegin;
    }
    
    /**
     * 巡检期限 结束时间
     * @param inspectDeadlineEnd
     */
    public void setInspectDeadlineEnd(String inspectDeadlineEnd)
    {
        this.inspectDeadlineEnd = inspectDeadlineEnd;
    }
 	
 	/**
     * 巡检期限 结束时间
     * @return
     */
	public String getInspectDeadlineEnd()
    {
        return inspectDeadlineEnd;
    }
    
	/**
     * 巡检状态
     * @param inspectStatus
     */
    public void setInspectStatus(String inspectStatus)
    {
        this.inspectStatus = inspectStatus;
    }
    
    /**
     * 巡检状态
     * @return
     */
	public String getInspectStatus()
    {
        return inspectStatus;
    }
    
    
	/**
     * 巡检结果
     * @param inspectResult
     */
    public void setInspectResult(String inspectResult)
    {
        this.inspectResult = inspectResult;
    }
    
    /**
     * 巡检结果
     * @return
     */
	public String getInspectResult()
    {
        return inspectResult;
    }
    
    
	/**
     * 问题描述
     * @param inspectQuestionDescribe
     */
    public void setInspectQuestionDescribe(String inspectQuestionDescribe)
    {
        this.inspectQuestionDescribe = inspectQuestionDescribe;
    }
    
    /**
     * 问题描述
     * @return
     */
	public String getInspectQuestionDescribe()
    {
        return inspectQuestionDescribe;
    }
    
    
	/**
     * 整改建议
     * @param inspectRectifyAdvise
     */
    public void setInspectRectifyAdvise(String inspectRectifyAdvise)
    {
        this.inspectRectifyAdvise = inspectRectifyAdvise;
    }
    
    /**
     * 整改建议
     * @return
     */
	public String getInspectRectifyAdvise()
    {
        return inspectRectifyAdvise;
    }
    
	
	public Date getInspectRectifyDeadline() {
		return inspectRectifyDeadline;
	}

	public void setInspectRectifyDeadline(Date inspectRectifyDeadline) {
		this.inspectRectifyDeadline = inspectRectifyDeadline;
		this.inspectRectifyDeadlineStr= DateTimeUtil.dateTimeFormatToString(inspectRectifyDeadline, null);
	}
	
    
	/**
     * 创建时间
     * @param createTime
     */
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    
    /**
     * 创建时间
     * @return
     */
	public Date getCreateTime()
    {
        return createTime;
    }
    
    
    /**
     * 创建时间 开始时间
     * @param createTimeBegin
     */
    public void setCreateTimeBegin(String createTimeBegin)
    {
        this.createTimeBegin = createTimeBegin;
    }
    
 	/**
     * 创建时间 开始时间
     * @return
     */
	public String getCreateTimeBegin()
    {
        return createTimeBegin;
    }
    
    /**
     * 创建时间 结束时间
     * @param createTimeEnd
     */
    public void setCreateTimeEnd(String createTimeEnd)
    {
        this.createTimeEnd = createTimeEnd;
    }
 	
 	/**
     * 创建时间 结束时间
     * @return
     */
	public String getCreateTimeEnd()
    {
        return createTimeEnd;
    }
    
	/**
     * 状态值
     * @param status
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    /**
     * 状态值
     * @return
     */
	public String getStatus()
    {
        return status;
    }
    
    
	/**
     * 危险源ID(dangeroussource表)
     * @param dangeroussourceId
     */
    public void setDangeroussourceId(Integer dangeroussourceId)
    {
        this.dangeroussourceId = dangeroussourceId;
    }
    
    /**
     * 危险源ID(dangeroussource表)
     * @return
     */
	public Integer getDangeroussourceId()
    {
        return dangeroussourceId;
    }
    
    
	/**
     * 事故类型ID(trouble_type表)
     * @param troubleTypeId
     */
    public void setTroubleTypeId(Integer troubleTypeId)
    {
        this.troubleTypeId = troubleTypeId;
    }
    
    /**
     * 事故类型ID(trouble_type表)
     * @return
     */
	public Integer getTroubleTypeId()
    {
        return troubleTypeId;
    }
    
    
	/**
     * 危险源-检查类型(复合中间表)ID(dangeroussource_place_inspect_type表)
     * @param dangeroussourcePlaceInspectTypeId
     */
    public void setDangeroussourcePlaceInspectTypeId(Integer dangeroussourcePlaceInspectTypeId)
    {
        this.dangeroussourcePlaceInspectTypeId = dangeroussourcePlaceInspectTypeId;
    }
    
    /**
     * 危险源-检查类型(复合中间表)ID(dangeroussource_place_inspect_type表)
     * @return
     */
	public Integer getDangeroussourcePlaceInspectTypeId()
    {
        return dangeroussourcePlaceInspectTypeId;
    }
    
    
	/**
     * (巡检人)用户ID(user表)
     * @param userId
     */
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }
    
    /**
     * (巡检人)用户ID(user表)
     * @return
     */
	public Integer getUserId()
    {
        return userId;
    }
	
	public Integer getInspectTypeId() {
		return inspectTypeId;
	}

	public void setInspectTypeId(Integer inspectTypeId) {
		this.inspectTypeId = inspectTypeId;
	}
	
	public Integer getRectifyUserId() {
		return rectifyUserId;
	}

	public void setRectifyUserId(Integer rectifyUserId) {
		this.rectifyUserId = rectifyUserId;
	}
    
    public Inspect() {
		
	}

	public Inspect(Integer inspectId, Date inspectDatetime, String inspectDatetimeBegin, String inspectDatetimeEnd,
                   Date inspectDeadline, String inspectDeadlineBegin, String inspectDeadlineEnd, String inspectStatus,
                   String inspectResult, String inspectQuestionDescribe, String inspectRectifyAdvise, Date inspectRectifyDeadline, String inspectStart,
                   String inspectRectifyDeadlineStatus, Date createTime,
                   String createTimeBegin, String createTimeEnd, String status, Integer dangeroussourceId,
                   Integer troubleTypeId, Integer dangeroussourcePlaceInspectTypeId, Integer userId, Integer inspectTypeId,
                   Integer rectifyUserId) {
		super();
		this.inspectId = inspectId;
		this.inspectDatetime = inspectDatetime;
		this.inspectDatetimeBegin = inspectDatetimeBegin;
		this.inspectDatetimeEnd = inspectDatetimeEnd;
		this.inspectDeadline = inspectDeadline;
		this.inspectDeadlineBegin = inspectDeadlineBegin;
		this.inspectDeadlineEnd = inspectDeadlineEnd;
		this.inspectStatus = inspectStatus;
		this.inspectResult = inspectResult;
		this.inspectQuestionDescribe = inspectQuestionDescribe;
		this.inspectRectifyAdvise = inspectRectifyAdvise;
		this.inspectRectifyDeadline=inspectRectifyDeadline;
		this.inspectStart=inspectStart;
		this.inspectRectifyDeadlineStatus=inspectRectifyDeadlineStatus;
		this.createTime = createTime;
		this.createTimeBegin = createTimeBegin;
		this.createTimeEnd = createTimeEnd;
		this.status = status;
		this.dangeroussourceId = dangeroussourceId;
		this.troubleTypeId = troubleTypeId;
		this.dangeroussourcePlaceInspectTypeId = dangeroussourcePlaceInspectTypeId;
		this.userId = userId;
		this.inspectTypeId=inspectTypeId;
		this.rectifyUserId=rectifyUserId;
	}

	@Override
	public String toString() {
		return "Inspect [inspectId=" + inspectId + ", inspectDatetime=" + inspectDatetime + ", inspectDatetimeBegin="
				+ inspectDatetimeBegin + ", inspectDatetimeEnd=" + inspectDatetimeEnd + ", inspectDeadline="
				+ inspectDeadline + ", inspectDeadlineBegin=" + inspectDeadlineBegin + ", inspectDeadlineEnd="
				+ inspectDeadlineEnd + ", inspectStatus=" + inspectStatus + ", inspectResult=" + inspectResult
				+ ", inspectQuestionDescribe=" + inspectQuestionDescribe + ", inspectRectifyAdvise="
				+ inspectRectifyAdvise + ", inspectRectifyDeadline=" + inspectRectifyDeadline + ", inspectStart=" + inspectStart
				+", inspectRectifyDeadlineStatus=" + inspectRectifyDeadlineStatus + ", createTime=" + createTime + ", createTimeBegin=" + createTimeBegin
				+ ", createTimeEnd=" + createTimeEnd + ", status=" + status + ", dangeroussourceId=" + dangeroussourceId
				+ ", troubleTypeId=" + troubleTypeId + ", dangeroussourcePlaceInspectTypeId="
				+ dangeroussourcePlaceInspectTypeId + ", userId=" + userId + ", inspectTypeId=" + inspectTypeId
				+ ", rectifyUserId=" + rectifyUserId + "]";
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getDangeroussourcePlaceName() {
		return dangeroussourcePlaceName;
	}

	public void setDangeroussourcePlaceName(String dangeroussourcePlaceName) {
		this.dangeroussourcePlaceName = dangeroussourcePlaceName;
	}

	public String getDangeroussourceName() {
		return dangeroussourceName;
	}

	public void setDangeroussourceName(String dangeroussourceName) {
		this.dangeroussourceName = dangeroussourceName;
	}

	public String getInspectUserRealName() {
		return inspectUserRealName;
	}

	public void setInspectUserRealName(String inspectUserRealName) {
		this.inspectUserRealName = inspectUserRealName;
	}

	public String getRectifyUserRealName() {
		return rectifyUserRealName;
	}

	public void setRectifyUserRealName(String rectifyUserRealName) {
		this.rectifyUserRealName = rectifyUserRealName;
	}

	public String getInspectTypeName() {
		return inspectTypeName;
	}

	public void setInspectTypeName(String inspectTypeName) {
		this.inspectTypeName = inspectTypeName;
	}

	public String getTroubleTypeName() {
		return troubleTypeName;
	}

	public void setTroubleTypeName(String troubleTypeName) {
		this.troubleTypeName = troubleTypeName;
	}

/*	public List<InspectPicture> getInspectPictures() {
		return inspectPictures;
	}*/

	/*public void setInspectPictures(List<InspectPicture> inspectPictures) {
		this.inspectPictures = inspectPictures;
	}
*/
	public String getInspectRectifyDeadlineBegin() {
		return inspectRectifyDeadlineBegin;
	}

	public void setInspectRectifyDeadlineBegin(String inspectRectifyDeadlineBegin) {
		this.inspectRectifyDeadlineBegin = inspectRectifyDeadlineBegin;
	}

	public String getInspectRectifyDeadlineEnd() {
		return inspectRectifyDeadlineEnd;
	}

	public void setInspectRectifyDeadlineEnd(String inspectRectifyDeadlineEnd) {
		this.inspectRectifyDeadlineEnd = inspectRectifyDeadlineEnd;
	}

	public List<Integer> getInspectPictureIds() {
		return inspectPictureIds;
	}

	public void setInspectPictureIds(List<Integer> inspectPictureIds) {
		this.inspectPictureIds = inspectPictureIds;
	}

	public List<Integer> getDeleteInspectPictureIds() {
		return deleteInspectPictureIds;
	}

	public void setDeleteInspectPictureIds(List<Integer> deleteInspectPictureIds) {
		this.deleteInspectPictureIds = deleteInspectPictureIds;
	}

	public Integer getInspectStatusInt() {
		return inspectStatusInt;
	}

	public void setInspectStatusInt(Integer inspectStatusInt) {
		this.inspectStatusInt = inspectStatusInt;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<Integer> getInspectTermIds() {
		return inspectTermIds;
	}

	public void setInspectTermIds(List<Integer> inspectTermIds) {
		this.inspectTermIds = inspectTermIds;
	}

	public List<String> getInspectTermResults() {
		return inspectTermResults;
	}

	public void setInspectTermResults(List<String> inspectTermResults) {
		this.inspectTermResults = inspectTermResults;
	}

	public String getDangeroussourcePlacePlace() {
		return dangeroussourcePlacePlace;
	}

	public void setDangeroussourcePlacePlace(String dangeroussourcePlacePlace) {
		this.dangeroussourcePlacePlace = dangeroussourcePlacePlace;
	}

	public Double getDangeroussourcePlaceAttendanceWorkdayFrequency() {
		return dangeroussourcePlaceAttendanceWorkdayFrequency;
	}

	public void setDangeroussourcePlaceAttendanceWorkdayFrequency(
			Double dangeroussourcePlaceAttendanceWorkdayFrequency) {
		this.dangeroussourcePlaceAttendanceWorkdayFrequency = dangeroussourcePlaceAttendanceWorkdayFrequency;
	}

	public Double getDangeroussourcePlaceAttendanceRestdayFrequency() {
		return dangeroussourcePlaceAttendanceRestdayFrequency;
	}

	public void setDangeroussourcePlaceAttendanceRestdayFrequency(
			Double dangeroussourcePlaceAttendanceRestdayFrequency) {
		this.dangeroussourcePlaceAttendanceRestdayFrequency = dangeroussourcePlaceAttendanceRestdayFrequency;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getDangeroussourceDescribe() {
		return dangeroussourceDescribe;
	}

	public void setDangeroussourceDescribe(String dangeroussourceDescribe) {
		this.dangeroussourceDescribe = dangeroussourceDescribe;
	}

	public Integer getDangeroussourcePlaceId() {
		return dangeroussourcePlaceId;
	}

	public void setDangeroussourcePlaceId(Integer dangeroussourcePlaceId) {
		this.dangeroussourcePlaceId = dangeroussourcePlaceId;
	}

	public String getInspectStart() {
		return inspectStart;
	}

	public void setInspectStart(String inspectStart) {
		this.inspectStart = inspectStart;
	}

	public String getInspectDatetimeEnd2() {
		return inspectDatetimeEnd2;
	}

	public void setInspectDatetimeEnd2(String inspectDatetimeEnd2) {
		this.inspectDatetimeEnd2 = inspectDatetimeEnd2;
	}

	public String getInspectDeadlineEnd2() {
		return inspectDeadlineEnd2;
	}

	public void setInspectDeadlineEnd2(String inspectDeadlineEnd2) {
		this.inspectDeadlineEnd2 = inspectDeadlineEnd2;
	}

	public String getInspectRectifyDeadlineStatus() {
		return inspectRectifyDeadlineStatus;
	}

	public void setInspectRectifyDeadlineStatus(String inspectRectifyDeadlineStatus) {
		this.inspectRectifyDeadlineStatus = inspectRectifyDeadlineStatus;
	}

	public String getInspectDatetimeStr() {
		return inspectDatetimeStr;
	}

	public void setInspectDatetimeStr(String inspectDatetimeStr) {
		this.inspectDatetimeStr = inspectDatetimeStr;
	}

	public String getInspectRectifyDeadlineStr() {
		return inspectRectifyDeadlineStr;
	}

	public void setInspectRectifyDeadlineStr(String inspectRectifyDeadlineStr) {
		this.inspectRectifyDeadlineStr = inspectRectifyDeadlineStr;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public List<Integer> getCompanyIds() {
		return companyIds;
	}

	public void setCompanyIds(List<Integer> companyIds) {
		this.companyIds = companyIds;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getRectifyDepartmentId() {
		return rectifyDepartmentId;
	}

	public void setRectifyDepartmentId(Integer rectifyDepartmentId) {
		this.rectifyDepartmentId = rectifyDepartmentId;
	}

	public String getNowStr() {
		return nowStr;
	}

	public void setNowStr(String nowStr) {
		this.nowStr = nowStr;
	}

	public Integer getInDepartmentFlag() {
		return inDepartmentFlag;
	}

	public void setInDepartmentFlag(Integer inDepartmentFlag) {
		this.inDepartmentFlag = inDepartmentFlag;
	}
    
}