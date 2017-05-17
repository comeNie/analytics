/**
 * 固定数Service
 */
package com.orienttech.statics.service.fixednum;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.dao.entity.fixednum.FinIndexBo;
import com.orienttech.statics.dao.entity.fixednum.FinIndexFixed;

public interface FixednumService {

	List<FinIndexBo> findFinIndexInfo();

	List<FinIndexFixed> initDatas(boolean isCopy, String indexId,
			String fperiodnumber,SessionUser sUser);
	
	/**初始化插入固定数数据*/
	void insertFixedNumber(boolean isCopy, String indexId,
			String fperiodnumber,SessionUser sUser);
	
	/**修改保存固定数数据*/
	boolean save(FinIndexFixed fixed);
	
	/**查找固定数数据据*/
	List<FinIndexFixed> searchFixedNumber(String indexId,
			String fperiodnumber,SessionUser sUser);
	
	/**不复制上月数据*/
	void noCopyDatas(boolean isCopy, String indexId,
			String fperiodnumber, List<String> ecogs, String detailNo);
	
	/**复制上月数据*/
	void isCopyDatas(boolean isCopy, String indexId,
			String fperiodnumber, List<String> ecogs, String detailNo);
	
	void downloadExcel(String fileName,HttpServletRequest request,HttpServletResponse response) throws Exception;
	
}
