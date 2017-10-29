package com.myspringmvc.myhibernate.hql.entity;

import java.io.Serializable;

import javax.persistence.Entity;

public class SellerCommodity implements Serializable {

	public String name;

	private long sellerId;

	private String sellerName;

	
	
	
	public SellerCommodity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SellerCommodity(String name, long sellerId, String sellerName) {
		super();
		this.name = name;
		this.sellerId = sellerId;
		this.sellerName = sellerName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	@Override
	public String toString() {
		return "SellerCommodity [name=" + name + ", sellerName=" + sellerName + "]";
	}

}
