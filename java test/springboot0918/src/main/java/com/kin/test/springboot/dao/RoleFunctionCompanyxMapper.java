package com.kin.test.springboot.dao;

import com.kin.test.springboot.model.RoleFunctionCompanyx;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleFunctionCompanyxMapper")
public interface RoleFunctionCompanyxMapper {
    /**
     * 根据指定的员工id和权限id查询当前员工的跨公司的标记记录
     * @param roleFunctionCompanyx
     * @return
     */
    List<RoleFunctionCompanyx> getRoleFunctionCompanyxByUserIdAndFunctionId(RoleFunctionCompanyx roleFunctionCompanyx);
}
