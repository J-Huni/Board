package com.inhatc.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int l_no;
	private String l_title;
	private String l_picture;
	private String l_content;
	private Date l_date;
	private String id;
	
	public int getL_no() {
		return l_no;
	}
	public void setL_no(int l_no) {
		this.l_no = l_no;
	}
	public Date getL_date() {
		return l_date;
	}
	public void setL_date(Date l_date) {
		this.l_date = l_date;
	}
	public String getL_title() {
		return l_title;
	}
	public void setL_title(String l_title) {
		this.l_title = l_title;
	}
	public String getL_picture() {
		return l_picture;
	}
	public void setL_picture(String l_picture) {
		this.l_picture = l_picture;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getL_content() {
		return l_content;
	}
	public void setL_content(String l_content) {
		this.l_content = l_content;
	}
}
