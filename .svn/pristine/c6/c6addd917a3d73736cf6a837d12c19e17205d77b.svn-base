package com.orienttech.statics.service.fixednum.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orienttech.statics.commons.dynamicquery.DynamicQuery;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.commons.utils.PropertiesConstants;
import com.orienttech.statics.commons.utils.T14001031ExcelAction;
import com.orienttech.statics.dao.FixedNumberDao;
import com.orienttech.statics.dao.entity.fixednum.FinIndexBo;
import com.orienttech.statics.dao.entity.fixednum.FinIndexFixed;
import com.orienttech.statics.dao.entity.fixednum.FinIndexFixedPK;
import com.orienttech.statics.dao.fixednum.FinIndexDetailDao;
import com.orienttech.statics.dao.fixednum.StaDimOrgDao;
import com.orienttech.statics.service.cognos.common.ServerInfoHelper;
import com.orienttech.statics.service.fixednum.FixednumService;

@Service
public class FixednumServiceImpl implements FixednumService {

	@Autowired
	private DynamicQuery dynamicQuery;
	@Autowired
	private FixedNumberDao fixedNumberDao;
	@Autowired
	private StaDimOrgDao staDimOrgDao;
	@Autowired
	private FinIndexDetailDao finIndexDetailDao;

	private final static String DATASOURCE = "21";// 固定数表

	/**
	 * 获取指标
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FinIndexBo> findFinIndexInfo() {

		List<FinIndexBo> finIndexs = new ArrayList<FinIndexBo>(0);
		// 查询指标
		StringBuilder sb = new StringBuilder();
		sb.append("select a.indexId, a.caption from FinIndexBo a , FinIndexDetail b ");
		sb.append("where a.indexId = b.indexId and b.dataSource=?1 order by to_number(a.indexId)");

		finIndexs = (List<FinIndexBo>) dynamicQuery.query(sb.toString(),DATASOURCE);
		return finIndexs;
	}

	/**
	 * 初始化数据
	 * 
	 * @param isCopy
	 *            是否复制上月数据。true复制 ;false不复制。
	 * @param indexId
	 *            指标Id
	 * @param fperiodnumber
	 *            月份
	 * @param premLevel
	 *            用户等级
	 * @return 固定数列表
	 */
	@Transactional
	@Override
	public List<FinIndexFixed> initDatas(boolean isCopy, String indexId,
			String fperiodnumber, SessionUser sUser) {

		// 为空return
		if (!CommonHelper.isNotNull(indexId)
				&& !CommonHelper.isNotNull(fperiodnumber)) {
			return null;
		}
		// 插入到t_fin_index_fixednumber表
		insertFixedNumber(isCopy, indexId, fperiodnumber, sUser);
		// 查询固定数据
		return searchFixedNumber(indexId, fperiodnumber, sUser);

	}

	/**
	 * 查询固定数据
	 * 
	 * @param indexId
	 *            指标id
	 * @param fperiodnumber
	 *            月份
	 * @param premLevel
	 *            用户等级
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<FinIndexFixed> searchFixedNumber(String indexId,
			String fperiodnumber, SessionUser sUser) {

		StringBuilder sb = new StringBuilder();
		// 查询数据
		sb.append("select distinct a.indexId,c.finIndexFixedPK.id, b.description,c.finIndexFixedPK.detailNo,c.finIndexFixedPK.fperiodnumber,c.je,c.memo from FinIndexBo a,StaDimOrg b,FinIndexFixed c ");
		sb.append("where a.indexId = c.finIndexFixedPK.indexId and c.finIndexFixedPK.id = b.orgId and a.indexId=?1 and c.finIndexFixedPK.fperiodnumber=?2");

		// 如果不是管理员，则查询本机构的数据
		if (!StringUtils.equals("1", sUser.getPremLevel())) {
			sb.append(" and b.orgId1 =?3");
			sb.append(" order by nlssort(b.description,'NLS_SORT=SCHINESE_PINYIN_M')");
			return (List<FinIndexFixed>) dynamicQuery.query(sb.toString(),
					indexId, fperiodnumber, sUser.getOrgCode());
		}
		sb.append(" order by nlssort(b.description,'NLS_SORT=SCHINESE_PINYIN_M')");
		List<FinIndexFixed> ll = (List<FinIndexFixed>) dynamicQuery.query(sb.toString(), indexId,
				fperiodnumber);
		return (List<FinIndexFixed>) dynamicQuery.query(sb.toString(), indexId,
				fperiodnumber);
	}

	/**
	 * 初始化插入FixedNumber
	 * 
	 * @param isCopy
	 *            是否复制上月数据。true复制 ;false不复制。
	 * @param indexId
	 *            指标Id
	 * @param fperiodnumber
	 *            月份
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void insertFixedNumber(boolean isCopy, String indexId,
			String fperiodnumber, SessionUser sUser) {
		List<String> ecogs = new ArrayList<String>(0);
		// 1. 查询T_STA_DIM_ORG表中的ORGID
		StringBuffer sb = new StringBuffer();
		sb.append("select sd.orgId from StaDimOrg sd where 1=1 ");
		if (!StringUtils.equals("1", sUser.getPremLevel())) {
			sb.append("and orgId1 =?1");
			ecogs = (List<String>) dynamicQuery.query(sb.toString(),
					sUser.getOrgCode());
		} else {
			ecogs = (List<String>) dynamicQuery.query(sb.toString());
		}

		// 2. 通过指标id查询t_fin_index_detail中的id
		String detailNo = finIndexDetailDao.getDetailNoByIndexId(indexId);

		if (!isCopy) {
			// 不复制上月数据
			noCopyDatas(isCopy, indexId, fperiodnumber, ecogs, detailNo);
		} else {
			// 复制上月数据
			isCopyDatas(isCopy, indexId, fperiodnumber, ecogs, detailNo);
		}
	}

	/**
	 * 不复制上月数据
	 * 
	 * @param isCopy
	 *            是否复制. true：复制；false:不复制
	 * @param indexId
	 *            指标Id
	 * @param fperiodnumber
	 *            月份
	 * @param ecogs
	 *            机构list
	 * @param detailNo
	 *            指标详情Id
	 */
	@Override
	@Transactional
	public void noCopyDatas(boolean isCopy, String indexId,
			String fperiodnumber, List<String> ecogs, String detailNo) {

		FinIndexFixed fixed = null;
		FinIndexFixedPK pk = null;
		int count = 0;
		// 不复制上月数据
		for (int i = 0; i < ecogs.size(); i++) {
			// 3. 查询T_FIN_INDEX_FIXEDNUMBER中是否是否已存在。不存在则保存，否则不保存。
			count = fixedNumberDao.findFixedIsExist(indexId, detailNo,
					String.valueOf(ecogs.get(i)), fperiodnumber);
			if (count <= 0) {
				fixed = new FinIndexFixed();
				pk = new FinIndexFixedPK();

				pk.setIndexId(indexId);
				pk.setDetailNo(detailNo);
				pk.setId(String.valueOf(ecogs.get(i)));
				pk.setFperiodnumber(fperiodnumber);
				fixed.setFinIndexFixedPK(pk);
				save(fixed);
			}
		}
	}

	/**
	 * 复制上月数据
	 * 
	 * @param isCopy
	 *            是否复制. true：复制；false:不复制
	 * @param indexId
	 *            指标Id
	 * @param fperiodnumber
	 *            月份
	 * @param ecogs
	 *            机构list
	 * @param detailNo
	 *            指标详情Id
	 */
	@Override
	@Transactional
	public void isCopyDatas(boolean isCopy, String indexId,
			String fperiodnumber, List<String> ecogs, String detailNo) {

		FinIndexFixed fixed = null;
		FinIndexFixedPK pk = null;
		int count = 0;
		// 1.系统先检查上月数据是否完整。即ec_org_department中的id是否都存在于T_FIN_INDEX_FIXEDNUMBER表中
		noCopyDatas(isCopy, indexId, CommonHelper.date2Str(
				CommonHelper.addMonth(
						CommonHelper.str2Date(fperiodnumber, "yyyyMM"), -1),
				"yyyyMM"), ecogs, detailNo);

		// 2. 查询上月的数据
		List<FinIndexFixed> list = fixedNumberDao.findLastMonthDatas(
				CommonHelper.date2Str(CommonHelper.addMonth(
						CommonHelper.str2Date(fperiodnumber, "yyyyMM"), -1),
						"yyyyMM"), indexId);

		if (list != null) {
			for (int i = 0; i < list.size(); i++) {

				count = fixedNumberDao
						.findFixedIsExist(
								indexId,
								detailNo,
								String.valueOf(list.get(i).getFinIndexFixedPK()
										.getId()), fperiodnumber);
				if (count <= 0) {
					fixed = new FinIndexFixed();
					pk = new FinIndexFixedPK();

					pk.setIndexId(indexId);
					pk.setDetailNo(detailNo);
					pk.setId(String.valueOf(list.get(i).getFinIndexFixedPK()
							.getId()));
					pk.setFperiodnumber(fperiodnumber);

					fixed.setJe(list.get(i).getJe());
					fixed.setMemo(list.get(i).getMemo());
					fixed.setFinIndexFixedPK(pk);
					save(fixed);
				}
			}
		}
	}

	/**
	 * 保存
	 */
	@Override
	@Transactional
	public boolean save(FinIndexFixed fixed) {
		try {
			fixedNumberDao.save(fixed);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	 /**
     * 
     * @param file
     * @param fileName
	 * @throws Exception 
     */
	@Override
    public void downloadExcel(String fileName,HttpServletRequest request,HttpServletResponse response) throws Exception{
        // 弹出下载对话框(以附件形式打开文件流)
    	final String templatePathMO =PropertiesConstants.getString(PropertiesConstants.USER_HOME) + PropertiesConstants.getString(PropertiesConstants.TEMPLATE_PATH) + "/OrgExcel.xlsx";

    	String filename = fileName;
		Map<String,Object> mapinfo = new HashMap<String,Object>();
		T14001031ExcelAction excelAction = null;
    	
		SessionUser sUser = (SessionUser)SecurityUtils.getSubject().getPrincipal();
		StringBuilder sb = new StringBuilder();
		List list = new ArrayList();
		String indexId=request.getParameter("indexId");
		String fperiodnumber=request.getParameter("fperiodnumber");
		// 查询数据
		sb.append("select distinct a.indexId,c.finIndexFixedPK.id, b.description,c.finIndexFixedPK.detailNo,c.finIndexFixedPK.fperiodnumber,c.je,c.memo from FinIndexBo a,StaDimOrg b,FinIndexFixed c ");
		sb.append("where a.indexId = c.finIndexFixedPK.indexId and c.finIndexFixedPK.id = b.orgId and a.indexId=?1 and c.finIndexFixedPK.fperiodnumber=?2");

		// 如果不是管理员，则查询本机构的数据
		if (!StringUtils.equals("1", sUser.getPremLevel())) {
			sb.append(" and b.orgId1 =?3");
			sb.append(" order by nlssort(b.description,'NLS_SORT=SCHINESE_PINYIN_M')");
		    list = dynamicQuery.query(sb.toString(),indexId, fperiodnumber, sUser.getOrgCode());
		}else{
		sb.append(" order by nlssort(b.description,'NLS_SORT=SCHINESE_PINYIN_M')");
		    list = dynamicQuery.query(sb.toString(), indexId, fperiodnumber);
		}
		mapinfo.put("list", list);
		
    	
        String agent = (String) request.getHeader("USER-AGENT");
        excelAction = new T14001031ExcelAction(templatePathMO);
        if (agent != null && agent.toUpperCase().indexOf("FIREFOX") >-1) {
					response.setHeader("Content-Disposition",
							"aline;   filename=" + filename + ".xlsx");
					response.setHeader("Content-Transfer-Encoding","binary");    
					response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");         
					response.setHeader("Pragma", "public");   
            
            
            
            
        } else {
            response.setHeader( 
                    "Content-Disposition", 
                    "attachment; filename=" +
                            toUtf8String(fileName)+ ".xlsx");
        }
        
        ByteArrayOutputStream byteArrayOutputStream = excelAction.process(mapinfo);
		OutputStream output = response.getOutputStream();
		byte[] bExc = byteArrayOutputStream.toByteArray();
		output.write(bExc);
		byteArrayOutputStream.close();
		byteArrayOutputStream=null;
		output.close();
        
  
//        OutputStream stream=response.getOutputStream();
//        outputFile(file, stream);
    }
	
    /**
     * 转码
     * @param s
     * @return
     */
    private static String toUtf8String(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = Character.toString(c).getBytes("utf-8");
                } catch (Exception ex) {
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0) k += 256;
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
  
    }

}
