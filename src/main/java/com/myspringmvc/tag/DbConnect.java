package com.myspringmvc.tag;

import java.security.interfaces.RSAKey;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.sql.Connection;

public class DbConnect extends TagSupport {
	
	private String driver;
	private String url;	
	private String password;
	private String sql;
	private String username;
	
	
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	Connection connection = null;	
	Statement stmt = null;
	ResultSet rs =null;
	
	
	@Override
	public int doEndTag() throws JspException {
		
		
		try {
			Class.forName(this.driver);
			connection = DriverManager.getConnection(this.url,this.username,this.password);
			stmt = connection.createStatement();
			rs = stmt.executeQuery(this.sql);
			if(rs!=null){
				while (rs.next()) {
					pageContext.getOut().print(rs.getString("userName")+"<BR>");					
				}
			}
			return EVAL_PAGE;
		} catch (Exception e) {
			e.printStackTrace();
			return SKIP_PAGE;
		}finally {
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(connection!=null){
					connection.close();
				}				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	

}
