/**
 * 固定数
 */
package com.orienttech.statics.dao.entity.fixednum;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FinIndexFixedPK implements Serializable {
	private static final long serialVersionUID = -8375544680063344333L;
	@Column(name = "indexid", length = 6)
	private String indexId;// 指标ID
	@Column(name = "detailno", length = 6)
	private String detailNo;// 指标明细ID
	@Column(name = "id", length = 8)
	private String id;// 机构代码
	@Column(name = "fperiodnumber", length = 6)
	private String fperiodnumber;// 月份

	public String getIndexId() {
		return indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	public String getDetailNo() {
		return detailNo;
	}

	public void setDetailNo(String detailNo) {
		this.detailNo = detailNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFperiodnumber() {
		return fperiodnumber;
	}

	public void setFperiodnumber(String fperiodnumber) {
		this.fperiodnumber = fperiodnumber;
	}

}
