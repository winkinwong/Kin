package com.kin.test.springboot.model;

import java.util.Date;
import java.util.List;

/**
 * 角色表
 * @author fangcheng and ja
 * 2019-06-06 16:06
 */
public class Role extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3427616779679083474L;
	/** ID */
 	private Integer roleId;
	/** 角色名称 */
 	private String roleName;
 	/** 展示角色的顺序 */
 	private Integer roleShowNumber;
	/** 创建时间 */
 	private Date createTime;
	/** 创建时间 开始时间 */
 	private String createTimeBegin;
    /** 创建时间 结束时间 */
 	private String createTimeEnd;
	/** 状态值 */
 	private String status;
	/** 公司ID(company表) */
 	private Integer companyId;
 	/** 展示角色的公司ID(company表) */
 	private Integer showCompanyId;
 	
 	
 	//关联属性
 	/** 该角色关联的全部用户-角色中间表的记录 */
 	private List<UserRole> userRoles;
 	/** 该角色所属公司的名称 */
 	private String companyName;
 	/** 跨公司查看的公司id */
 	private List<Integer> companyIds;
 	
 	
 	//前端页面传值所需要的属性
 	/** 当前角色关联的所有权限 */
 	private List<Function> functions;
 	
 	
 	//需要给前端的属性
 	/** 本公司的标志 */
 	private Integer flag;
	
	/**
     * ID
     * @param roleId
     */
    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }
    
    /**
     * ID
     * @return
     */
	public Integer getRoleId()
    {
        return roleId;
    }
    
    
	/**
     * 角色名称
     * @param roleName
     */
    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }
    
    /**
     * 角色名称
     * @return
     */
	public String getRoleName()
    {
        return roleName;
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
     * 公司ID(company表)
     * @param companyId
     */
    public void setCompanyId(Integer companyId)
    {
        this.companyId = companyId;
    }
    
    /**
     * 公司ID(company表)
     * @return
     */
	public Integer getCompanyId()
    {
        return companyId;
    }
	
	public Integer getShowCompanyId() {
		return showCompanyId;
	}

	public void setShowCompanyId(Integer showCompanyId) {
		this.showCompanyId = showCompanyId;
	}
    
    public Role() {
		
	}

	public Role(Integer roleId, String roleName, Integer roleShowNumber, Date createTime, String createTimeBegin, String createTimeEnd,
                String status, Integer companyId, Integer showCompanyId) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleShowNumber = roleShowNumber;
		this.createTime = createTime;
		this.createTimeBegin = createTimeBegin;
		this.createTimeEnd = createTimeEnd;
		this.status = status;
		this.companyId = companyId;
		this.showCompanyId=showCompanyId;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleShowNumber=" + roleShowNumber + ", createTime=" + createTime + ", createTimeBegin="
				+ createTimeBegin + ", createTimeEnd=" + createTimeEnd + ", status=" + status + ", companyId="
				+ companyId + ", showCompanyId=" + showCompanyId + "]";
	}

	public List<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	
	public Integer getRoleShowNumber() {
		return roleShowNumber;
	}

	public void setRoleShowNumber(Integer roleShowNumber) {
		this.roleShowNumber = roleShowNumber;
	}
    
}