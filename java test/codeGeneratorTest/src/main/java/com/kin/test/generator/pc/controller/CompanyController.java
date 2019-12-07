package com.kin.test.generator.pc.controller;


import com.kin.test.generator.pc.entity.Company;
import com.kin.test.generator.pc.service.impl.CompanyServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.kin.test.generator.base.BaseController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 公司表 前端控制器
 * </p>
 *
 * @author Kin
 * @since 2019-10-09
 */
@RestController
@RequestMapping("/pc/company")
public class CompanyController extends BaseController {

    @Resource
    private CompanyServiceImpl companyService;
    @GetMapping("/get")
    public Company getCompanyById(@NotNull Integer id){
        return companyService.getCompanyById(id);
    }
}
