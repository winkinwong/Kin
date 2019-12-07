package com.kin.test.springboot.model;

import java.util.Date;
import java.util.List;

/**
 * 权限表
 * @author fangcheng and ja
 * 2019-06-06 16:06
 */
public class Function extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5338507080657564263L;
	/** ID */
 	private Integer functionId;
	/** 权限名称 */
 	private String functionName;
	/** 权限前端页面跳转路径 */
 	private String functionUrl;
 	/** 权限访问路径 */
 	private String functionServerUrl;
	/** 级别 */
 	private Integer type;
	/** 父级ID */
 	private Integer parentId;
	/** 创建时间 */
 	private Date createTime;
	/** 创建时间 开始时间 */
 	private String createTimeBegin;
    /** 创建时间 结束时间 */
 	private String createTimeEnd;
	/** 状态值 */
 	private String status;
 	
 	//前端页面传值所需要的属性
	/** 对于[跨公司信息查看]那组权限的跨公司id的设置 */
 	private List<Integer> companyIds;
	/** 对于[危险源]那组权限所关联的指定公司的部门id的设置 */
 	private List<Integer> departmentIds;
 	/** 对于[危险源]那组权限所关联的风险等级id的设置 */
 	private List<Integer> riskRankIds;
 	
 	
 	//关联查询需要用到的属性
 	/** 指定员工的id */
 	private Integer userId;
 	
 	
	/**
     * ID
     * @param functionId
     */
    public void setFunctionId(Integer functionId)
    {
        this.functionId = functionId;
    }
    
    /**
     * ID
     * @return
     */
	public Integer getFunctionId()
    {
        return functionId;
    }
    
    
	/**
     * 权限名称
     * @param functionName
     */
    public void setFunctionName(String functionName)
    {
        this.functionName = functionName;
    }
    
    /**
     * 权限名称
     * @return
     */
	public String getFunctionName()
    {
        return functionName;
    }
    
    
	/**
     * 权限前端页面跳转路径
     * @param functionUrl
     */
    public void setFunctionUrl(String functionUrl)
    {
        this.functionUrl = functionUrl;
    }
    
    /**
     * 权限前端页面跳转路径
     * @return
     */
	public String getFunctionUrl()
    {
        return functionUrl;
    }
    
    
	/**
     * 级别
     * @param type
     */
    public void setType(Integer type)
    {
        this.type = type;
    }
    
    /**
     * 级别
     * @return
     */
	public Integer getType()
    {
        return type;
    }
    
    
	/**
     * 父级ID
     * @param parentId
     */
    public void setParentId(Integer parentId)
    {
        this.parentId = parentId;
    }
    
    /**
     * 父级ID
     * @return
     */
	public Integer getParentId()
    {
        return parentId;
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
    
    public Function() {
		
	}

	public Function(Integer functionId, String functionName, String functionUrl, String functionServerUrl, Integer type, Integer parentId,
                    Date createTime, String createTimeBegin, String createTimeEnd, String status) {
		super();
		this.functionId = functionId;
		this.functionName = functionName;
		this.functionUrl = functionUrl;
		this.functionServerUrl = functionServerUrl;
		this.type = type;
		this.parentId = parentId;
		this.createTime = createTime;
		this.createTimeBegin = createTimeBegin;
		this.createTimeEnd = createTimeEnd;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Function [functionId=" + functionId + ", functionName=" + functionName + ", functionUrl=" + functionUrl + ", functionServerUrl=" + functionServerUrl
				+ ", type=" + type + ", parentId=" + parentId + ", createTime=" + createTime + ", createTimeBegin="
				+ createTimeBegin + ", createTimeEnd=" + createTimeEnd + ", status=" + status + "]";
	}

	public List<Integer> getCompanyIds() {
		return companyIds;
	}

	public void setCompanyIds(List<Integer> companyIds) {
		this.companyIds = companyIds;
	}

	public List<Integer> getDepartmentIds() {
		return departmentIds;
	}

	public void setDepartmentIds(List<Integer> departmentIds) {
		this.departmentIds = departmentIds;
	}

	public List<Integer> getRiskRankIds() {
		return riskRankIds;
	}

	public void setRiskRankIds(List<Integer> riskRankIds) {
		this.riskRankIds = riskRankIds;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFunctionServerUrl() {
		return functionServerUrl;
	}

	public void setFunctionServerUrl(String functionServerUrl) {
		this.functionServerUrl = functionServerUrl;
	}
    
}