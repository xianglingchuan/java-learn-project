package com.myspringmvc.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.util.AttributeHelper;

import com.mysql.jdbc.Field;

public class DOM4JDemo {

	public static void main(String[] args) {
		
		DOM4JDemo demo = new DOM4JDemo();
		demo.createXml();
		
	}
	
	
	public void createXml(){
		
		
		//1、创建document对象，代表整人xml文档
		Document document = DocumentHelper.createDocument();
		//2、创建根节点rss
		Element rss = document.addElement("rss");
		//3、向rss节点中添加version属性
		rss.addAttribute("version", "2.0");
		
		//4、生成子节点及节点内容
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
		title.setText("国内最新新闻");
		
		Element subTitle = channel.addElement("subtitle");
		subTitle.setText("<![CDATA[上海移动互联网]]>");
		
		
		
		//设备生成xml格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		
		//5、生成xml文件
		File file = new File("src/main/resources/dom4j.xml");
		try {
			
			XMLWriter writer = new XMLWriter(new FileOutputStream(file),format);
			//设置是否转义，默认值是true，代表转义,false代表不转义
			writer.setEscapeText(false);
			
			writer.write(document);
			writer.close();
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	

	public void parseXml() {
		SAXReader reader = new SAXReader();

		try {
			// 通过reader对象的read方法加载books.xml文件，获取document对象
			Document document = reader.read(new File("src/main/resources/books.xml"));
			// 通过document对象获取根节点bookstore

			Element bookStore = document.getRootElement();
			// 通过Element对象的elementIterator方法获取迭代器
			Iterator it = bookStore.elementIterator();
			while (it.hasNext()) {
				Element book = (Element) it.next();
				List<Attribute> bookAttr = book.attributes();
				for (Attribute attribute : bookAttr) {
					String attrName = attribute.getName();
					String attrValue = attribute.getValue();
					System.out.println("属性: " + attrName + "====" + attrValue);
				}
				String id = book.attributeValue("id");
				System.out.println("id==" + id);

				// 开始获取子节点
				Iterator childIt = book.elementIterator();
				while (childIt.hasNext()) {
					Element bookChild = (Element) childIt.next();
					String name = bookChild.getName();
					String value = bookChild.getText();
					System.out.println("子节点: " + name + "====" + value);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
