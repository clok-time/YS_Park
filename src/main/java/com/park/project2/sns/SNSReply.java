package com.park.project2.sns;

import java.math.BigDecimal;
import java.util.Date;

public class SNSReply {
	private BigDecimal pr_no;
	private BigDecimal pr_p_no;
	private String pr_owner;
	private String pr_txt;
	private Date pr_when;
public SNSReply() {
	// TODO Auto-generated constructor stub
}
public BigDecimal getPr_no() {
	return pr_no;
}
public void setPr_no(BigDecimal pr_no) {
	this.pr_no = pr_no;
}
public BigDecimal getPr_p_no() {
	return pr_p_no;
}
public void setPr_p_no(BigDecimal pr_p_no) {
	this.pr_p_no = pr_p_no;
}
public String getPr_owner() {
	return pr_owner;
}
public void setPr_owner(String pr_owner) {
	this.pr_owner = pr_owner;
}
public String getPr_txt() {
	return pr_txt;
}
public void setPr_txt(String pr_txt) {
	this.pr_txt = pr_txt;
}
public Date getPr_when() {
	return pr_when;
}
public void setPr_when(Date pr_when) {
	this.pr_when = pr_when;
}
public SNSReply(BigDecimal pr_no, BigDecimal pr_p_no, String pr_owner, String pr_txt, Date pr_when) {
	super();
	this.pr_no = pr_no;
	this.pr_p_no = pr_p_no;
	this.pr_owner = pr_owner;
	this.pr_txt = pr_txt;
	this.pr_when = pr_when;
}
}
