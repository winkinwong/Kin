package com.kin.test.springboot.service.imp;

import com.kin.test.springboot.dao.DangerousSourcePlaceMapper;
import com.kin.test.springboot.dao.InspectDao;
import com.kin.test.springboot.dao.InspectHistoryDao;
import com.kin.test.springboot.dao.RoleFunctionCompanyxMapper;
import com.kin.test.springboot.global.Result;
import com.kin.test.springboot.global.util.*;
import com.kin.test.springboot.model.*;
import com.kin.test.springboot.service.DangerousSourcePlaceService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @program: springboot0918
 * @description: 危险源地点实现类
 * @author: 黄永健
 * @create: 2019-09-27 14:28
 **/
@Service("dangerousSourcePlaceService")
public class DangerousSourcePlaceImp implements DangerousSourcePlaceService {
    @Resource(name="dangerousSourcePlaceMapper")
    private DangerousSourcePlaceMapper dangerousSourcePlaceMapper;
    @Resource(name = "roleFunctionCompanyxMapper")
    private RoleFunctionCompanyxMapper roleFunctionCompanyxMapper;
    @Resource(name="inspectDao")
    private InspectDao inspectDao;
    @Resource(name="inspectHistoryDao")
    private InspectHistoryDao inspectHistoryDao;

    @Override
    public Result getAllDangerousSourcePlaceByCompany(DangerousSourcePlace dangerousSourcePlace) {
        dangerousSourcePlace.setCompanyId(4);
        //需要查看本公司所有危险源地点信息，为什么要传递巡检部门id？这样查询出来的结果只有对应的巡检部门的危险源地点信息！
        //答：这里是为了实现筛选部门之后查询的结果的。如果默认值则部门id为空
        dangerousSourcePlace.setDepartmentIdInspect(null);
        //<<<<<<<<<<<<<<<跨公司查看的权限控制
        List<Integer> companyIds=new ArrayList<Integer>();
        //非超管账号,只能查看权限范围内的公司
        //1)当前的权限固定为57
        Integer functionId=57;
        RoleFunctionCompanyx rfc=new RoleFunctionCompanyx();
        rfc.setFunctionId(functionId);
        rfc.setUserId(13);
        List<RoleFunctionCompanyx> rfcs=roleFunctionCompanyxMapper.getRoleFunctionCompanyxByUserIdAndFunctionId(rfc);
        if(rfcs!=null&&rfcs.size()>0) {
            for (RoleFunctionCompanyx rfc2 : rfcs) {
                companyIds.add(rfc2.getCompanyId());
            }
        }
        //这里有问题，为什么至少有一个公司？ 不用也是能正常查询出本公司信息。
        //要将账号所属公司填入companyIds:这样至少有一个公司id
        companyIds.add(4);
        dangerousSourcePlace.setCompanyIds(companyIds);
        //这里只是根据用户所在部门，查询出所有其部门负责的危险源地点信息
        List<DangerousSourcePlace> dps=dangerousSourcePlaceMapper.getAllDangerousSourcePlaceByCompany(dangerousSourcePlace);

        //<<<<<<<<<<<<<<<跨公司查看的权限控制
        return Result.success(dps);
    }

    @Override
    public void exportExcel(HttpServletResponse res) throws Exception {
        DangerousSourcePlace dangerousSourcePlace = new DangerousSourcePlace();
        dangerousSourcePlace.setCompanyId(2);
        //需要查看本公司所有危险源地点信息，为什么要传递巡检部门id？这样查询出来的结果只有对应的巡检部门的危险源地点信息！
        dangerousSourcePlace.setDepartmentIdInspect(null);//应该只有两条记录出现
        //<<<<<<<<<<<<<<<跨公司查看的权限控制
        List<Integer> companyIds = new ArrayList<Integer>();
        //非超管账号,只能查看权限范围内的公司
        //1)当前的权限固定为57
        Integer functionId = 57;
        RoleFunctionCompanyx rfc = new RoleFunctionCompanyx();
        rfc.setFunctionId(functionId);
        rfc.setUserId(2);
        List<RoleFunctionCompanyx> rfcs = roleFunctionCompanyxMapper.getRoleFunctionCompanyxByUserIdAndFunctionId(rfc);
        if (rfcs != null && rfcs.size() > 0) {
            for (RoleFunctionCompanyx rfc2 : rfcs) {
                companyIds.add(rfc2.getCompanyId());
            }
        }
        //这里有问题，为什么至少有一个公司？ 不用也是能正常查询出本公司信息。
        //答：由于如果筛选条件没有选择任何公司，则companyid为空，此时需要将companyid1作为本公司的id传入companyids集合中遍历，实现查询所有本公司记录以及跨公司的记录。
        //要将账号所属公司填入companyIds:这样至少有一个公司id
        companyIds.add(4);
        dangerousSourcePlace.setCompanyIds(companyIds);
        //这里只是根据用户所在部门，查询出所有其部门负责的危险源地点信息
        List<DangerousSourcePlace> dps = dangerousSourcePlaceMapper.getAllDangerousSourcePlaceByCompany(dangerousSourcePlace);

        //<<<<<<<<<<<<<<<跨公司查看的权限控制

        //1)查询相应的巡检历史记录
        for (DangerousSourcePlace dp : dps) {
            Inspect inspect = new Inspect();
            inspect.setDangeroussourcePlaceId(dp.getDangeroussourcePlaceId());
            //由于为了简化测试，这里注释筛选时间功能
            // inspect.setInspectDatetimeBegin(StringUtil.objToStr(paramsMap.get("inspectDatetimeBegin")));
            //inspect.setInspectDatetimeEnd(StringUtil.objToStr(paramsMap.get("inspectDatetimeEnd")));
            //固定是1:表示日常巡检
            inspect.setInspectTypeId(1);

            InspectHistory inspectHistory = new InspectHistory();
            inspectHistory.setDangeroussourcePlaceId(dp.getDangeroussourcePlaceId());
            //由于为了简化测试，这里注释筛选时间功能
            //   inspectHistory.setInspectDatetimeBegin(StringUtil.objToStr(paramsMap.get("inspectDatetimeBegin")));
            // inspectHistory.setInspectDatetimeEnd(StringUtil.objToStr(paramsMap.get("inspectDatetimeEnd")));
            //固定是1:表示日常巡检
            inspectHistory.setInspectTypeId(1);


            //点检次数
            Integer inspectSummarySum = inspectDao.selectInspectSummarySum(inspect);
            //未按期点检次数
            Integer noInspectSummarySum = inspectHistoryDao.selectNoInspectSummarySum(inspectHistory);
            //发现隐患数量统计
            Integer neeRectifySummarySum = inspectHistoryDao.selectNeedRectifySummarySum(inspectHistory);
            //解决的隐患数量
            Integer rectifedSummarySum = inspectDao.selectRectifedSummarySum(inspect);
            //巡检人集合统计
            List<String> inspectUserRealnames = new ArrayList<String>();
            List<User2> users = inspectDao.selectInspectUsers(inspect);
            for (User2 user : users) {
                inspectUserRealnames.add(user.getUserRealname());
            }

            //点检次数统计ok
            dp.setInspectSummarySum(inspectSummarySum);
            //未按期巡检次数统计ok
            dp.setNoInspectSummarySum(noInspectSummarySum);
            //发现隐患数量统计
            dp.setNeeRectifySummarySum(neeRectifySummarySum);
            //未解决的隐患数量
            dp.setNotRectifySummarySum(neeRectifySummarySum-rectifedSummarySum);
            //解决的隐患数量
            dp.setRectifedSummarySum(rectifedSummarySum);
            //巡检人集合统计
            dp.setInspectUserRealnames(inspectUserRealnames);

        }
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\\
            //构建Excel文件的数据
            //1)表头标题
            List<String> headerParams=new ArrayList<String>();
            headerParams.add("日常点检情况汇总");

            //2)表体的元数据项
            List<Map<String, String>> bodyHeadersMap=new ArrayList<Map<String,String>>();
            Map<String, String> m1=new HashMap<String, String>();
            m1.put("number", "序号");
            bodyHeadersMap.add(m1);
            Map<String, String> m2=new HashMap<String, String>();
            m2.put("dangeroussourcePlaceName", "危险源地点名称");
            bodyHeadersMap.add(m2);
            Map<String, String> m3=new HashMap<String, String>();
            m3.put("departmentName", "所属部门");
            bodyHeadersMap.add(m3);
            Map<String, String> m4=new HashMap<String, String>();
            m4.put("inspectSummarySum", "点检次数");
            bodyHeadersMap.add(m4);
            Map<String, String> m5=new HashMap<String, String>();
            m5.put("noInspectSummarySum", "未按期点检次数");
            bodyHeadersMap.add(m5);
            Map<String, String> m6=new HashMap<String, String>();
            m6.put("neeRectifySummarySum", "发现隐患数量");
            bodyHeadersMap.add(m6);
            Map<String, String> m7=new HashMap<String, String>();
            m7.put("rectifedSummarySum", "整改隐患数量");
            bodyHeadersMap.add(m7);
            Map<String, String> m8=new HashMap<String, String>();
            m8.put("notRectifySummarySum", "待整改隐患数量");
            bodyHeadersMap.add(m8);
            Map<String, String> m9=new HashMap<String, String>();
            m9.put("inspectUserRealnames", "点检人员");
            bodyHeadersMap.add(m9);
            Map<String, String> m10=new HashMap<String, String>();
            m10.put("content", "备注");
            bodyHeadersMap.add(m10);


            //3)表体的内容数据(excel表格中第三行开始)
            List<Map<String, Object>> bodyRows=new ArrayList<Map<String,Object>>();
            for (int i = 0; i < dps.size(); i++) {
                Map<String, Object> dmap=new HashMap<String, Object>();
                dmap.put("number", i+1);
                dmap.put("dangeroussourcePlaceName", dps.get(i).getDangeroussourcePlaceName());
                dmap.put("departmentName", dps.get(i).getDepartmentName());
                dmap.put("inspectSummarySum", dps.get(i).getInspectSummarySum());
                dmap.put("noInspectSummarySum", dps.get(i).getNoInspectSummarySum());
                dmap.put("neeRectifySummarySum", dps.get(i).getNeeRectifySummarySum());
                dmap.put("rectifedSummarySum", dps.get(i).getRectifedSummarySum());
                dmap.put("notRectifySummarySum", dps.get(i).getNotRectifySummarySum());
                dmap.put("inspectUserRealnames", dps.get(i).getInspectUserRealnames());
                dmap.put("content", "");
                bodyRows.add(dmap);
            }

            //4)表尾总计
            List<String> footerParams=new ArrayList<String>();
            footerParams.add("汇总日期:");
            footerParams.add(DateTimeUtil.dateFormatToString(new Date(), null));

            //1.生成统计报表
            HSSFWorkbook hssfw= DailyInspectSummaryExcelUtil2.getStandardExcel("日常点检情况汇总表", headerParams, bodyHeadersMap, bodyRows, footerParams, null);

            //2.创建若干张统计图片
            //1)封装数据
            List<Map<String, Object>> dataMaps=new ArrayList<Map<String,Object>>();
            for (int i = 0; i < dps.size(); i++) {
                Map<String, Object> dmap=new HashMap<String, Object>();
//					dmap.put("number", i+1);
                dmap.put("dangeroussourcePlaceName", (i+1)+"."+dps.get(i).getDangeroussourcePlaceName());
//					dmap.put("departmentName", dps.get(i).getDepartmentName());
                dmap.put("inspectSummarySum", dps.get(i).getInspectSummarySum());
                dmap.put("noInspectSummarySum", dps.get(i).getNoInspectSummarySum());
                dmap.put("neeRectifySummarySum", dps.get(i).getNeeRectifySummarySum());
                dmap.put("rectifedSummarySum", dps.get(i).getRectifedSummarySum());
                dmap.put("notRectifySummarySum", dps.get(i).getNotRectifySummarySum());
//					dmap.put("inspectUserRealnames", dps.get(i).getInspectUserRealnames());
//					dmap.put("content", "");
                dataMaps.add(dmap);
            }
            //目前固定显示5项参数
            Map<String, Object> groupMap=new HashMap<String, Object>();
//				dmap.put("number", i+1);
//				dmap.put("dangeroussourcePlaceName", dps.get(i).getDangeroussourcePlaceName());
//				dmap.put("departmentName", dps.get(i).getDepartmentName());
            groupMap.put("inspectSummarySum", "点检次数");
            groupMap.put("noInspectSummarySum", "未按期点检次数");
            groupMap.put("neeRectifySummarySum", "发现隐患数量");
            groupMap.put("rectifedSummarySum", "整改隐患数量");
            groupMap.put("notRectifySummarySum", "待整改隐患数量");
            //2)生成随机不重复的图片文件名
            String filePath="/Users/bd_mac/Desktop/patrolInspectSystemFiles/charts/Daily"+UUID.randomUUID().toString().replace("-", "")+".jpg";

          /*  //3)生成多组的条形统计图的图片
            filePath= DailyInspectSummaryCreateChartsUtil.createCharts(dataMaps, groupMap,null,null,null,dps.size()*180,null,filePath);
            System.out.println(filePath);*/

        //3)生成多组的折线统计图的图片
        filePath= DailyInspectSummaryCreateXYLIineChartsUtil.createXYLineCharts(dataMaps, groupMap,null,null,null,dps.size()*180,null,filePath);

        int end=(int)(dps.size()*1.2);
        hssfw= ExcelAppendPictureUtil.excelAppendPictureFile(hssfw, "日常点检情况汇总表", filePath, 1, null, null, null, null, null, (short)1, 1, (short)end, 20);
        //4.将最终完成的统计报表转成Excel文件
//		ExcelOutputOrInputFileUtil.excelOutputFile(hssfw, "D://DailyInspectExcel2.xls", null);


        //导出excel文件
        DailyInspectSummaryExcelUtil.exportExcel("日常点检情况汇总表.xls", hssfw, res);


    }
}
