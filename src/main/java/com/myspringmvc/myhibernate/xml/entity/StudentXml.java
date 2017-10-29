package com.myspringmvc.myhibernate.xml.entity;

public class StudentXml {
	private int sid;
	private String sname;
	private String sex;
	// 在多方定义一个一方的引用
	private GradeXml grade;

	public GradeXml getGrade() {
		return grade;
	}

	public void setGrade(GradeXml grade) {
		this.grade = grade;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public StudentXml() {
		super();
	}

	public StudentXml(String sname, String sex) {
		super();
		this.sname = sname;
		this.sex = sex;
	}
}
