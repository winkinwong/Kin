package com.kin.test.springboot.model;

/**
 * 用户-角色表(中间表)
 * @author fangcheng and ja
 * 2019-06-06 16:06
 */
public class UserRole extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7690389363683993644L;
	/** ID */
 	private Integer userRoleId;
	/** 用户ID(user表) */
 	private Integer userId;
	/** 角色ID(role表) */
 	private Integer roleId;
 	
 	
 	//关联属性
 	/** 用户 */
 	private User user;
 	
	
	/**
     * ID
     * @param userRoleId
     */
    public void setUserRoleId(Integer userRoleId)
    {
        this.userRoleId = userRoleId;
    }
    
    /**
     * ID
     * @return
     */
	public Integer getUserRoleId()
    {
        return userRoleId;
    }
    
    
	/**
     * 用户ID(user表)
     * @param userId
     */
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }
    
    /**
     * 用户ID(user表)
     * @return
     */
	public Integer getUserId()
    {
        return userId;
    }
    
    
	/**
     * 角色ID(role表)
     * @param roleId
     */
    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }
    
    /**
     * 角色ID(role表)
     * @return
     */
	public Integer getRoleId()
    {
        return roleId;
    }
    
    public UserRole() {
		
	}

	public UserRole(Integer userRoleId, Integer userId, Integer roleId) {
		super();
		this.userRoleId = userRoleId;
		this.userId = userId;
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userId=" + userId + ", roleId=" + roleId + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}