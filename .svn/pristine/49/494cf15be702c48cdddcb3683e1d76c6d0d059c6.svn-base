package com.orienttech.statics.service.reportResultQuery.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orienttech.statics.commons.dynamicquery.DynamicQuery;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.dao.PassReadDao;
import com.orienttech.statics.dao.UserSsoDao;
import com.orienttech.statics.dao.entity.PassRead;
import com.orienttech.statics.dao.entity.Role;
import com.orienttech.statics.dao.entity.submission.TblTemplateSum;
import com.orienttech.statics.dao.submission.TblReportTemplateDao;
import com.orienttech.statics.dao.submission.TblTemplateSumDao;
import com.orienttech.statics.service.reportResultQuery.ReportResultQueryService;

@Service
public class ReportResultQueryServiceImpl implements ReportResultQueryService {

	@Autowired
	private DynamicQuery dynamicQuery;
	@Autowired
	private TblTemplateSumDao templateSumDao;
	@Autowired
	private UserSsoDao userSsoDao;
	@Autowired
	private PassReadDao passReadDao;
	/**
	 * TODO
	 * 报送结果查询
	 */
	@Override
	public Page<Object[]> queryReportResult(Integer pageNumber, Integer pageSize, String reportName, 
			String reportCycle, String sumTimeBegin, String sumTimeEnd, String sumPeople) {
		
		SessionUser sessionUser = (SessionUser) SecurityUtils.getSubject().getPrincipal();
		String loginName = sessionUser.getLoginName();
		String username = sessionUser.getUserName();
		
		List<String> sumIdList = this.queryReportSumIdByLoginName(loginName);
		
		
		String roleId = userSsoDao.queryRoleBySsoId(loginName);
		
		StringBuffer sql = new StringBuffer("select t1.id,t2.name,t2.cycle,t1.sum_time,t1.sum_people,t1.path,t1.sum_state");
		sql.append(" from tbl_template_sum t1 left join tbl_report_template t2");
		sql.append(" on t1.template_id=t2.id where t1.sum_state='2'");
		
		
		
		int index=1;
		List<Object> params = new ArrayList<Object>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/**
		 * 1、当前登陆用户所在角色下的报送结果；
		 * 2、当前登陆用户为模板创建人时，显示该模板汇总后的报送结果；
		 * @add by wangxy 20151012
		 */
		if (StringUtils.isNotEmpty(roleId)) {//根据用户角色查询对应模板
			String[] roles = roleId.trim().split(",");
			if(roles.length>0){
				for(int i=0; i<roles.length; i++){
					String id = roles[i];
					if(i==0){
						sql.append(" and (");
					}else{
						sql.append(" or ");
					}
					sql.append(" t2.check_role=?").append(index++);
					params.add(id);
					sql.append(" or t2.check_role like ?").append(index++);
					params.add(id+",%");
					sql.append(" or t2.check_role like ?").append(index++);
					params.add("%,"+id+",%");
					sql.append(" or t2.check_role like ?").append(index++);
					params.add("%,"+id);
					
					if(i==roles.length-1){
						sql.append(" or t2.create_people='"+ username +"'");
						
						if(sumIdList != null && sumIdList.size()>0){
							for(String sumId : sumIdList){
								sql.append(" or t1.id='" + sumId + "'");
							}
						}
						
						sql.append(" or t1.sum_people='" + username + "') ");
					}
					
				}
			}
		}
		//报表名称
		if (StringUtils.isNotEmpty(reportName)) {
			sql.append(" and t2.name like ?"+index);
			params.add("%"+reportName+"%");
			index++;
		}
		//报表周期
		if (StringUtils.isNotEmpty(reportCycle)) {
			sql.append(" and t2.cycle=?"+index);
			params.add(reportCycle);
			index++;
		}
		//汇总日期
		if (StringUtils.isNotEmpty(sumTimeBegin)) {
			sql.append(" and trunc(t1.sum_time,'dd')>=?"+index);
			try {
				params.add(sdf.parse(sumTimeBegin));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			index++;
		}
		if (StringUtils.isNotEmpty(sumTimeEnd)) {
			sql.append(" and trunc(t1.sum_time,'dd')<=?"+index);
			try {
				params.add(sdf.parse(sumTimeEnd));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			index++;
		}
		//汇总发布人
		if (StringUtils.isNotEmpty(sumPeople)) {
			sql.append(" and t1.sum_people like ?"+index);
			params.add("%"+sumPeople+"%");
			index++;
		}
		sql.append(" order by t1.sum_time desc");
		return dynamicQuery.nativeQuery(Object[].class, new PageRequest(
				pageNumber - 1, pageSize), sql.toString(), params.toArray());
	}

	@Override
	public TblTemplateSum queryById(String id) {
		
		return templateSumDao.findOne(Integer.valueOf(id));
	}
	@Override
	public TblTemplateSum queryByWorkflowId(String workflowId) {
		
		return templateSumDao.findTblTemplateSumByTemplateId(workflowId);
	}
	/**
	 * TODO
	 * 新增传阅
	 */
	@Transactional
	@Override
	public void addPassRead(PassRead passRead) {
		String[] loginNames = passRead.getReadUserId().split(",");
		String userNames = "";
		for(int i=0;i<loginNames.length;i++){
			String userName = userSsoDao.queryUserNameBySsoId(loginNames[i]);
			userNames += userName + ",";
		}
		userNames = userNames.substring(0, userNames.length()-1);
		passRead.setReadUserName(userNames);
		passReadDao.save(passRead);
	}
	/**
	 * 根据登录名查传阅信息的汇总ID
	 * @param loginName
	 * @return
	 */
	public List<String> queryReportSumIdByLoginName(String loginName){
		StringBuffer sb = new StringBuffer("select t.report_sum_id,t.template_name,t.pass_user_id,t.pass_user_name,t.read_user_id,t.read_user_name"
				+ " from tbl_pass_read t "
				+ " where t.read_user_id like ?1");
		loginName = "%"+loginName+"%";
		List<Object[]> objsList = dynamicQuery.nativeQuery(Object[].class, sb.toString(),loginName);
		if(objsList.size()==0 || objsList==null){
			return null;
		}
		
		List<String> list = new ArrayList<String>();
		for(Object[] objs : objsList){
			String reportSumId = CommonHelper.toStr(objs[0]);
			if(reportSumId != null){
				list.add(reportSumId);
			}
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
}


