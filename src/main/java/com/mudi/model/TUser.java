package com.mudi.model;

import java.math.BigDecimal;

public class TUser {
	private Long id;

	private String userName;

	private String wxOpenId;

	private String wxUserName;

	private String idCard;

	private String mobileNumber;

	private String salesNo;

	private Object createAt;

	private Short authStatus;

	private BigDecimal status;

	private String wxUnionid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getWxOpenId() {
		return wxOpenId;
	}

	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
	}

	public String getWxUserName() {
		return wxUserName;
	}

	public void setWxUserName(String wxUserName) {
		this.wxUserName = wxUserName == null ? null : wxUserName.trim();
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard == null ? null : idCard.trim();
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber == null ? null : mobileNumber.trim();
	}

	public String getSalesNo() {
		return salesNo;
	}

	public void setSalesNo(String salesNo) {
		this.salesNo = salesNo == null ? null : salesNo.trim();
	}

	public Object getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Object createAt) {
		this.createAt = createAt;
	}

	public Short getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(Short authStatus) {
		this.authStatus = authStatus;
	}

	public BigDecimal getStatus() {
		return status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public String getWxUnionid() {
		return wxUnionid;
	}

	public void setWxUnionid(String wxUnionid) {
		this.wxUnionid = wxUnionid;
	}

}