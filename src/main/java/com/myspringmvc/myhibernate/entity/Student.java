package com.myspringmvc.myhibernate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

/**
 * 学生实体类
 * 
 */
@Entity(name = "t_students")
// @Table(name="t_students",schema="learn") //这样运行直接报错
public class Student implements Serializable {

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// private int sid;

	// 提定一种主建的生成策略，也就是主键的值是由程序设置的
	// @Id
	// @GeneratedValue(generator = "uuid")
	// @GenericGenerator(name = "uuid", strategy = "assigned")
	// @Column(length = 8)
	// private String uuid;

	// 生成复合型的联合主键
	@EmbeddedId
	private StudentsPK pk;

	// 两个主建做为ID值
	// @Id
	// @Column(length=10)
	private String sname;

	private String gender;

	private Date birthday;

	private String major;

	@Transient
	private String nickname;

	// private String address;

	@Embedded
	private Address address;

	public Student() {

	}

	// 表示主键ID号
	// @Id
	// @NaturalId
	// public int getSid() {
	// return sid;
	// }
	//
	// public void setSid(int sid) {
	// this.sid = sid;
	// }

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public StudentsPK getPk() {
		return pk;
	}

	public void setPk(StudentsPK pk) {
		this.pk = pk;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	// public String getUuid() {
	// return uuid;
	// }
	//
	// public void setUuid(String uuid) {
	// this.uuid = uuid;
	// }

	// public String getAddress() {
	// return address;
	// }
	//
	// public void setAddress(String address) {
	// this.address = address;
	// }

}
