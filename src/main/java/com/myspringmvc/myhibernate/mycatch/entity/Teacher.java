package com.myspringmvc.myhibernate.mycatch.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity(name = "t_catche_teacher")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)  
public class Teacher {

	@Id
	@GeneratedValue
	private Integer tid;

	private String tname;

	public Teacher() {
	}

	public Teacher(Integer tid, String tname) {
		this.tid = tid;
		this.tname = tname;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + "]";
	}

}
