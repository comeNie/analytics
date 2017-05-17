package com.orienttech.statics.web.controller.reportIndexShows;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.orienttech.statics.commons.base.BaseController;
import com.orienttech.statics.commons.base.Result;
import com.orienttech.statics.commons.datatables.DataTablesPage;
import com.orienttech.statics.commons.utils.Utils;
import com.orienttech.statics.dao.entity.indexshows.Index;
import com.orienttech.statics.dao.entity.indexshows.PrivFunction;
import com.orienttech.statics.service.statisticsIndex.StatisticsIndexService;

@Controller
@RequestMapping("/statisticsIndex")
public class StatisticsIndexController extends BaseController {
	
	@Autowired
	private StatisticsIndexService statisticsIndexService;
	
	@RequestMapping
	public String index(){
		return "/statisticsIndex/statisticsIndex";
	}
	
	/**
	 * 
	 * 查询所有的报表指标
	 */
	@RequestMapping(value = "/findAllIndex", method = RequestMethod.POST)
	@ResponseBody
	public DataTablesPage findList(Integer draw,
			@RequestParam("start") Integer firstIndex,
			@RequestParam("length") Integer pageSize,@RequestParam("search[value]") String search) {
		Page<Object[]> page=statisticsIndexService.findAllIndex(firstIndex / pageSize, pageSize, search);
		DataTablesPage dtPage=new DataTablesPage(draw, page);
		dtPage.setData(Lists.transform(page.getContent(), new Function<Object[], Index>() {
			@Override
			public Index apply(Object[] objs) {
				Index index =new Index(objs);
				/*if(index.getIndexMeaning().length() > 20 && index.getIndexMeaning().length() <= 40){
					String str = index.getIndexMeaning();
					str = str.substring(0, 20)+"</br>"+str.substring(20,str.length());
					index.setIndexMeaning(str);
				}else if(index.getIndexMeaning().length() > 40 && index.getIndexMeaning().length() <= 60){
					String str1 = index.getIndexMeaning();
					str1 = str1.substring(0, 20)+"</br>"+str1.substring(20,40)+"</br>"+str1.substring(40,str1.length());
					index.setIndexMeaning(str1);
				}else if(index.getIndexMeaning().length() > 60 && index.getIndexMeaning().length() <= 80){
					String str2 = index.getIndexMeaning();
					str2 = str2.substring(0, 20)+"</br>"+str2.substring(20,40)+"</br>"+str2.substring(40,60)+"</br>"+str2.substring(60,str2.length());
					index.setIndexMeaning(str2);
				}else if(index.getIndexMeaning().length() > 80 && index.getIndexMeaning().length() <= 100){
					String str3 = index.getIndexMeaning();
					str3 = str3.substring(0, 20)+"</br>"+str3.substring(20,40)+"</br>"+str3.substring(40,60)+"</br>"+str3.substring(60,80)+"</br>"+str3.substring(80,str3.length());
					index.setIndexMeaning(str3);
				}*/
				return index;
			}
		}));
		
		return dtPage;
	}
	
	/**
	 * 根据指标id查询指标
	 */
	@RequestMapping(value = "/findIndexById", method= RequestMethod.POST)
	@ResponseBody
	public Result findIndexById(int indexId){
		Index index = statisticsIndexService.findIndexById(indexId);
		return success(index);
	}
	
	/**
	 * 验证指标代码是否已存在
	 */
	@RequestMapping(value = "/validateIndexCode", method= RequestMethod.POST)
	@ResponseBody
	public boolean validateIndexCode(int indexId, String indexCode, String flag){
		return statisticsIndexService.findIndexByCode(indexId, indexCode, flag);
	}
	
	/**
	 * 验证指标名称是否已存在
	 */
	@RequestMapping(value = "/validateIndexName", method= RequestMethod.POST)
	@ResponseBody
	public boolean validateIndexName(int indexId, String indexName, String flag){
		return statisticsIndexService.findIndexByName(indexId, indexName, flag);
	}
	
	/**
	 * 修改或添加指标
	 */
	@RequestMapping(value = "/updateIndex", method= RequestMethod.POST)
	@ResponseBody
	public Result saveIndex(String flag, Index index){
		if(flag.equals("1")){
			statisticsIndexService.modifyIndex(index);
			return success();
		}else{
			statisticsIndexService.addIndex(index);
			return success();
		}
	}
	
	/**
	 * 修改或添加指标
	 */
	@RequestMapping(value = "/deleteIndex", method= RequestMethod.POST)
	@ResponseBody
	public Result deleteIndexById(int indexId){
		statisticsIndexService.deleteIndexById(indexId);
		return success();
	}
	
	/**
	 * 查询指标被那些报表引用
	 */
	@RequestMapping(value = "/findReportByIndexId", method= RequestMethod.POST)
	@ResponseBody
	public DataTablesPage findReportByIndexId(Integer draw,
			@RequestParam("start") Integer firstIndex,
			@RequestParam("length") Integer pageSize, int indexId) {
		Page<Object[]> page=statisticsIndexService.findReportByIndexId(firstIndex / pageSize, pageSize, indexId);
		return new DataTablesPage(draw, page);
	}
	
	/**
	 * 查抄引用该指标的报表是否存在
	 */
	@RequestMapping(value = "/findCountIndex", method= RequestMethod.POST)
	@ResponseBody
	public Result findCountIndex(int indexId){
		int num = statisticsIndexService.findCountIndex(indexId);
		if(num > 0){
			return failure();
		}else{
			return success();
		}
	}
}
