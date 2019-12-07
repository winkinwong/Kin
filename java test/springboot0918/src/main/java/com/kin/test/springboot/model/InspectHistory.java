package com.kin.test.springboot.model;

import com.kin.test.springboot.global.util.DateTimeUtil;

import java.util.Date;
import java.util.List;

/**
 * 巡检历史表(标准报表)
 * @author fangcheng and ja
 * 2019-06-06 16:06
 */
public class InspectHistory extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3460032911844286701L;
	/** ID */
 	private Integer inspectHistoryId;
	/** 巡检人真实姓名 */
 	private String userRealname;
	/** 危险源名称 */
 	private String dangeroussourceName;
	/** 危险源ID(dangeroussource表) */
 	private Integer dangeroussourceId;
	/** 危险源地点名称 */
 	private String dangeroussourcePlaceName;
	/** 危险源地点的场所 */
 	private String dangeroussourcePlacePlace;
	/** 危险源地点的出勤日巡检频率 */
 	private Double dangeroussourcePlaceAttendanceWorkdayFrequency;
	/** 危险源地点的非出勤日巡检频率 */
 	private Double dangeroussourcePlaceAttendanceRestdayFrequency;
	/** 巡检任务ID(inspect表) */
 	private Integer inspectId;
	/** 巡检结果 */
 	private String inspectResult;
	/** 问题描述 */
 	private String inspectQuestionDescribe;
	/** 巡检部门名称 */
 	private String departmentName;
	/** 巡检时间 */
 	private Date inspectDatetime;
	/** 巡检时间 开始时间 */
 	private String inspectDatetimeBegin;
    /** 巡检时间 结束时间 */
 	private String inspectDatetimeEnd;
	/** 巡检人电话 */
 	private String userPhoneNumber;
	/** 创建时间 */
 	private Date createTime;
	/** 创建时间 开始时间 */
 	private String createTimeBegin;
    /** 创建时间 结束时间 */
 	private String createTimeEnd;
	/** 状态值 */
 	private String status;
 	
 	
 	//关联属性
 	/** 对应的最后一条整改历史记录 */
 	private RectifyHistory lastRectifyHistory;
 	/** 对应的巡检任务所属的危险源地点的id */
 	private Integer dangeroussourcePlaceId;
 	/** 对应的巡检任务的巡检类型id */
 	private Integer inspectTypeId;
 	/** 巡检人姓名 */
 	private String rectifyUserRealName;
 	/** 整改时间格式化字符串 */
 	private String rectifyDatetimeStr;
 	/** 巡检类型名称 */
 	private String inspectTypeName;
 	/** 跨公司查看的公司id */
 	private List<Integer> companyIds;
 	/** 整改建议 */
 	private String inspectRectifyAdvise;
 	/** 事故类型名称 */
 	private String troubleTypeName;
 	
 	
 	//前端需要的字段
 	/** 巡检频率 */
 	private Double attendanceFrequency;
 	/** 本公司的标志 */
 	private Integer flag;
 	/** 当前巡检历史记录对应的全部巡检图片 */
 	//private List<InspectPicture> inspectPictures;
 	
 	
 	//新增字段
 	/** 巡检开始时间字符串 */
 	private String inspectDatetimeBeginStr;
 	/** 巡检结束时间字符串 */
 	private String inspectDatetimeEndStr;
 	/** 公司id */
 	private Integer companyId;
 	/** 部门id */
 	private Integer departmentId;
 	/** 巡检时间格式化字符串 */
 	private String inspectDatetimeStr;
 	
	public Integer getCompanyId() {
		return companyId;
	}
	
	

	public String getInspectDatetimeBeginStr() {
		return inspectDatetimeBeginStr;
	}



	public void setInspectDatetimeBeginStr(String inspectDatetimeBeginStr) {
		this.inspectDatetimeBeginStr = inspectDatetimeBeginStr;
	}



	public String getInspectDatetimeEndStr() {
		return inspectDatetimeEndStr;
	}



	public void setInspectDatetimeEndStr(String inspectDatetimeEndStr) {
		this.inspectDatetimeEndStr = inspectDatetimeEndStr;
	}



	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	/**
     * ID
     * @param inspectHistoryId
     */
    public void setInspectHistoryId(Integer inspectHistoryId)
    {
        this.inspectHistoryId = inspectHistoryId;
    }
    
    /**
     * ID
     * @return
     */
	public Integer getInspectHistoryId()
    {
        return inspectHistoryId;
    }
    
    
	/**
     * 巡检人真实姓名
     * @param userRealname
     */
    public void setUserRealname(String userRealname)
    {
        this.userRealname = userRealname;
    }
    
    /**
     * 巡检人真实姓名
     * @return
     */
	public String getUserRealname()
    {
        return userRealname;
    }
    
    
	/**
     * 危险源名称
     * @param dangeroussourceName
     */
    public void setDangeroussourceName(String dangeroussourceName)
    {
        this.dangeroussourceName = dangeroussourceName;
    }
    
    /**
     * 危险源名称
     * @return
     */
	public String getDangeroussourceName()
    {
        return dangeroussourceName;
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
     * 危险源地点名称
     * @param dangeroussourcePlaceName
     */
    public void setDangeroussourcePlaceName(String dangeroussourcePlaceName)
    {
        this.dangeroussourcePlaceName = dangeroussourcePlaceName;
    }
    
    /**
     * 危险源地点名称
     * @return
     */
	public String getDangeroussourcePlaceName()
    {
        return dangeroussourcePlaceName;
    }
    
    
	/**
     * 危险源地点的场所
     * @param dangeroussourcePlacePlace
     */
    public void setDangeroussourcePlacePlace(String dangeroussourcePlacePlace)
    {
        this.dangeroussourcePlacePlace = dangeroussourcePlacePlace;
    }
    
    /**
     * 危险源地点的场所
     * @return
     */
	public String getDangeroussourcePlacePlace()
    {
        return dangeroussourcePlacePlace;
    }
    
    
	/**
     * 危险源地点的出勤日巡检频率
     * @param dangeroussourcePlaceAttendanceWorkdayFrequency
     */
    public void setDangeroussourcePlaceAttendanceWorkdayFrequency(Double dangeroussourcePlaceAttendanceWorkdayFrequency)
    {
        this.dangeroussourcePlaceAttendanceWorkdayFrequency = dangeroussourcePlaceAttendanceWorkdayFrequency;
    }
    
    /**
     * 危险源地点的出勤日巡检频率
     * @return
     */
	public Double getDangeroussourcePlaceAttendanceWorkdayFrequency()
    {
        return dangeroussourcePlaceAttendanceWorkdayFrequency;
    }
    
    
	/**
     * 危险源地点的非出勤日巡检频率
     * @param dangeroussourcePlaceAttendanceRestdayFrequency
     */
    public void setDangeroussourcePlaceAttendanceRestdayFrequency(Double dangeroussourcePlaceAttendanceRestdayFrequency)
    {
        this.dangeroussourcePlaceAttendanceRestdayFrequency = dangeroussourcePlaceAttendanceRestdayFrequency;
    }
    
    /**
     * 危险源地点的非出勤日巡检频率
     * @return
     */
	public Double getDangeroussourcePlaceAttendanceRestdayFrequency()
    {
        return dangeroussourcePlaceAttendanceRestdayFrequency;
    }
    
    
	/**
     * 巡检任务ID(inspect表)
     * @param inspectId
     */
    public void setInspectId(Integer inspectId)
    {
        this.inspectId = inspectId;
    }
    
    /**
     * 巡检任务ID(inspect表)
     * @return
     */
	public Integer getInspectId()
    {
        return inspectId;
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
     * 巡检部门名称
     * @param departmentName
     */
    public void setDepartmentName(String departmentName)
    {
        this.departmentName = departmentName;
    }
    
    /**
     * 巡检部门名称
     * @return
     */
	public String getDepartmentName()
    {
        return departmentName;
    }
    
    
	/**
     * 巡检时间
     * @param inspectDatetime
     */
    public void setInspectDatetime(Date inspectDatetime)
    {
        this.inspectDatetime = inspectDatetime;
        this.inspectDatetimeStr= DateTimeUtil.dateTimeFormatToString(inspectDatetime, null);
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
     * 巡检人电话
     * @param userPhoneNumber
     */
    public void setUserPhoneNumber(String userPhoneNumber)
    {
        this.userPhoneNumber = userPhoneNumber;
    }
    
    /**
     * 巡检人电话
     * @return
     */
	public String getUserPhoneNumber()
    {
        return userPhoneNumber;
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
    
    public InspectHistory() {
		
	}

	public InspectHistory(Integer inspectHistoryId, String userRealname, String dangeroussourceName,
                          Integer dangeroussourceId, String dangeroussourcePlaceName, String dangeroussourcePlacePlace,
                          Double dangeroussourcePlaceAttendanceWorkdayFrequency,
                          Double dangeroussourcePlaceAttendanceRestdayFrequency, Integer inspectId, String inspectResult,
                          String inspectQuestionDescribe, String departmentName, Date inspectDatetime, String inspectDatetimeBegin,
                          String inspectDatetimeEnd, String userPhoneNumber, Date createTime, String createTimeBegin,
                          String createTimeEnd, String status) {
		super();
		this.inspectHistoryId = inspectHistoryId;
		this.userRealname = userRealname;
		this.dangeroussourceName = dangeroussourceName;
		this.dangeroussourceId = dangeroussourceId;
		this.dangeroussourcePlaceName = dangeroussourcePlaceName;
		this.dangeroussourcePlacePlace = dangeroussourcePlacePlace;
		this.dangeroussourcePlaceAttendanceWorkdayFrequency = dangeroussourcePlaceAttendanceWorkdayFrequency;
		this.dangeroussourcePlaceAttendanceRestdayFrequency = dangeroussourcePlaceAttendanceRestdayFrequency;
		this.inspectId = inspectId;
		this.inspectResult = inspectResult;
		this.inspectQuestionDescribe = inspectQuestionDescribe;
		this.departmentName = departmentName;
		this.inspectDatetime = inspectDatetime;
		this.inspectDatetimeBegin = inspectDatetimeBegin;
		this.inspectDatetimeEnd = inspectDatetimeEnd;
		this.userPhoneNumber = userPhoneNumber;
		this.createTime = createTime;
		this.createTimeBegin = createTimeBegin;
		this.createTimeEnd = createTimeEnd;
		this.status = status;
	}

	@Override
	public String toString() {
		return "InspectHistory [inspectHistoryId=" + inspectHistoryId + ", userRealname=" + userRealname
				+ ", dangeroussourceName=" + dangeroussourceName + ", dangeroussourceId=" + dangeroussourceId
				+ ", dangeroussourcePlaceName=" + dangeroussourcePlaceName + ", dangeroussourcePlacePlace="
				+ dangeroussourcePlacePlace + ", dangeroussourcePlaceAttendanceWorkdayFrequency="
				+ dangeroussourcePlaceAttendanceWorkdayFrequency + ", dangeroussourcePlaceAttendanceRestdayFrequency="
				+ dangeroussourcePlaceAttendanceRestdayFrequency + ", inspectId=" + inspectId + ", inspectResult="
				+ inspectResult + ", inspectQuestionDescribe=" + inspectQuestionDescribe + ", departmentName="
				+ departmentName + ", inspectDatetime=" + inspectDatetime + ", inspectDatetimeBegin="
				+ inspectDatetimeBegin + ", inspectDatetimeEnd=" + inspectDatetimeEnd + ", userPhoneNumber="
				+ userPhoneNumber + ", createTime=" + createTime + ", createTimeBegin=" + createTimeBegin
				+ ", createTimeEnd=" + createTimeEnd + ", status=" + status + "]";
	}

	public RectifyHistory getLastRectifyHistory() {
		return lastRectifyHistory;
	}

	public void setLastRectifyHistory(RectifyHistory lastRectifyHistory) {
		this.lastRectifyHistory = lastRectifyHistory;
	}



	public Integer getDangeroussourcePlaceId() {
		return dangeroussourcePlaceId;
	}



	public void setDangeroussourcePlaceId(Integer dangeroussourcePlaceId) {
		this.dangeroussourcePlaceId = dangeroussourcePlaceId;
	}



	public Integer getInspectTypeId() {
		return inspectTypeId;
	}



	public void setInspectTypeId(Integer inspectTypeId) {
		this.inspectTypeId = inspectTypeId;
	}



	public String getRectifyUserRealName() {
		return rectifyUserRealName;
	}



	public void setRectifyUserRealName(String rectifyUserRealName) {
		this.rectifyUserRealName = rectifyUserRealName;
	}



	public String getRectifyDatetimeStr() {
		return rectifyDatetimeStr;
	}



	public void setRectifyDatetimeStr(String rectifyDatetimeStr) {
		this.rectifyDatetimeStr = rectifyDatetimeStr;
	}



	public String getInspectDatetimeStr() {
		return inspectDatetimeStr;
	}



	public void setInspectDatetimeStr(String inspectDatetimeStr) {
		this.inspectDatetimeStr = inspectDatetimeStr;
	}



	public String getInspectTypeName() {
		return inspectTypeName;
	}



	public void setInspectTypeName(String inspectTypeName) {
		this.inspectTypeName = inspectTypeName;
	}



	public Double getAttendanceFrequency() {
		return attendanceFrequency;
	}



	public void setAttendanceFrequency(Double attendanceFrequency) {
		this.attendanceFrequency = attendanceFrequency;
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



	/*public List<InspectPicture> getInspectPictures() {
		return inspectPictures;
	}*/



	/*public void setInspectPictures(List<InspectPicture> inspectPictures) {
		this.inspectPictures = inspectPictures;
	}*/



	public String getInspectRectifyAdvise() {
		return inspectRectifyAdvise;
	}



	public void setInspectRectifyAdvise(String inspectRectifyAdvise) {
		this.inspectRectifyAdvise = inspectRectifyAdvise;
	}



	public String getTroubleTypeName() {
		return troubleTypeName;
	}



	public void setTroubleTypeName(String troubleTypeName) {
		this.troubleTypeName = troubleTypeName;
	}
    
}