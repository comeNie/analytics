package com.orienttech.statics.service.report.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognos.developer.schemas.bibus._3.ReportService_PortType;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.orienttech.statics.commons.dynamicquery.DynamicQuery;
import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.dao.AutoExecPlanDao;
import com.orienttech.statics.dao.AutoExecRecordDao;
import com.orienttech.statics.dao.entity.AutoExecPlan;
import com.orienttech.statics.dao.entity.AutoExecRecord;
import com.orienttech.statics.dao.entity.AutoExecRecordPk;
import com.orienttech.statics.service.cognos.ReportRunnerHelper;
import com.orienttech.statics.service.cognos.ReportRunnerService;
import com.orienttech.statics.service.cognos.common.ServerInfoHelper;
import com.orienttech.statics.service.cognos.entity.ReportParam;
import com.orienttech.statics.service.cognos.exception.CognosBaseException;
import com.orienttech.statics.service.model.report.AutoExecPlanBo;
import com.orienttech.statics.service.model.report.HistoryReportBo;
import com.orienttech.statics.service.report.HistoryReportService;
@Service
public class HistoryReportServiceImpl implements HistoryReportService {
	private Logger logger=LoggerFactory.getLogger(HistoryReportServiceImpl.class);
	
	@Autowired
	private DynamicQuery dynamicQuery;
	@Autowired
	private AutoExecRecordDao autoExecRecordDao;
	@Autowired
	private AutoExecPlanDao autoExecPlanDao;
	@Autowired
	private ReportRunnerService reportRunnerService;
	@Override
	public List<HrTypeCode> findAllHistRptListByCode() {
		// TODO Auto-generated method stub
		StringBuffer strBuffer=new StringBuffer();
		strBuffer.append("select distinct report_code, report_name from auto_exec_record order by report_code");
		List<Object[]> list=dynamicQuery.nativeQuery(strBuffer.toString());
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		return Lists.transform(list, new Function<Object[], HrTypeCode>() {
			@Override
			public HrTypeCode apply(Object[] objs) {
				return new HrTypeCode(CommonHelper.toStr(objs[0]), CommonHelper.toStr(objs[1]));
			}
			
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<Object[]> findHistoryReportList(int pageNumber,int pageSize,String reportNameType,
			Date stateDate, Date endDate, String orgId, String fOrgId) {
		StringBuffer strBuffer=new StringBuffer();
		int paramsIndex=1;
		List<Object> params=Lists.newArrayList();
		if(StringUtils.isNoneBlank(orgId)&&orgId.equalsIgnoreCase("all_detail_total")){
			strBuffer.append("select '所有机构汇总' DESCRIPTION,a.report_name,a.report_date,a.filepathname,a.report_type,a.build_date,a.org_id,a.report_code from auto_exec_record a where 1=1 and a.org_id is null ");
			if(StringUtils.isNoneBlank(reportNameType)){
				strBuffer.append(" and report_code =?").append(paramsIndex++);
				params.add(reportNameType);
			}
			if(stateDate!=null){
				strBuffer.append(" and report_date >=?").append(paramsIndex++);
				params.add(stateDate);
			}
			if(endDate!=null){
				strBuffer.append(" and report_date <=?").append(paramsIndex++);
				params.add(endDate);
			}
		}else if((!StringUtils.isNoneBlank(orgId))&&fOrgId.substring(0, 1).equalsIgnoreCase("1")){
			strBuffer.append("select DESCRIPTION,report_name,report_date,filepathname,report_type,build_date from ("
					+ "select b.DESCRIPTION,a.report_name,a.report_date,a.filepathname,a.report_type,a.build_date,a.org_id,a.report_code from auto_exec_record a,(select distinct orgid,DESCRIPTION from T_STA_DIM_ORG) b where 1=1 and b.orgid=a.org_id union select '所有机构汇总' DESCRIPTION,a.report_name,a.report_date,a.filepathname,a.report_type,a.build_date,a.org_id,a.report_code from auto_exec_record a where 1=1 and a.org_id is null "
					+ ") "
					+ " where 1=1 ");
			if(StringUtils.isNoneBlank(reportNameType)){
				strBuffer.append(" and report_code =?").append(paramsIndex++);
				params.add(reportNameType);
			}
			if(stateDate!=null){
				strBuffer.append(" and report_date >=?").append(paramsIndex++);
				params.add(stateDate);
			}
			if(endDate!=null){
				strBuffer.append(" and report_date <=?").append(paramsIndex++);
				params.add(endDate);
			}
			
		}else{
		strBuffer.append("select DESCRIPTION,report_name,report_date,filepathname,report_type,build_date from ("
				+ "select b.DESCRIPTION,a.report_name,a.report_date,a.filepathname,a.report_type,a.build_date,a.org_id,a.report_code from auto_exec_record a,(select distinct orgid,DESCRIPTION from T_STA_DIM_ORG) b where 1=1 and b.orgid=a.org_id "
				+ ") "
				+ " where 1=1 ");
		if(StringUtils.isNoneBlank(reportNameType)){
			strBuffer.append(" and report_code =?").append(paramsIndex++);
			params.add(reportNameType);
		}
		if(stateDate!=null){
			strBuffer.append(" and report_date >=?").append(paramsIndex++);
			params.add(stateDate);
		}
		if(endDate!=null){
			strBuffer.append(" and report_date <=?").append(paramsIndex++);
			params.add(endDate);
		}
		if(StringUtils.isNoneBlank(orgId)){
			strBuffer.append(" and org_id =?").append(paramsIndex++);
			params.add(orgId);
		} else {
			if (!fOrgId.substring(0, 1).equalsIgnoreCase("1")) {
				strBuffer.append(" and org_id in(select orgid from t_sta_dim_org tsdo where tsdo.org_attr='1' and tsdo.orgid1=?").append(paramsIndex++).append(")");
				params.add(fOrgId);
			}
		}
		}
		strBuffer.append(" order by BUILD_DATE DESC");
		return dynamicQuery.nativeQuery(new PageRequest(pageNumber, pageSize), strBuffer.toString(),params.toArray());
	}

	@Override
	@Transactional
	public void saveHistoryReport(HistoryReportBo reportBo) {
		//autoExecRecordDao.save(reportBo);

	}

	@Override
	@Transactional
	public void autoExecReport() {
		String subPath = CommonHelper.date2Str(CommonHelper.getNow(), "yyyy/MMdd");
		//准备执行数据
		List<AutoExecPlan> planList = autoExecPlanDao.findListByState();
		
		List<AutoExecPlanBo> targetList = Lists.newArrayList();
		
		if(CollectionUtils.isEmpty(planList)){
			return ;
		}
		String fileName=null;
		for (AutoExecPlan aep : planList) {
			fileName = aep.getReportCode() + "_" + (StringUtils.isEmpty(aep.getOrgCd()) ? "all" : aep.getOrgCd()) + "." + aep.getReportType().toLowerCase();
			AutoExecPlanBo autoExecPlanBo = new AutoExecPlanBo();
			autoExecPlanBo.setAutoExecPlan(aep);
			//autoExecPlanBo.setFile(new File(ServerInfoHelper.getTempReportPath() + File.separator + subPath + File.separator + fileName));
			autoExecPlanBo.setFileName(fileName);
			targetList.add(autoExecPlanBo);
		}
		//登录到cognos
		int index = targetList.size();
		int count = 0;
		try {
			while(index > 0) {
				ReportService_PortType runReport = reportRunnerService.loginCognos();
				for (AutoExecPlanBo aepb : targetList) {
					if (!aepb.isSuccess()) {
						if (count > 0) {
							logger.info("重新尝试执行[{}]机构报表", aepb.getAutoExecPlan().getOrgCd());
						}else {
							logger.info("执行[{}]机构报表", aepb.getAutoExecPlan().getOrgCd() == null ? "全部" : aepb.getAutoExecPlan().getOrgCd());
						}
						List<ReportParam> params = null;
						if (StringUtils.isNotEmpty(aepb.getAutoExecPlan().getOrgCd())) {
							params = Arrays.asList(new ReportParam("Porgcd", aepb.getAutoExecPlan().getOrgCd()));
						}
						String path = ServerInfoHelper.getReportPath() + File.separator + subPath;
						ServerInfoHelper.forceMkdir(path);
						boolean isSuccess = reportRunnerService.runReportBatch(
								aepb.getAutoExecPlan().getSearchPath(), 
								path, aepb.getFileName(), 
								params, runReport,0L);
						
						if(isSuccess){
							aepb.setSuccess(isSuccess);
							index--;
						}
					}
				}
				logger.info("执行[{}]个报表失败", index);
				if (index <= 0) {
					break;
				}
				if (count > 10) {
					throw new CognosBaseException("SOAP exception!");
				}
				Thread.sleep(3000);
				count++;
			}
		} catch (CognosBaseException e) {
			logger.error("文件找不到",e);
		} catch (Exception e) {
			logger.error("报表生成失败",e);
		}
		//读取excel
		
		//全部写成功后保存到数据库
		AutoExecRecord aeRecord=null;
		AutoExecRecordPk aeRecordPk=null;
		AutoExecPlan aep = null;
		
		for (AutoExecPlanBo aepb : targetList) {
			aeRecord = new AutoExecRecord();
			aeRecordPk = new AutoExecRecordPk();
			aep = aepb.getAutoExecPlan();
			aeRecordPk.setPlanNo(aepb.getAutoExecPlan().getPlanNo());
			fileName = subPath + File.separator + aepb.getFileName();
			aeRecordPk.setFilePathName(fileName);
			aeRecord.setAutoExecRecordPk(aeRecordPk);
			aeRecord.setReportCode(aep.getReportCode());
			aeRecord.setReportName(aep.getReportName());
			aeRecord.setReportDate(new Date());
			aeRecord.setBuildDate(new Date());
			aeRecord.setReportType(aep.getReportType());
			aeRecord.setOrgId(aep.getOrgCd());
			autoExecRecordDao.save(aeRecord);
		}
		
	}

}
