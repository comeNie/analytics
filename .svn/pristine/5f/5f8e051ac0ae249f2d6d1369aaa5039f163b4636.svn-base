package com.orienttech.statics.service.usermng.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.orienttech.statics.commons.dynamicquery.DynamicQuery;
import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.service.cognos.NodeHelper;
import com.orienttech.statics.service.model.usermng.OrgDeptBo;
import com.orienttech.statics.service.model.usermng.OrgNodeBo;
import com.orienttech.statics.service.usermng.OrgDeptService;
@Service
public class OrgDeptServiceImpl implements OrgDeptService{
	@Autowired
	private DynamicQuery dynamicQuery;
	@Override
	public List<OrgDeptBo> findOrgDeptListByOrgId(String orgId) {
		String sql=null;
		List<Object[]> list=null;
		if(StringUtils.isNotBlank(orgId)&&"10001".equals(orgId)){
			sql="select orgid,name,description,orgid1 from t_sta_dim_org  where org_attr='1' order by orgid1,orgid";
			list=dynamicQuery.nativeQuery(sql);
		} else if("".equals(orgId)) {//查询所有小贷机构
			sql="select orgid,name,description,orgid1 from t_sta_dim_org  where org_attr='1' order by orgid1,orgid";
			list=dynamicQuery.nativeQuery(sql);
		}  else if("0".equals(orgId)) {//查询所有小贷机构
			sql="select orgid,name,description,orgid1 from t_sta_dim_org tsdo   where tsdo.org_attr='1' and substr(orgid,0,1)='6' order by tsdo.orgid1,tsdo.orgid";
			list=dynamicQuery.nativeQuery(sql);
		}  else if("01".equals(orgId)) {//查询所有小贷机构(不含天津)
			sql="select orgid,name,description,orgid1 from t_sta_dim_org tsdo   where tsdo.org_attr='1' and substr(orgid,0,1)='6' and orgid1 !='61561' order by tsdo.orgid1,tsdo.orgid";
			list=dynamicQuery.nativeQuery(sql);
		}  else if("02".equals(orgId)) {//全部(不含天津)
			sql="select orgid,name,description,orgid1 from t_sta_dim_org  where org_attr='1' and orgid1 !='61561' order by orgid1,orgid";
			list=dynamicQuery.nativeQuery(sql);
		} else if("00".equals(orgId)) {//查询所有小贷机构(除去工作组）
			sql="select orgid,name,description,orgid1 from t_sta_dim_org tsdo   where tsdo.org_attr='1' and substr(orgid,0,1)='6' and name not like '%专项工作组' order by tsdo.orgid1,tsdo.orgid";
			list=dynamicQuery.nativeQuery(sql);
		}else{
			sql="select orgid,name,description,orgid1 from t_sta_dim_org tsdo   where tsdo.org_attr='1' and tsdo.orgid1=?1 order by tsdo.orgid1,tsdo.orgid";
			list=dynamicQuery.nativeQuery(sql,orgId);
		}
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		return Lists.transform(list, new Function<Object[], OrgDeptBo>() {
			@Override
			public OrgDeptBo apply(Object[] objs) {
				return new OrgDeptBo(objs);
			}
		});
	}
	@Override
	public String findOrgNametListByOrgId(String orgId) {
		if(StringUtils.isNotBlank(orgId)&&"10001".equals(orgId)){
			return "全部机构";
		} else if("0".equals(orgId)) {//查询所有小贷机构
			return "所有小贷";
		} else if("01".equals(orgId)) {//查询所有小贷机构
			return "所有小贷(不含天津)";
		} else if("02".equals(orgId)) {//查询所有小贷机构
			return "全部(不含天津)";
		} else{
			String sql = "select orgid,name,description,orgid1 from t_sta_dim_org tsdo where tsdo.org_attr='1' and tsdo.orgid=?1";
			List<Object[]> list = dynamicQuery.nativeQuery(sql,orgId);
			if(CollectionUtils.isEmpty(list)){
				return null;
			}
			List<OrgDeptBo> listOrgDeptBo =  Lists.transform(list, new Function<Object[], OrgDeptBo>() {
				@Override
				public OrgDeptBo apply(Object[] objs) {
					return new OrgDeptBo(objs);
				}
			});
			return listOrgDeptBo.get(0).getDesc();
		}
		
	}
	
	
	@Override
	public List<OrgDeptBo> findOrgDeptListForHistoryReport(String orgId) {
		String sql=null;
		List<Object[]> list=null;
		if(StringUtils.isNotBlank(orgId)&&"10001".equals(orgId)){
			sql="select orgid,name,description,orgid1 from t_sta_dim_org  where org_attr='1' and substr(orgid,0,1)<>'1' order by orgid1,orgid";
			list=dynamicQuery.nativeQuery(sql);
		}else{
			sql="select orgid,name,description,orgid1 from t_sta_dim_org tsdo   where tsdo.org_attr='1' and substr(orgid,0,1)<>'1' and tsdo.orgid1=?1 order by tsdo.orgid1,tsdo.orgid";
			list=dynamicQuery.nativeQuery(sql,orgId);
		}
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		return Lists.transform(list, new Function<Object[], OrgDeptBo>() {
			@Override
			public OrgDeptBo apply(Object[] objs) {
				return new OrgDeptBo(objs);
			}
		});
	}
	
	@Override
	public List<OrgNodeBo> findOrgDeptBySelfOrgId(String orgId) {
		String sql = "select orgid,parent_id,name,description,orgid1 from t_sta_dim_org where org_attr='1' order by orgid1,orgid";
		List<Object[]> list = dynamicQuery.nativeQuery(sql);
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		List<OrgNodeBo> orgNodeBoList = Lists.transform(list, new Function<Object[], OrgNodeBo>() {
			@Override
			public OrgNodeBo apply(Object[] objs) {
				return new OrgNodeBo(objs);
			}
		});
		OrgNodeBo self = null;
		for (OrgNodeBo onb : orgNodeBoList) {
			if(onb.getId().equals(orgId)) {
				self = onb;
				break;
			}
		}
		//处理数据
		NodeHelper nodeHelper = new NodeHelper();
		
		OrgNodeBo father = nodeHelper.getLevel1Nodes(orgNodeBoList, self, "10001");
		
		orgNodeBoList = nodeHelper.getChildNodes(orgNodeBoList, father);
		
		return orgNodeBoList;
	}
	/**
	 * 获取资金来源
	 */
	@Override
	public List<OrgDeptBo> findFundSource() {
		String sql=null;
		List<Object[]> list=null;
		sql="select CODE_VALUE,CODE_NAME,CODE_KEY from code where code_type like 'CashSource'";
		list=dynamicQuery.nativeQuery(sql);
		
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		return Lists.transform(list, new Function<Object[], OrgDeptBo>() {
			@Override
			public OrgDeptBo apply(Object[] objs) {
				return new OrgDeptBo(objs);
			}
		});
	}
	@Override
	public String findOrgNameByOrgId(String orgId) {
		
		StringBuffer sb = new StringBuffer("select name from t_sta_dim_org where orgid = '" + orgId + "'");
		List<Object[]> list = dynamicQuery.nativeQuery(sb.toString());
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		String orgName = CommonHelper.toStr(list.get(0));
		
		return orgName;
	}
	@Override
	public String findOrgIdByOrgName(String orgName) {
		
		StringBuffer sb = new StringBuffer("select orgid from t_sta_dim_org where org_level=2 and description like'%"+orgName+"%'");
		List<Object[]> list = dynamicQuery.nativeQuery(sb.toString());
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		String orgId = CommonHelper.toStr(list.get(0));
		return orgId;
	}
	@Override
	public List<OrgDeptBo> findAllOrgDepts() {
		StringBuffer sb = new StringBuffer("select orgid,short_description from t_sta_dim_org where org_level=2 and orgid not in ('10001','10002','10003')");
		List<Object[]> list = dynamicQuery.nativeQuery(sb.toString());
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		List<OrgDeptBo> boList = new ArrayList<OrgDeptBo>();
		for(Object[] obj : list){
			String id = CommonHelper.toStr(obj[0]);
			String shortDescription = CommonHelper.toStr(obj[1]);
			
			OrgDeptBo bo = new OrgDeptBo();
			bo.setId(id);
			bo.setShortDescription(shortDescription);
			boList.add(bo);
		}
		return boList;
	}
}
