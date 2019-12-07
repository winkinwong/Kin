package com.kin.test.springboot.model;


/**
 * (角色-权限)-公司标记表(标记中间表)
 * @author fangcheng and ja
 * 2019-06-20 15:55
 */
public class RoleFunctionCompanyx extends BaseEntity
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1849742470169547544L;
	/** ID */
 	private Integer roleFunctionCompanyxId;
	/** 角色-权限ID(role_function表) */
 	private Integer roleFunctionId;
	/** 公司ID(company表) */
 	private Integer companyId;
 	
 	
 	//关联查询用到的属性
 	/** 权限id */
 	private Integer FunctionId;
 	/** 员工id */
 	private Integer userId;
 	
	
	/**
     * ID
     * @param roleFunctionCompanyxId
     */
    public void setRoleFunctionCompanyxId(Integer roleFunctionCompanyxId)
    {
        this.roleFunctionCompanyxId = roleFunctionCompanyxId;
    }
    
    /**
     * ID
     * @return
     */
	public Integer getRoleFunctionCompanyxId()
    {
        return roleFunctionCompanyxId;
    }
    
    
	/**
     * 角色-权限ID(role_function表)
     * @param roleFunctionId
     */
    public void setRoleFunctionId(Integer roleFunctionId)
    {
        this.roleFunctionId = roleFunctionId;
    }
    
    /**
     * 角色-权限ID(role_function表)
     * @return
     */
	public Integer getRoleFunctionId()
    {
        return roleFunctionId;
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

	@Override
	public String toString() {
		return "RoleFunctionCompanyx [roleFunctionCompanyxId=" + roleFunctionCompanyxId + ", roleFunctionId="
				+ roleFunctionId + ", companyId=" + companyId + "]";
	}

	public RoleFunctionCompanyx(Integer roleFunctionCompanyxId, Integer roleFunctionId, Integer companyId) {
		super();
		this.roleFunctionCompanyxId = roleFunctionCompanyxId;
		this.roleFunctionId = roleFunctionId;
		this.companyId = companyId;
	}
    public RoleFunctionCompanyx() {
		
	}

	public Integer getFunctionId() {
		return FunctionId;
	}

	public void setFunctionId(Integer functionId) {
		FunctionId = functionId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
    
}