/**
 * 固定数
 */
package com.orienttech.statics.dao.entity.fixednum;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.orienttech.statics.commons.entity.BaseEntity;

@Entity
@Table(name = "t_fin_index_fixednumber", schema = TJ_SCHEMA)
public class FinIndexFixed extends BaseEntity {
	private static final long serialVersionUID = -8375544680063344333L;

	@EmbeddedId
	private FinIndexFixedPK finIndexFixedPK;
	
	@Column(name = "je", precision = 22,scale=2)
	private BigDecimal je;// 金额
	@Column(name = "memo", length = 200)
	private String memo;// 备注

	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public FinIndexFixedPK getFinIndexFixedPK() {
		return finIndexFixedPK;
	}

	public void setFinIndexFixedPK(FinIndexFixedPK finIndexFixedPK) {
		this.finIndexFixedPK = finIndexFixedPK;
	}

}
