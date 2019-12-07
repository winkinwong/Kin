package com.kin.test.springboot.controller;

import com.kin.test.springboot.global.Result;
import com.kin.test.springboot.global.annotation.MyLog;
import com.kin.test.springboot.model.DangerousSourcePlace;
import com.kin.test.springboot.service.DangerousSourcePlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: springboot0918
 * @description: 危险源地点控制器
 * @author: 黄永健
 * @create: 2019-09-27 15:37
 **/
@Controller
@RequestMapping("/api")
public class DangerousSourcePlaceController {
    @Resource(name = "dangerousSourcePlaceService")
    private DangerousSourcePlaceService dangerousSourcePlaceService;

    @RequestMapping("/dangerousSourcePlace")
    @ResponseBody
    @MyLog(value = "查询所有危险源地点")
    public Result test(){
        DangerousSourcePlace dangerousSourcePlace = new DangerousSourcePlace();


        return dangerousSourcePlaceService.getAllDangerousSourcePlaceByCompany(dangerousSourcePlace);
    }

    @RequestMapping("/exportExcel")
    @ResponseBody
    public void exportExcel(HttpServletResponse res) throws Exception {
        dangerousSourcePlaceService.exportExcel(res);
    }
}
