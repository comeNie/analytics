/**
 * 指标
 */
package com.orienttech.statics.dao.entity.fixednum;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.orienttech.statics.commons.entity.BaseEntity;

@Entity
@Table(name="t_fin_index", schema = TJ_SCHEMA)
public class FinIndexBo extends BaseEntity{
	private static final long serialVersionUID = -8375544680063344333L;
	private String indexId;//指标ID
	private String caption;//描述
	private String memo;//备注
	
	@Id
	@Column(name="indexid")
	public String getIndexId() {
		return indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	@Column(name="caption")
	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	@Column(name="memo")
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
