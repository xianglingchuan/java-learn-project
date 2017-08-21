package com.myspringmvc.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.junit.runners.model.Annotatable;
import org.springframework.core.env.SystemEnvironmentPropertySource;

public class ParseAnn {
	
	
	
	public static void main(String[] args) {
		//1、使用类加载器加载类
		try {
			Class c = Class.forName("com.myspringmvc.annotation.Child");
			//2、找到类上面的注解
			boolean isExist = c.isAnnotationPresent(MyDescription.class);
			if(isExist){
				//3、拿到注解实例
				MyDescription description = (MyDescription)c.getAnnotation(MyDescription.class);
				System.out.println(description.value());
			}
			
			Method[] methods = c.getMethods();
			for(Method m:methods){
				boolean isMExist = m.isAnnotationPresent(MyDescription.class);
				if(isMExist){
					MyDescription description = (MyDescription)m.getAnnotation(MyDescription.class);
					System.out.println(description.value());
				}				
			}
			
			//另外一种解析方法注解的方法
			System.out.println("***第二种解析方法***");
			for(Method m:methods){
				Annotation[] annotations = m.getAnnotations();
				for(Annotation annotation : annotations){
					if(annotation instanceof MyDescription){
						MyDescription d = (MyDescription)annotation;
						System.out.println(d.value());
					}
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
