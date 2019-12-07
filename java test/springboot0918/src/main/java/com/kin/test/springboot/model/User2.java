package com.kin.test.springboot.model;


import java.util.Date;
import java.util.List;

/**
 * 用户表
 * @author fangcheng and ja
 * 2019-06-06 16:06
 */
public class User2 extends BaseEntity
{
	/**
	 *
	 */
	private static final long serialVersionUID = -4036342720321612721L;
	/** ID */
 	private Integer userId;
	/** 用户名 */
 	private String userName;
	/** 密码 */
 	private String userPassword;
	/** 真实姓名 */
 	private String userRealname;
	/** 年龄 */
 	private Integer userAge;
 	/** 性别 */
 	private String userGender;
	/** 电话 */
 	private String userPhoneNumber;
	/** 职务 */
 	private String userPosition;
	/** 用户头像图片的访问路径 */
 	private String userPictureUrl;
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

 	//关联属性
 	/** 所属的公司名称 */
 	private String companyName;
	/** 所属的部门名称 */
 	private String departmentName;
 	/** 所属的部门id */
 	private Integer departmentId;
 	/** 关联的一个角色id */
 	private Integer roleId;
 	/** 关联的一个角色的名称 */
 	private String roleName;
 	/** 关联的一个显示角色的排序 */
 	private Integer roleShowNumber;
 	/** 关联的全部角色 */
 	private List<Role> roles;
 	/** 跨公司查看的公司id */
 	private List<Integer> companyIds;
 	/** 所属部门管理的危险源id */
 	private Integer dangeroussourceId;
 	/** 巡检任务id */
 	private Integer inspectId;
 	/** 整改任务id */
 	private Integer rectifyId;
 	/** 权限id */
 	private Integer functionId;


 	//前端传来的参数
 	/** 搜索关键词 */
 	private String key;
 	/** 关联的全部角色id */
 	private List<Integer> roleIds;

 	//前端需要的参数
 	/** 跨公司查看的开关 */
 	private Integer flag;


	/**
     * ID
     * @param userId
     */
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    /**
     * ID
     * @return
     */
	public Integer getUserId()
    {
        return userId;
    }


	/**
     * 用户名
     * @param userName
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * 用户名
     * @return
     */
	public String getUserName()
    {
        return userName;
    }


	/**
     * 密码
     * @param userPassword
     */
    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }

    /**
     * 密码
     * @return
     */
	public String getUserPassword()
    {
        return userPassword;
    }


	/**
     * 真实姓名
     * @param userRealname
     */
    public void setUserRealname(String userRealname)
    {
        this.userRealname = userRealname;
    }

    /**
     * 真实姓名
     * @return
     */
	public String getUserRealname()
    {
        return userRealname;
    }


	/**
     * 年龄
     * @param userAge
     */
    public void setUserAge(Integer userAge)
    {
        this.userAge = userAge;
    }

    /**
     * 年龄
     * @return
     */
	public Integer getUserAge()
    {
        return userAge;
    }

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	/**
     * 电话
     * @param userPhoneNumber
     */
    public void setUserPhoneNumber(String userPhoneNumber)
    {
        this.userPhoneNumber = userPhoneNumber;
    }

    /**
     * 电话
     * @return
     */
	public String getUserPhoneNumber()
    {
        return userPhoneNumber;
    }


	/**
     * 职务
     * @param userPosition
     */
    public void setUserPosition(String userPosition)
    {
        this.userPosition = userPosition;
    }

    /**
     * 职务
     * @return
     */
	public String getUserPosition()
    {
        return userPosition;
    }


	/**
     * 用户头像图片的访问路径
     * @param userPictureUrl
     */
    public void setUserPictureUrl(String userPictureUrl)
    {
        this.userPictureUrl = userPictureUrl;
    }

    /**
     * 用户头像图片的访问路径
     * @return
     */
	public String getUserPictureUrl()
    {
        return userPictureUrl;
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

    public User2() {

	}

	public User2(Integer userId, String userName, String userPassword, String userRealname, Integer userAge,
                 String userPhoneNumber, String userPosition, String userPictureUrl, Date createTime, String createTimeBegin,
                 String createTimeEnd, String status, Integer companyId, String userGender) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRealname = userRealname;
		this.userAge = userAge;
		this.userPhoneNumber = userPhoneNumber;
		this.userPosition = userPosition;
		this.userPictureUrl = userPictureUrl;
		this.createTime = createTime;
		this.createTimeBegin = createTimeBegin;
		this.createTimeEnd = createTimeEnd;
		this.status = status;
		this.companyId = companyId;
		this.userGender=userGender;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userRealname=" + userRealname + ", userAge=" + userAge + ", userPhoneNumber=" + userPhoneNumber
				+ ", userPosition=" + userPosition + ", userPictureUrl=" + userPictureUrl + ", createTime=" + createTime
				+ ", createTimeBegin=" + createTimeBegin + ", createTimeEnd=" + createTimeEnd + ", status=" + status
				+ ", companyId=" + companyId + ", userGender=" + userGender + "]";
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<Integer> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public List<Integer> getCompanyIds() {
		return companyIds;
	}

	public void setCompanyIds(List<Integer> companyIds) {
		this.companyIds = companyIds;
	}

	public Integer getDangeroussourceId() {
		return dangeroussourceId;
	}

	public void setDangeroussourceId(Integer dangeroussourceId) {
		this.dangeroussourceId = dangeroussourceId;
	}

	public Integer getInspectId() {
		return inspectId;
	}

	public void setInspectId(Integer inspectId) {
		this.inspectId = inspectId;
	}

	public Integer getRectifyId() {
		return rectifyId;
	}

	public void setRectifyId(Integer rectifyId) {
		this.rectifyId = rectifyId;
	}

	public Integer getFunctionId() {
		return functionId;
	}

	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}

	public Integer getRoleShowNumber() {
		return roleShowNumber;
	}

	public void setRoleShowNumber(Integer roleShowNumber) {
		this.roleShowNumber = roleShowNumber;
	}
    
}