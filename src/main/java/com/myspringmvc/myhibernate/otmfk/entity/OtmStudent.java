package com.myspringmvc.myhibernate.otmfk.entity;

import java.io.Serializable;
import java.util.Date;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

/**
 * 学生实体类
 * 
 */
@Entity(name = "t_otm_students")
public class OtmStudent implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;

	private String sname;

	private String gender;

	private Date birthday;

	private String major;

	
//	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
//	@JoinColumn(name="cid",referencedColumnName="CID")
//	private OtmClassRoom classRoom;

	@Transient
	private String nickname;

	public OtmStudent() {

	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	public OtmStudent(String sname, String gender, Date birthday, String major, String nickname) {
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
		this.nickname = nickname;
	}

//	public OtmClassRoom getClassRoom() {
//		return classRoom;
//	}
//
//	public void setClassRoom(OtmClassRoom classRoom) {
//		this.classRoom = classRoom;
//	}



}
