package com.orienttech.statics.service.mobileReportMng;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.orienttech.statics.dao.entity.mobile.MobileBriefReport;

public interface MobileReportMngService {
	/**
	 * 获取列表数据
	 * @param pageNumber
	 * @param pageSize
	 * @param beginTime
	 * @param endTime
	 * @param reportName
	 * @param submitPerson
	 * @return
	 */
	Page<Object[]> queryMobileReport(Integer pageNumber, Integer pageSize,String year,String month,String tenDays,String reportName,String submitPersonName);
	/**
	 * 根据账号查用户名
	 * @param loginName
	 * @return
	 */
	String queryUserNameByLoginName(Object loginName);
	/**
	 * 根据机构Id查机构名
	 * @param orgId
	 * @return
	 */
	String queryOrgNameByOrgId(String orgId);
	/**
	 * 保存信息
	 * @return
	 */
	public void saveMobileReport(MobileBriefReport mobile,MultipartFile myfile);
	
	/**
	 * 更新摘要
	 * @param description
	 * @param mobileId
	 */
	public void modifyMobileDesc(String description,Integer mobileId);
	
	/**
	 * 删除报表
	 * @param id
	 */
	public void delReportById(Integer id);

}

