package com.myspringmvc.myhibernate.otobfk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "t_user_two_idCard")
public class UserIdCard implements Serializable {

	@Id
	@GeneratedValue(generator = "pid")
	@GenericGenerator(name = "pid", strategy = "assigned")
	@Column(length = 18)
	private String pid; // 身份证号

	private String uname; // 会员名称
	
	
	//没有在一对一双向绑定关系测试成功，只完成了一对一单曲绑定关系
	@OneToOne(mappedBy = "card") 
	//@Transient
	private User user;

	public UserIdCard() {
	}

	public UserIdCard(String pid, String uname) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
