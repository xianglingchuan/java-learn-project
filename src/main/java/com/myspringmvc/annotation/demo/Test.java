package com.myspringmvc.annotation.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.core.env.SystemEnvironmentPropertySource;

import com.myspringmvc.annotation.demo.entity.Article;
import com.myspringmvc.annotation.demo.entity.User;

public class Test {
	
	
	public static void main(String[] args) {
		
		User user1 = new User();
		user1.setId(10);
		
		User user2 = new User();
		user2.setUserName("tom");
		user2.setCity("北京");
		user2.setMobile("19813584012");
		
		User user3 = new User();
		user3.setEmail("lui@sina.com,zh@163.com,41111@qq.com");
		
		
		String sql1 = query(user1);
		System.out.println("sql1:"+sql1);
		String sql2 = query(user2);
		System.out.println("sql2:"+sql2);
		String sql3 = query(user3);
		System.out.println("sql3:"+sql3);
		
		
		
		
		Article article = new Article();
		article.setUuid(11);
		article.setAuthor("tom");
		article.setTitle("论民主中国");
		System.out.println(query(article));
		
	}
	
	
	
	private static String query(Object object){
		StringBuilder sBuilder = new StringBuilder();
		//1、获取到class
		Class class1 = object.getClass();
		//2、获取到anntable的名称
		boolean exists = class1.isAnnotationPresent(AnnTable.class);
		if(!exists){
			 return null;
		}
		//3、获取tableName的名称
		AnnTable annTable = (AnnTable)class1.getAnnotation(AnnTable.class);
		String tableName = annTable.value();
		
		//3、遍历所有字段
		Field[] fieldArray = class1.getDeclaredFields();
		
		sBuilder.append("SELECT * FROM ");
		sBuilder.append(tableName).append(" WHERE 1=1");
		
		
		for(Field field:fieldArray){
			//4、处理第个字段的对应SQL
			//4.1 拿到字段名
			boolean fExists = field.isAnnotationPresent(AnnColumn.class);
			if(!fExists){
				continue;
			}
			AnnColumn column = field.getAnnotation(AnnColumn.class);
			String columnName = column.value();				
			//4.2、拿到字段的值
			String fieldName = field.getName();
			String getMethodName = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
			try {
				//System.out.println("getMethodName:"+getMethodName);
				Method getMethod = class1.getMethod(getMethodName);
				//使用类的反射拿到方法的值
				//4.3、拼装SQL语句
				Object fieldValueObject = getMethod.invoke(object, null);
				if(fieldValueObject instanceof Integer){
					int value = (int)fieldValueObject;
					if(value<=0){
						continue;
					}
				}else if(fieldValueObject instanceof String){
					String str = (String)fieldValueObject;
					if(str.equals("") || str==null){
						continue;
					}
				}else{
					continue;
				}
				sBuilder.append(" and ").append(fieldName);
				
				if(fieldValueObject instanceof Integer){
					sBuilder.append("=");
					sBuilder.append((int)fieldValueObject);							
				}else if(fieldValueObject instanceof String){
					String str = (String)fieldValueObject;
					int Index = str.indexOf(",");
					if(Index>=0){
						String[] sArray =  str.split(",");
						if(sArray.length>=1){
							
							sBuilder.append(" IN(");
							for (String tmpStr : sArray) {
								sBuilder.append("'").append(tmpStr).append("',");
							}
							
							sBuilder.deleteCharAt(sBuilder.length()-1);
							sBuilder.append(")");
						}
					}else{
						sBuilder.append("=");
						sBuilder.append("'").append((String)fieldValueObject).append("'");						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sBuilder.toString();
	}
}
