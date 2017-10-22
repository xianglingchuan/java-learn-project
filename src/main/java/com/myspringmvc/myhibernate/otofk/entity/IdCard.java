package com.myspringmvc.myhibernate.otofk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="t_idCard")
public class IdCard implements Serializable {

	@Id
	@GeneratedValue(generator = "pid")
	@GenericGenerator(name = "pid", strategy = "assigned")
	@Column(length = 18)
	private String pid; // 身份证号

	private String uname; // 会员名称

	public IdCard() {
		super();
	}

	public IdCard(String pid, String uname) {
		super();
		this.pid = pid;
		this.uname = uname;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

}
