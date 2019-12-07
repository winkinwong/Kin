package com.kin.test.generator.pc.service.impl;

import com.kin.test.generator.pc.entity.Company;
import com.kin.test.generator.pc.mapper.CompanyMapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kin.test.generator.pc.service.ICompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 公司表 服务实现类
 * </p>
 *
 * @author Kin
 * @since 2019-10-09
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

    @Resource
    private CompanyMapper companyMapper;


    public Company getCompanyById(Integer id){
        return companyMapper.selectById(id);

    }

}
