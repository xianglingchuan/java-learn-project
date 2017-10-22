package com.myspringmvc.myhibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//设置Sutdents的联合主键

@Embeddable
public class StudentsPK implements Serializable {

	@Column(length=18)
	private String id; // 身份证号码
	
    @Column(length=8)
	private String sid; // 学号

	public StudentsPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentsPK(String id, String sid) {
		super();
		this.id = id;
		this.sid = sid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public boolean equals(Object anObject) {
		return id.equals(anObject);
	}

	public int hashCode() {
		return id.hashCode();
	}
	
	

}
