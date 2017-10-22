package com.myspringmvc.myhibernate.otobfk.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NaturalId;

/**
 * 用户实体类
 * 
 */
@Entity(name = "t_user_two")
public class User implements Serializable {

	@Id
	@GeneratedValue
	private int sid;

	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "pid", unique = true)
	private UserIdCard card;

	private String gender;

	private Date birthday;

	private String major;

	private String nickname;

	public User() {

	}

	public User(int sid, UserIdCard card, String gender, Date birthday, String major, String nickname) {
		super();
		this.sid = sid;
		this.card = card;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
		this.nickname = nickname;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	
	public UserIdCard getCard() {
		return card;
	}

	public void setCard(UserIdCard card) {
		this.card = card;
	}

}
