package com.orienttech.statics.web.controller.fillFormItem;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orienttech.statics.commons.base.BaseController;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.dao.entity.FillFormCapitalPosition;
import com.orienttech.statics.service.fillFormItem.FillFormItemService;
import com.orienttech.statics.service.model.FillFormItemBo;

@RequestMapping("/fillFormItem")
@Controller
public class FillFormItemController extends BaseController {
	
	Logger logger = LoggerFactory.getLogger(FillFormItemController.class);
	
	@Autowired
	FillFormItemService fillFormItemService;
	
	@RequestMapping
	public String index(Long functionId,Model model){
		
		SessionUser curUser = getSessionUser();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sdf.format(new Date());
		List<FillFormItemBo> boList = fillFormItemService.findByFormId("1",curUser.getOrgCode());
		
		model.addAttribute("orgName", curUser.getOrgName());
		model.addAttribute("strDate", strDate);
		model.addAttribute("boList", boList);
		model.addAttribute("memo", boList.get(0).getMemo());
		return "/fillFormItem/fillFormItem";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(String fillDate,String memo,HttpServletRequest request,HttpServletResponse response){
		
		SessionUser curUser = getSessionUser();
		String[] cellValues = request.getParameterValues("cellValues[]");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = sdf1.format(new Date());
		
		
		List<FillFormCapitalPosition> list = new ArrayList<FillFormCapitalPosition>();
		for(String cellValue : cellValues){
			String[] values = cellValue.split(",");
			
			FillFormCapitalPosition fcp = new FillFormCapitalPosition();
			fcp.setFormId("1");//填报报表id
			fcp.setFillUser(curUser.getLoginName());//填报人
			fcp.setOrgId(curUser.getOrgCode());//填报机构
			fcp.setMemo(memo);//备注
			try {
				fcp.setFillDate(sdf.parse(fillDate));//填报日期
				fcp.setFillTime(sdf1.parse(now));//填报时间
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			fcp.setItemId(values[0]);//条目id
			fcp.setItemName(values[1]);//条目名称
			if(!values[2].equals("no")){
				fcp.setBalance(new BigDecimal(values[2]));//余额
			}
			if(!values[3].equals("no")){
				fcp.setProfit(new BigDecimal(values[3]));//收益
			}
			list.add(fcp);
		}
		
		String flag = fillFormItemService.save(curUser.getOrgCode(),list);
		return flag;
		
	}
	
	
	
	
	
	
	
	
	

}
