package com.orienttech.statics.service.fillFormItem.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orienttech.statics.commons.dynamicquery.DynamicQuery;
import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.dao.FillFormCapitalPositionDao;
import com.orienttech.statics.dao.FillFormItemDao;
import com.orienttech.statics.dao.entity.FillFormCapitalPosition;
import com.orienttech.statics.service.fillFormItem.FillFormItemService;
import com.orienttech.statics.service.model.FillFormItemBo;

@Service
public class FillFormItemServiceImpl implements FillFormItemService {
	
	Logger logger = LoggerFactory.getLogger(FillFormItemServiceImpl.class);
	
	@Autowired
	private FillFormCapitalPositionDao fillFormCapitalPositionDao;
	@Autowired
	private FillFormItemDao fillFormItemDao;
	@Autowired
	private DynamicQuery dynamicQuery;
	@Override
	public List<FillFormItemBo> findByFormId(String formId,String orgId) {
		
		StringBuffer sb = new StringBuffer("select t1.form_id,t1.item_id,t1.item_name,"
				+ " t2.org_id,t2.balance,t2.profit,t2.memo,to_char(t2.fill_date, 'yyyy-mm-dd'),to_char(t2.fill_time,'yyyy-mm-dd hh12:mi:ss') "
				+ " from cognos_data.fill_form_item t1 "
				+ " left join cognos_data.fill_form_capital_position t2 "
				+ " on t1.item_id = t2.item_id"
				+ " and t2.org_id='"+orgId+"' and to_char(t2.fill_date,'yyyy-mm-dd')=to_char(sysdate,'yyyy-mm-dd')"
				+ " where t1.form_id = '"+formId+"' "
				+ " order by t1.item_id");
		List<Object[]> objectList = dynamicQuery.nativeQuery(sb.toString());
		if(objectList.size()==0 || objectList==null){
			return null;
		}
		List<FillFormItemBo> boList = new ArrayList<FillFormItemBo>();
		for(Object[] obj : objectList){
			String form_Id = CommonHelper.toStr(obj[0]);
			String itemId = CommonHelper.toStr(obj[1]);
			String itemName = CommonHelper.toStr(obj[2]);
			String org_Id = CommonHelper.toStr(obj[3]);
			BigDecimal balance = CommonHelper.toBigDecimal(obj[4]);
			BigDecimal profit = CommonHelper.toBigDecimal(obj[5]);
			String memo = CommonHelper.toStr(obj[6]);
			String fillDate = CommonHelper.toStr(obj[7]);
			String fillTime = CommonHelper.toStr(obj[8]);
			
			FillFormItemBo bo = new FillFormItemBo();
			bo.setFormId(form_Id);
			bo.setItemId(itemId);
			bo.setItemName(itemName);
			bo.setOrgId(org_Id);
			bo.setBalance(balance);
			bo.setProfit(profit);
			bo.setMemo(memo);
			bo.setFillDate(fillDate);
			bo.setFillTime(fillTime);
			boList.add(bo);
		}
		return boList;
	}
	
	@Transactional
	@Override
	public String save(String orgId,List<FillFormCapitalPosition> fcpList) {
		
		String flag = "保存成功！";
		
		for(FillFormCapitalPosition fcp : fcpList){
			
			FillFormCapitalPosition ffcp = fillFormCapitalPositionDao.searchByItemIdAndOrgId(orgId, fcp.getItemId());
			System.out.println(ffcp.getItemName());
			fillFormCapitalPositionDao.save(fcp);
			
			
		}
		return flag;
	}
	
	
	
	
	
}
