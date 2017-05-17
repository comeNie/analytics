package com.orienttech.statics.dao.entity;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.orienttech.statics.commons.entity.BaseEntity;

@Entity
@Table(name = "TB_EASTLENDING_MONITOR", schema = TJ_SCHEMA)
public class EastlendingMonitor extends BaseEntity {
	
	private static final long serialVersionUID = 6872424412924383366L;
	
	@Id
	@SequenceGenerator(name="SEQ_EASTLENDING_MONITOR" , sequenceName="SEQ_EASTLENDING_MONITOR",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_EASTLENDING_MONITOR")
	private Integer id;
	
	@Column(name="THE_DATE",length=20)
	private String theDate;//事件日期
	
	@Column(name="NAME",length=50)
	private String name;//事件名称
	
	@Column(name="TYPE",length=200)
	private String type;//事件类型
	
	@Column(name="TYPE_NAME")
	private String typeName;//事件类型名称
	
	@Column(name="UPLOAD_TIME")
	private Date uploadTime;//上传时间
	
	@Column(name="LINK",length=1)
	private String link;//url
	
	@Column(name="FILE_NAME",length=200)
	private String fileName;
	
	public EastlendingMonitor() {
		super();
	}
	public EastlendingMonitor(Integer id, String theDate, String name,
			String type, String typeName, Date uploadTime, String link,String fileName) {
		super();
		this.id = id;
		this.theDate = theDate;
		this.name = name;
		this.type = type;
		this.typeName = typeName;
		this.uploadTime = uploadTime;
		this.link = link;
		this.fileName = fileName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTheDate() {
		return theDate;
	}
	public void setTheDate(String theDate) {
		this.theDate = theDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

}
