package com.sinaif.hoover.model;

import java.util.Date;


public class UserInfoBean {
	
	private Integer id;
	private String uname;
	private String mobile;
	private Date createtime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getCreateTime() {
		return createtime;
	}
	public void setCreateTime(Date createTime) {
		this.createtime = createTime;
	}
	
	

}
