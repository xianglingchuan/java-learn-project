package com.myspringmvc.annotation.demo.entity;

import java.lang.reflect.Method;

import com.myspringmvc.annotation.demo.AnnColumn;
import com.myspringmvc.annotation.demo.AnnTable;

@AnnTable("tb_user")
public class User {

	@AnnColumn("id")
	private int id;

	@AnnColumn("user_name")
	private String userName;

	@AnnColumn("nick_name")
	private String nickName;

	@AnnColumn("age")
	private int age;

	@AnnColumn("city")
	private String city;

	@AnnColumn("email")
	private String email;

	@AnnColumn("mobile")
	private String mobile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


}
