package com.park.project2.Member;
//javabean

import java.math.BigDecimal;

public class Member {
private String p_id;
private String p_pw;
private String p_name;
private String p_addr;
private String p_photo;
private String p_role;
public Member() {
	// TODO Auto-generated constructor stub
}
public Member(String p_id, String p_pw, String p_name, String p_addr, String p_photo, String p_role) {
	super();
	this.p_id = p_id;
	this.p_pw = p_pw;
	this.p_name = p_name;
	this.p_addr = p_addr;
	this.p_photo = p_photo;
	this.p_role = p_role;
}
public String getP_id() {
	return p_id;
}
public void setP_id(String p_id) {
	this.p_id = p_id;
}
public String getP_pw() {
	return p_pw;
}
public void setP_pw(String p_pw) {
	this.p_pw = p_pw;
}
public String getP_name() {
	return p_name;
}
public void setP_name(String p_name) {
	this.p_name = p_name;
}
public String getP_addr() {
	return p_addr;
}
public void setP_addr(String p_addr) {
	this.p_addr = p_addr;
}
public String getP_photo() {
	return p_photo;
}
public void setP_photo(String p_photo) {
	this.p_photo = p_photo;
}
public String getP_role() {
	return p_role;
}
public void setP_role(String p_role) {
	this.p_role = p_role;
}

}