//package com.myspringmvc.myhibernate.entity;
//
//import java.util.Date;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.NaturalId;
//
///**
// * 学生实体类
// * 
// */
//@Entity(name="t_students")
////@Table(name="t_students",schema="learn") //这样运行直接报错
//public class Student {
//	
//	private int sid;
//	
//	private String sname;
//
//	private String gender;
//
//	private Date birthday;
//
//	private String major;
//
//	//private String address;
//	
//	private Address address;
//	
//
//	public Student() {
//
//	}
//	
//	@Id
//	@NaturalId
//	public int getSid() {
//		return sid;
//	}
//
//	public void setSid(int sid) {
//		this.sid = sid;
//	}
//
//	public String getSname() {
//		return sname;
//	}
//
//	public void setSname(String sname) {
//		this.sname = sname;
//	}
//
//	public String getGender() {
//		return gender;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	public Date getBirthday() {
//		return birthday;
//	}
//
//	public void setBirthday(Date birthday) {
//		this.birthday = birthday;
//	}
//
//	public String getMajor() {
//		return major;
//	}
//
//	public void setMajor(String major) {
//		this.major = major;
//	}
//
//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
//
//
////	public String getAddress() {
////		return address;
////	}
////
////	public void setAddress(String address) {
////		this.address = address;
////	}
//	
//	
//
//}
