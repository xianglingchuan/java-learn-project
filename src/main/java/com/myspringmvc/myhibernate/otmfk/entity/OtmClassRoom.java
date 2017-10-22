package com.myspringmvc.myhibernate.otmfk.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="t_otm_classRoom")
public class OtmClassRoom {

	@Id
	@GeneratedValue(generator="cid")
	@GenericGenerator(name="cid",strategy="assigned")
	@Column(length=4)
	private String cid; // 班级的编号

	private String cname; // 班级的名字
	
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="cid")
	private Set<OtmStudent> students;
	
	

	public OtmClassRoom() {
	}

	public OtmClassRoom(String cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set<OtmStudent> getStudents() {
		return students;
	}

	public void setStudents(Set<OtmStudent> students) {
		this.students = students;
	}

	
	
}
