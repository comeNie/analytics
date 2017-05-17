package com.orienttech.statics.commons.utils;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;

/**
 *
 */
public class CacheMapHelper {
	private final static Map<String, Map<String, SysFuncItem>> SFCI_MAP=Maps.newHashMap();
	private final String REQ_METHOD_ALL="ALL";
	private static CacheMapHelper instance=null;
	
	private CacheMapHelper() {
		super();
	}

	public static CacheMapHelper getInstance(){
		if(instance==null){
			instance=new CacheMapHelper();
		}
		return instance;
	}
	/**
	 * @param servletPath
	 * @param reqMethod	ALL,POST,GET
	 * @param sfci
	 */
	public void putSysFunc(String servletPath,String reqMethod,SysFuncItem sfci){
		if(StringUtils.isBlank(servletPath)||StringUtils.isBlank(reqMethod)){
			return ;
		}
		reqMethod=reqMethod.toUpperCase();
		Map<String, SysFuncItem> sfciMap=null;
		if(SFCI_MAP.containsKey(servletPath)){
			sfciMap=SFCI_MAP.get(servletPath);
		}else{
			sfciMap=Maps.newHashMap();
			SFCI_MAP.put(servletPath, sfciMap);
		}
		sfciMap.put(reqMethod, sfci);
	}
	/**
	 * @param servletPath
	 * @param reqMethod	ALL,POST,GET
	 * @return
	 */
	public SysFuncItem getSysFuncItem(String servletPath,String reqMethod){
		if(StringUtils.isBlank(servletPath)||StringUtils.isBlank(reqMethod)||!SFCI_MAP.containsKey(servletPath)){
			return null;
		}
		SysFuncItem sfci=SFCI_MAP.get(servletPath).get(reqMethod.toUpperCase());
		if(sfci!=null){
			return sfci;
		}
		return SFCI_MAP.get(servletPath).get(this.REQ_METHOD_ALL);
	}
	
	public class SysFuncItem{
		private Long id;
		private Long functionId;
		private String functionName;
		
		public SysFuncItem(Long id, Long functionId, String functionName) {
			super();
			this.id = id;
			this.functionId = functionId;
			this.functionName = functionName;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getFunctionId() {
			return functionId;
		}
		public void setFunctionId(Long functionId) {
			this.functionId = functionId;
		}
		public String getFunctionName() {
			return functionName;
		}
		public void setFunctionName(String functionName) {
			this.functionName = functionName;
		}
	}
}
