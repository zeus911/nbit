package com.noboll.business.deliver.entity;

import java.util.Date;

import com.noboll.core.base.entity.BaseEntity;

/**
 * Position entity. @author MyEclipse Persistence Tools
 * 简历投递表 Deliver
 */

public class Deliver extends BaseEntity  {

	private static final long serialVersionUID = 631591814426724602L;
	
	// Fields
	private String resumeId;// 简历id
	private String requirementId;// 需求id
	private Date deliverTime;// 投递时间
	private String description;
	private String deleteFlag;
	
	
	private String resumeName;// 简历名称
	private String requirementName;// 需求名称
	private String customerName;// 客户名称
	private String address;// 需求地址
	private String addressName;// 需求地址
	private String yearsName;// 工作年限
	private String degreeName;// 学历
	private String positionName;// 申请岗位
	private String customerId;//客户id
	
	public String getResumeId() {
		return resumeId;
	}
	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}
	public String getRequirementId() {
		return requirementId;
	}
	public void setRequirementId(String requirementId) {
		this.requirementId = requirementId;
	}
	public Date getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getResumeName() {
		return resumeName;
	}
	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}
	public String getRequirementName() {
		return requirementName;
	}
	public void setRequirementName(String requirementName) {
		this.requirementName = requirementName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getYearsName() {
		return yearsName;
	}
	public void setYearsName(String yearsName) {
		this.yearsName = yearsName;
	}
	public String getDegreeName() {
		return degreeName;
	}
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
}