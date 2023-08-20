package com.park.project2.sns;
//javabean

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SNSMsg {
	private String p_owner;
	private BigDecimal p_no;
	private Date p_when;
	private String p_txt;
	private String p_color;
	private String p_photo;

	private List<SNSReply> p_replys;
	public SNSMsg() {
		// TODO Auto-generated constructor stub
	}
	public String getP_owner() {
		return p_owner;
	}
	public void setP_owner(String p_owner) {
		this.p_owner = p_owner;
	}
	public BigDecimal getP_no() {
		return p_no;
	}
	public void setP_no(BigDecimal p_no) {
		this.p_no = p_no;
	}
	public Date getP_when() {
		return p_when;
	}
	public void setP_when(Date p_when) {
		this.p_when = p_when;
	}
	public String getP_txt() {
		return p_txt;
	}
	public void setP_txt(String p_txt) {
		this.p_txt = p_txt;
	}
	public String getP_color() {
		return p_color;
	}
	public void setP_color(String p_color) {
		this.p_color = p_color;
	}
	public String getP_photo() {
		return p_photo;
	}
	public void setP_photo(String p_photo) {
		this.p_photo = p_photo;
	}
	public List<SNSReply> getP_replys() {
		return p_replys;
	}
	public void setP_replys(List<SNSReply> p_replys) {
		this.p_replys = p_replys;
	}
	public SNSMsg(String p_owner, BigDecimal p_no, Date p_when, String p_txt, String p_color, String p_photo,
			List<SNSReply> p_replys) {
		super();
		this.p_owner = p_owner;
		this.p_no = p_no;
		this.p_when = p_when;
		this.p_txt = p_txt;
		this.p_color = p_color;
		this.p_photo = p_photo;
		this.p_replys = p_replys;
	}
}
