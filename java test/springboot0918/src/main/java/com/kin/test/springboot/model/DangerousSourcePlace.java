package com.kin.test.springboot.model;

import java.util.Date;
import java.util.List;

/**
 * @program: springboot0918
 * @description: 危险源地点
 * @author: 黄永健
 * @create: 2019-09-27 14:10
 **/
public class DangerousSourcePlace {
    /**
     *
     */
    private static final long serialVersionUID = 5354704071892117244L;
    /** ID */
    private Integer dangeroussourcePlaceId;
    /** 危险源地点名称 */
    private String dangeroussourcePlaceName;
    /** 场所 */
    private String dangeroussourcePlacePlace;
    /** 技术控制 */
    private String dangeroussourcePlaceTechnologyControl;
    /** 人行为控制 */
    private String dangeroussourcePlaceArtificialControl;
    /** 管理控制 */
    private String dangeroussourcePlaceManagementControl;
    /** 备注 */
    private String dangeroussourcePlaceContent;
    /** 出勤日巡检频率 */
    private Double dangeroussourcePlaceAttendanceWorkdayFrequency;
    /** 非出勤日巡检频率 */
    private Double dangeroussourcePlaceAttendanceRestdayFrequency;
    /** 创建时间 */
    private Date createTime;
    /** 创建时间 开始时间 */
    private String createTimeBegin;
    /** 创建时间 结束时间 */
    private String createTimeEnd;
    /** 状态值 */
    private String status;
    /** 巡检部门ID(department表) */
    private Integer departmentIdInspect;
    /** 巡检出勤ID(inspect_attendance表) */
    private Integer inspectAttendanceId;
    /** 公司ID(company表) */
    private Integer companyId;
    /** 风险等级id */
    private Integer riskRankId;

    //关联所用到的字段
    /** 危险源地点的负责部门的负责人的真实姓名 */
    private String userRealname;
    /** 危险源地点的负责部门名称 */
    private String departmentName;
    /** 风险等级名称 */
    private String riskRankName;
    /** 公司名称 */
    private String companyName;
    /** 事故类型名称 */
    private List<String> troubleTypeNames;
    /** 能量源名称 */
    private List<String> energySourceNames;
    /** 当前危险源地点下的全部危险源 */
    //private List<Dangeroussource> dangeroussources;
    /** 点检次数(同一危险源地点下的巡检历史记录的个数) */
    private Integer inspectSummarySum;
    /** 未按期巡检次数(同一危险源地点下的[未按期]巡检记录的个数) */
    private Integer noInspectSummarySum;
    /** 发现隐患数量 */
    private Integer neeRectifySummarySum;
    /** 未解决的隐患数量 */
    private Integer notRectifySummarySum;
    /** 点检人员(同一危险源地点下的巡检人真实姓名) */
    private List<String> inspectUserRealnames;
    /** 解决的隐患数量 */
    private Integer rectifedSummarySum;
    /** 危险源地点下的全部的应急物资 */
    //private List<Supplies> suppliess;
    /** 危险源地点 下的全部的事故类型 */
    //private List<TroubleType> troubleTypes;
    /** 危险源地点下的全部能量源 */
    //private List<EnergySource> energySources;
    /** 跨公司查看的公司id */
    private List<Integer> companyIds;


    //接收前段传来的请求参数
    /** 事故类型ids */
    private List<Integer> troubleTypeIds;
    /** 能量源ids */
    private List<Integer> energySourceIds;
    /** 应急预案 */
    //private List<ContingencyPlan> contingencyPlans;
    /** 新增的应急预案ids */
    private List<Integer> contingencyPlanIds;
    /** 删除的应急预案ids */
    private List<Integer> deleteContingencyPlanIds;
    /** 新增的应急预案(用于[修改]时与已经的文件进行区分) */
    private List<String> newContingencyPlans;
    /** 统计的巡检任务的时间段 */
    private String inspectDatetimeDuring;


    //前端需要的参数
    /** 本公司的标志 */
    private Integer flag;
    /** 是否在危险源的部门管理范围的标志 */
    private Integer departmentFlag;
    /** 危险源地点下的分页查询的危险源记录 */
    //private Page<Dangeroussource> page;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getDangeroussourcePlaceId() {
        return dangeroussourcePlaceId;
    }

    public void setDangeroussourcePlaceId(Integer dangeroussourcePlaceId) {
        this.dangeroussourcePlaceId = dangeroussourcePlaceId;
    }

    public String getDangeroussourcePlaceName() {
        return dangeroussourcePlaceName;
    }

    public void setDangeroussourcePlaceName(String dangeroussourcePlaceName) {
        this.dangeroussourcePlaceName = dangeroussourcePlaceName;
    }

    public String getDangeroussourcePlacePlace() {
        return dangeroussourcePlacePlace;
    }

    public void setDangeroussourcePlacePlace(String dangeroussourcePlacePlace) {
        this.dangeroussourcePlacePlace = dangeroussourcePlacePlace;
    }

    public String getDangeroussourcePlaceTechnologyControl() {
        return dangeroussourcePlaceTechnologyControl;
    }

    public void setDangeroussourcePlaceTechnologyControl(String dangeroussourcePlaceTechnologyControl) {
        this.dangeroussourcePlaceTechnologyControl = dangeroussourcePlaceTechnologyControl;
    }

    public String getDangeroussourcePlaceArtificialControl() {
        return dangeroussourcePlaceArtificialControl;
    }

    public void setDangeroussourcePlaceArtificialControl(String dangeroussourcePlaceArtificialControl) {
        this.dangeroussourcePlaceArtificialControl = dangeroussourcePlaceArtificialControl;
    }

    public String getDangeroussourcePlaceManagementControl() {
        return dangeroussourcePlaceManagementControl;
    }

    public void setDangeroussourcePlaceManagementControl(String dangeroussourcePlaceManagementControl) {
        this.dangeroussourcePlaceManagementControl = dangeroussourcePlaceManagementControl;
    }

    public String getDangeroussourcePlaceContent() {
        return dangeroussourcePlaceContent;
    }

    public void setDangeroussourcePlaceContent(String dangeroussourcePlaceContent) {
        this.dangeroussourcePlaceContent = dangeroussourcePlaceContent;
    }

    public Double getDangeroussourcePlaceAttendanceWorkdayFrequency() {
        return dangeroussourcePlaceAttendanceWorkdayFrequency;
    }

    public void setDangeroussourcePlaceAttendanceWorkdayFrequency(Double dangeroussourcePlaceAttendanceWorkdayFrequency) {
        this.dangeroussourcePlaceAttendanceWorkdayFrequency = dangeroussourcePlaceAttendanceWorkdayFrequency;
    }

    public Double getDangeroussourcePlaceAttendanceRestdayFrequency() {
        return dangeroussourcePlaceAttendanceRestdayFrequency;
    }

    public void setDangeroussourcePlaceAttendanceRestdayFrequency(Double dangeroussourcePlaceAttendanceRestdayFrequency) {
        this.dangeroussourcePlaceAttendanceRestdayFrequency = dangeroussourcePlaceAttendanceRestdayFrequency;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeBegin() {
        return createTimeBegin;
    }

    public void setCreateTimeBegin(String createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }

    public String getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDepartmentIdInspect() {
        return departmentIdInspect;
    }

    public void setDepartmentIdInspect(Integer departmentIdInspect) {
        this.departmentIdInspect = departmentIdInspect;
    }

    public Integer getInspectAttendanceId() {
        return inspectAttendanceId;
    }

    public void setInspectAttendanceId(Integer inspectAttendanceId) {
        this.inspectAttendanceId = inspectAttendanceId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getRiskRankId() {
        return riskRankId;
    }

    public void setRiskRankId(Integer riskRankId) {
        this.riskRankId = riskRankId;
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRiskRankName() {
        return riskRankName;
    }

    public void setRiskRankName(String riskRankName) {
        this.riskRankName = riskRankName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<String> getTroubleTypeNames() {
        return troubleTypeNames;
    }

    public void setTroubleTypeNames(List<String> troubleTypeNames) {
        this.troubleTypeNames = troubleTypeNames;
    }

    public List<String> getEnergySourceNames() {
        return energySourceNames;
    }

    public void setEnergySourceNames(List<String> energySourceNames) {
        this.energySourceNames = energySourceNames;
    }

    public Integer getInspectSummarySum() {
        return inspectSummarySum;
    }

    public void setInspectSummarySum(Integer inspectSummarySum) {
        this.inspectSummarySum = inspectSummarySum;
    }

    public Integer getNoInspectSummarySum() {
        return noInspectSummarySum;
    }

    public void setNoInspectSummarySum(Integer noInspectSummarySum) {
        this.noInspectSummarySum = noInspectSummarySum;
    }

    public Integer getNeeRectifySummarySum() {
        return neeRectifySummarySum;
    }

    public void setNeeRectifySummarySum(Integer neeRectifySummarySum) {
        this.neeRectifySummarySum = neeRectifySummarySum;
    }

    public Integer getNotRectifySummarySum() {
        return notRectifySummarySum;
    }

    public void setNotRectifySummarySum(Integer notRectifySummarySum) {
        this.notRectifySummarySum = notRectifySummarySum;
    }

    public List<String> getInspectUserRealnames() {
        return inspectUserRealnames;
    }

    public void setInspectUserRealnames(List<String> inspectUserRealnames) {
        this.inspectUserRealnames = inspectUserRealnames;
    }

    public Integer getRectifedSummarySum() {
        return rectifedSummarySum;
    }

    public void setRectifedSummarySum(Integer rectifedSummarySum) {
        this.rectifedSummarySum = rectifedSummarySum;
    }

    public List<Integer> getCompanyIds() {
        return companyIds;
    }

    public void setCompanyIds(List<Integer> companyIds) {
        this.companyIds = companyIds;
    }

    public List<Integer> getTroubleTypeIds() {
        return troubleTypeIds;
    }

    public void setTroubleTypeIds(List<Integer> troubleTypeIds) {
        this.troubleTypeIds = troubleTypeIds;
    }

    public List<Integer> getEnergySourceIds() {
        return energySourceIds;
    }

    public void setEnergySourceIds(List<Integer> energySourceIds) {
        this.energySourceIds = energySourceIds;
    }

    public List<Integer> getContingencyPlanIds() {
        return contingencyPlanIds;
    }

    public void setContingencyPlanIds(List<Integer> contingencyPlanIds) {
        this.contingencyPlanIds = contingencyPlanIds;
    }

    public List<Integer> getDeleteContingencyPlanIds() {
        return deleteContingencyPlanIds;
    }

    public void setDeleteContingencyPlanIds(List<Integer> deleteContingencyPlanIds) {
        this.deleteContingencyPlanIds = deleteContingencyPlanIds;
    }

    public List<String> getNewContingencyPlans() {
        return newContingencyPlans;
    }

    public void setNewContingencyPlans(List<String> newContingencyPlans) {
        this.newContingencyPlans = newContingencyPlans;
    }

    public String getInspectDatetimeDuring() {
        return inspectDatetimeDuring;
    }

    public void setInspectDatetimeDuring(String inspectDatetimeDuring) {
        this.inspectDatetimeDuring = inspectDatetimeDuring;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getDepartmentFlag() {
        return departmentFlag;
    }

    public void setDepartmentFlag(Integer departmentFlag) {
        this.departmentFlag = departmentFlag;
    }
}
