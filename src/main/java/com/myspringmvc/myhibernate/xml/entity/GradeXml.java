package com.myspringmvc.myhibernate.xml.entity;

import java.util.Set;

public class GradeXml {

	private int gid;
	private String gname;
	private String gdesc;
	private Set<StudentXml> students;

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGdesc() {
		return gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}

	public GradeXml() {
		super();
	}

	public Set<StudentXml> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentXml> students) {
		this.students = students;
	}

	public GradeXml(int gid, String gname, String gdesc) {

		this.gid = gid;
		this.gname = gname;
		this.gdesc = gdesc;
	}

	public GradeXml(String gname, String gdesc) {
		this.gname = gname;
		this.gdesc = gdesc;
	}

}
