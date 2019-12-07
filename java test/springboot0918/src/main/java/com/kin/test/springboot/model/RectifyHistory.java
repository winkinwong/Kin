package com.kin.test.springboot.model;

import com.kin.test.springboot.global.util.DateTimeUtil;

import java.util.Date;
import java.util.List;

/**
 * 整改历史表(标准报表)
 * @author fangcheng and ja
 * 2019-06-21 18:43
 */
public class RectifyHistory extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1186546267925319831L;
	/** ID */
 	private Integer rectifyHistoryId;
	/** 整改人真实姓名 */
 	private String userRealname;
	/** 危险源名称 */
 	private String dangeroussourceName;
	/** 危险源地点名称 */
 	private String dangeroussourcePlaceName;
	/** 危险源地点的场所 */
 	private String dangeroussourcePlacePlace;
	/** 整改任务ID(rectify表) */
 	private Integer rectifyId;
 	/** 整改说明 */
 	private String rectifyExplain;
	/** 整改结果 */
 	private String rectifyResult;
	/** 整改部门名称 */
 	private String departmentName;
	/** 整改时间 */
 	private Date rectifyDatetime;
	/** 整改时间 开始时间 */
 	private String rectifyDatetimeBegin;
    /** 整改时间 结束时间 */
 	private String rectifyDatetimeEnd;
	/** 整改期限 */
 	private Date rectifyDeadline;
	/** 整改期限 开始时间 */
 	private String rectifyDeadlineBegin;
    /** 整改期限 结束时间 */
 	private String rectifyDeadlineEnd;
	/** 整改人电话 */
 	private String userPhoneNumber;
	/** 审核任务ID(review表) */
 	private Integer reviewId;
	/** 审核人真实姓名 */
 	private String reviewUserRealname;
	/** 审核部门名称 */
 	private String reviewDepartmentName;
	/** 审核时间 */
 	private Date reviewDatetime;
	/** 审核时间 开始时间 */
 	private String reviewDatetimeBegin;
    /** 审核时间 结束时间 */
 	private String reviewDatetimeEnd;
	/** 审核人电话 */
 	private String reviewUserPhoneNumber;
 	/** 审核不通过原因 */
 	private String reviewFailReason;
	/** 创建时间 */
 	private Date createTime;
	/** 创建时间 开始时间 */
 	private String createTimeBegin;
    /** 创建时间 结束时间 */
 	private String createTimeEnd;
	/** 状态值 */
 	private String status;
 	
 	//关联的字段
 	/** 整改开始时间字符串 */
 	private String rectifyDatetimeBeginStr;
 	/** 整改结束时间字符串 */
 	private String rectifyDatetimeEndStr;
 	/** 公司id */
 	private Integer companyId;
 	/** 整改部门id */
 	private Integer departmentId;
 	/** 整改时间字符串 */
 	private String rectifyDatetimeStr;
 	/** 整改期限字符串 */
 	private String rectifyDeadlineStr;
 	/** 跨公司查看的公司id */
 	private List<Integer> companyIds;
 	/** 关联查询的关键词 */
 	private String key;
 	
 	
 	//前端需要的字段
 	/** 本公司的标志 */
 	private Integer flag;
 	
 	
	public String getRectifyDatetimeStr() {
		return rectifyDatetimeStr;
	}

	public void setRectifyDatetimeStr(String rectifyDatetimeStr) {
		this.rectifyDatetimeStr = rectifyDatetimeStr;
	}

	public String getRectifyDeadlineStr() {
		return rectifyDeadlineStr;
	}

	public void setRectifyDeadlineStr(String rectifyDeadlineStr) {
		this.rectifyDeadlineStr = rectifyDeadlineStr;
	}

	public String getRectifyDatetimeBeginStr() {
		return rectifyDatetimeBeginStr;
	}

	public void setRectifyDatetimeBeginStr(String rectifyDatetimeBeginStr) {
		this.rectifyDatetimeBeginStr = rectifyDatetimeBeginStr;
	}

	public String getRectifyDatetimeEndStr() {
		return rectifyDatetimeEndStr;
	}

	public void setRectifyDatetimeEndStr(String rectifyDatetimeEndStr) {
		this.rectifyDatetimeEndStr = rectifyDatetimeEndStr;
	}

	public Integer getCompanyId() {
		return companyId;
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
     * @param rectifyHistoryId
     */
    public void setRectifyHistoryId(Integer rectifyHistoryId)
    {
        this.rectifyHistoryId = rectifyHistoryId;
    }
    
    /**
     * ID
     * @return
     */
	public Integer getRectifyHistoryId()
    {
        return rectifyHistoryId;
    }
    
    
	/**
     * 整改人真实姓名
     * @param userRealname
     */
    public void setUserRealname(String userRealname)
    {
        this.userRealname = userRealname;
    }
    
    /**
     * 整改人真实姓名
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
     * 整改任务ID(rectify表)
     * @param rectifyId
     */
    public void setRectifyId(Integer rectifyId)
    {
        this.rectifyId = rectifyId;
    }
    
    /**
     * 整改任务ID(rectify表)
     * @return
     */
	public Integer getRectifyId()
    {
        return rectifyId;
    }
    
    
	/**
     * 整改结果
     * @param rectifyResult
     */
    public void setRectifyResult(String rectifyResult)
    {
        this.rectifyResult = rectifyResult;
    }
    
    /**
     * 整改结果
     * @return
     */
	public String getRectifyResult()
    {
        return rectifyResult;
    }
    
    
	/**
     * 整改部门名称
     * @param departmentName
     */
    public void setDepartmentName(String departmentName)
    {
        this.departmentName = departmentName;
    }
    
    /**
     * 整改部门名称
     * @return
     */
	public String getDepartmentName()
    {
        return departmentName;
    }
    
    
	/**
     * 整改时间
     * @param rectifyDatetime
     */
    public void setRectifyDatetime(Date rectifyDatetime)
    {
        this.rectifyDatetime = rectifyDatetime;
        this.rectifyDatetimeStr = DateTimeUtil.dateTimeFormatToString(rectifyDatetime, null);
    }
    
    /**
     * 整改时间
     * @return
     */
	public Date getRectifyDatetime()
    {
        return rectifyDatetime;
    }
    
    
    /**
     * 整改时间 开始时间
     * @param rectifyDatetimeBegin
     */
    public void setRectifyDatetimeBegin(String rectifyDatetimeBegin)
    {
        this.rectifyDatetimeBegin = rectifyDatetimeBegin;
    }
    
 	/**
     * 整改时间 开始时间
     * @return
     */
	public String getRectifyDatetimeBegin()
    {
        return rectifyDatetimeBegin;
    }
    
    /**
     * 整改时间 结束时间
     * @param rectifyDatetimeEnd
     */
    public void setRectifyDatetimeEnd(String rectifyDatetimeEnd)
    {
        this.rectifyDatetimeEnd = rectifyDatetimeEnd;
    }
 	
 	/**
     * 整改时间 结束时间
     * @return
     */
	public String getRectifyDatetimeEnd()
    {
        return rectifyDatetimeEnd;
    }
    
	/**
     * 整改期限
     * @param rectifyDeadline
     */
    public void setRectifyDeadline(Date rectifyDeadline)
    {
        this.rectifyDeadline = rectifyDeadline;
        this.rectifyDeadlineStr = DateTimeUtil.dateTimeFormatToString(rectifyDeadline, null);
    }
    
    /**
     * 整改期限
     * @return
     */
	public Date getRectifyDeadline()
    {
        return rectifyDeadline;
    }
    
    
    /**
     * 整改期限 开始时间
     * @param rectifyDeadlineBegin
     */
    public void setRectifyDeadlineBegin(String rectifyDeadlineBegin)
    {
        this.rectifyDeadlineBegin = rectifyDeadlineBegin;
    }
    
 	/**
     * 整改期限 开始时间
     * @return
     */
	public String getRectifyDeadlineBegin()
    {
        return rectifyDeadlineBegin;
    }
    
    /**
     * 整改期限 结束时间
     * @param rectifyDeadlineEnd
     */
    public void setRectifyDeadlineEnd(String rectifyDeadlineEnd)
    {
        this.rectifyDeadlineEnd = rectifyDeadlineEnd;
    }
 	
 	/**
     * 整改期限 结束时间
     * @return
     */
	public String getRectifyDeadlineEnd()
    {
        return rectifyDeadlineEnd;
    }
    
	/**
     * 整改人电话
     * @param userPhoneNumber
     */
    public void setUserPhoneNumber(String userPhoneNumber)
    {
        this.userPhoneNumber = userPhoneNumber;
    }
    
    /**
     * 整改人电话
     * @return
     */
	public String getUserPhoneNumber()
    {
        return userPhoneNumber;
    }
    
    
	/**
     * 审核任务ID(review表)
     * @param reviewId
     */
    public void setReviewId(Integer reviewId)
    {
        this.reviewId = reviewId;
    }
    
    /**
     * 审核任务ID(review表)
     * @return
     */
	public Integer getReviewId()
    {
        return reviewId;
    }
    
    
	/**
     * 审核人真实姓名
     * @param reviewUserRealname
     */
    public void setReviewUserRealname(String reviewUserRealname)
    {
        this.reviewUserRealname = reviewUserRealname;
    }
    
    /**
     * 审核人真实姓名
     * @return
     */
	public String getReviewUserRealname()
    {
        return reviewUserRealname;
    }
    
    
	/**
     * 审核部门名称
     * @param reviewDepartmentName
     */
    public void setReviewDepartmentName(String reviewDepartmentName)
    {
        this.reviewDepartmentName = reviewDepartmentName;
    }
    
    /**
     * 审核部门名称
     * @return
     */
	public String getReviewDepartmentName()
    {
        return reviewDepartmentName;
    }
    
    
	/**
     * 审核时间
     * @param reviewDatetime
     */
    public void setReviewDatetime(Date reviewDatetime)
    {
        this.reviewDatetime = reviewDatetime;
    }
    
    /**
     * 审核时间
     * @return
     */
	public Date getReviewDatetime()
    {
        return reviewDatetime;
    }
    
    
    /**
     * 审核时间 开始时间
     * @param reviewDatetimeBegin
     */
    public void setReviewDatetimeBegin(String reviewDatetimeBegin)
    {
        this.reviewDatetimeBegin = reviewDatetimeBegin;
    }
    
 	/**
     * 审核时间 开始时间
     * @return
     */
	public String getReviewDatetimeBegin()
    {
        return reviewDatetimeBegin;
    }
    
    /**
     * 审核时间 结束时间
     * @param reviewDatetimeEnd
     */
    public void setReviewDatetimeEnd(String reviewDatetimeEnd)
    {
        this.reviewDatetimeEnd = reviewDatetimeEnd;
    }
 	
 	/**
     * 审核时间 结束时间
     * @return
     */
	public String getReviewDatetimeEnd()
    {
        return reviewDatetimeEnd;
    }
    
	/**
     * 审核人电话
     * @param reviewUserPhoneNumber
     */
    public void setReviewUserPhoneNumber(String reviewUserPhoneNumber)
    {
        this.reviewUserPhoneNumber = reviewUserPhoneNumber;
    }
    
    /**
     * 审核人电话
     * @return
     */
	public String getReviewUserPhoneNumber()
    {
        return reviewUserPhoneNumber;
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

	@Override
	public String toString() {
		return "RectifyHistory [rectifyHistoryId=" + rectifyHistoryId + ", userRealname=" + userRealname
				+ ", dangeroussourceName=" + dangeroussourceName + ", dangeroussourcePlaceName="
				+ dangeroussourcePlaceName + ", dangeroussourcePlacePlace=" + dangeroussourcePlacePlace + ", rectifyId="
				+ rectifyId + ", rectifyExplain=" + rectifyExplain + ", rectifyResult=" + rectifyResult + ", departmentName=" + departmentName
				+ ", rectifyDatetime=" + rectifyDatetime + ", rectifyDatetimeBegin=" + rectifyDatetimeBegin
				+ ", rectifyDatetimeEnd=" + rectifyDatetimeEnd + ", rectifyDeadline=" + rectifyDeadline
				+ ", rectifyDeadlineBegin=" + rectifyDeadlineBegin + ", rectifyDeadlineEnd=" + rectifyDeadlineEnd
				+ ", userPhoneNumber=" + userPhoneNumber + ", reviewId=" + reviewId + ", reviewUserRealname="
				+ reviewUserRealname + ", reviewDepartmentName=" + reviewDepartmentName + ", reviewDatetime="
				+ reviewDatetime + ", reviewDatetimeBegin=" + reviewDatetimeBegin + ", reviewDatetimeEnd="
				+ reviewDatetimeEnd + ", reviewUserPhoneNumber=" + reviewUserPhoneNumber + ", reviewFailReason=" + reviewFailReason 
				+ ", createTime=" + createTime
				+ ", createTimeBegin=" + createTimeBegin + ", createTimeEnd=" + createTimeEnd + ", status=" + status
				+ "]";
	}

	public RectifyHistory(Integer rectifyHistoryId, String userRealname, String dangeroussourceName,
                          String dangeroussourcePlaceName, String dangeroussourcePlacePlace, Integer rectifyId, String rectifyExplain, String rectifyResult,
                          String departmentName, Date rectifyDatetime, String rectifyDatetimeBegin, String rectifyDatetimeEnd,
                          Date rectifyDeadline, String rectifyDeadlineBegin, String rectifyDeadlineEnd, String userPhoneNumber,
                          Integer reviewId, String reviewUserRealname, String reviewDepartmentName, Date reviewDatetime,
                          String reviewDatetimeBegin, String reviewDatetimeEnd, String reviewUserPhoneNumber, String reviewFailReason, Date createTime,
                          String createTimeBegin, String createTimeEnd, String status) {
		super();
		this.rectifyHistoryId = rectifyHistoryId;
		this.userRealname = userRealname;
		this.dangeroussourceName = dangeroussourceName;
		this.dangeroussourcePlaceName = dangeroussourcePlaceName;
		this.dangeroussourcePlacePlace = dangeroussourcePlacePlace;
		this.rectifyId = rectifyId;
		this.rectifyExplain = rectifyExplain;
		this.rectifyResult = rectifyResult;
		this.departmentName = departmentName;
		this.rectifyDatetime = rectifyDatetime;
		this.rectifyDatetimeBegin = rectifyDatetimeBegin;
		this.rectifyDatetimeEnd = rectifyDatetimeEnd;
		this.rectifyDeadline = rectifyDeadline;
		this.rectifyDeadlineBegin = rectifyDeadlineBegin;
		this.rectifyDeadlineEnd = rectifyDeadlineEnd;
		this.userPhoneNumber = userPhoneNumber;
		this.reviewId = reviewId;
		this.reviewUserRealname = reviewUserRealname;
		this.reviewDepartmentName = reviewDepartmentName;
		this.reviewDatetime = reviewDatetime;
		this.reviewDatetimeBegin = reviewDatetimeBegin;
		this.reviewDatetimeEnd = reviewDatetimeEnd;
		this.reviewUserPhoneNumber = reviewUserPhoneNumber;
		this.reviewFailReason = reviewFailReason;
		this.createTime = createTime;
		this.createTimeBegin = createTimeBegin;
		this.createTimeEnd = createTimeEnd;
		this.status = status;
	}
    public RectifyHistory() {
		
	}

	public String getReviewFailReason() {
		return reviewFailReason;
	}

	public void setReviewFailReason(String reviewFailReason) {
		this.reviewFailReason = reviewFailReason;
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

	public String getRectifyExplain() {
		return rectifyExplain;
	}

	public void setRectifyExplain(String rectifyExplain) {
		this.rectifyExplain = rectifyExplain;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
    
}