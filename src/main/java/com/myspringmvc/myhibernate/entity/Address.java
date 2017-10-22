package com.myspringmvc.myhibernate.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String postCode;

	private String address;

	private String phone;

	public Address() {
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
