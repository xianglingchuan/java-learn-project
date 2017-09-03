package com.myspringmvc.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.crypto.ec.ECNewPublicKeyTransform;
import org.jdom2.Attribute;
import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.AttributeFilter;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.EscapeStrategy;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import com.myspringmvc.xml.entity.Book;

public class JDOMDemo {

	public static List<Book> booksList = new ArrayList<Book>();

	public static void main(String[] args) {
        new JDOMDemo().createXml();
	}
	
	
	public void createXml(){
		//1、生成一个根节点
		Element rss = new Element("rss");
		//2、为节点添加属性
		rss.setAttribute("version","2.0");
		//3、生成一个document对象
		Document document = new Document(rss);
		
		Element channel = new Element("channel");
		rss.addContent(channel);
		Element title = new Element("title");
		title.setText("中国北京");
		channel.addContent(title);
		
		
		Element subTitle = new Element("subtitle");
		subTitle.addContent("<![CDATA[上海移动互联网]]>");
		channel.addContent(subTitle);
		
		
		//CDATA subTitle2=new CDATA("上海移动互联网");
		//subTitle.addContent(subTitle2);
		//channel.addContent(subTitle);
		
		
		
		Format format = Format.getCompactFormat();
		format.setIndent(" ");
		format.setEncoding("GBK");
		
		
		//4、创建XMLOutputter对象
		XMLOutputter outputter = new XMLOutputter(format);
		
		
		//5、利和outputer将document对象转换成xml文档
		try {
			outputter.output(document, new FileOutputStream(new File("src/main/resources/jdom.xml")));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public void parseXml(){
		// 1、创建一个SAXBuilder的对象
		SAXBuilder saxBuilder = new SAXBuilder();

		try {
			// 创建一个输入流，将xml文件加载到输入流中
			// File file = new File("src/main/resources/books.xml");
			File file = new File("src/main/resources/books.xml");
			// Document document = saxBuilder.build(file);

			InputStream inputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			Document document = saxBuilder.build(inputStreamReader);

			// 通过document对象获取xml文件的根节点
			Element rootElement = document.getRootElement();

			// 获取根节点下的子节点
			List<Element> bookList = rootElement.getChildren();
			System.out.println("bookList.size:" + bookList.size());

			for (Element book : bookList) {

				Book bookentity = new Book();

				int index = book.indexOf(book);
				System.out.println("******开始解析第" + (index + 1) + "本书******");
				List<Attribute> attributes = book.getAttributes();
				System.out.println("共有属性值：" + attributes.size() + "个");

				// 如果知道属性名称可以直接获取值
				String id = book.getAttributeValue("id");
				System.out.println("id====" + id);
				for (Attribute attribute : attributes) {
					String attrName = attribute.getName();
					String attrValue = attribute.getValue();
					System.out.println("属性为:" + attrName + ", 值为:" + attrValue);
					if (attrName.equals("id")) {
						bookentity.setId(attrValue);
					}
				}

				// 解析子节点
				List<Element> childers = book.getChildren();
				for (Element element : childers) {
					String attrName = element.getName();
					String attrValue = element.getValue();
					System.out.println("子节点名为:" + attrName + ", 子节点值为:" + attrValue);
					if (attrName.equals("name")) {
						bookentity.setName(attrValue);
					} else if (attrName.equals("author")) {
						bookentity.setAuthor(attrValue);
					} else if (attrName.equals("year")) {
						bookentity.setYear(attrValue);
					} else if (attrName.equals("price")) {
						bookentity.setPrice(attrValue);
					} else if (attrName.equals("language")) {
						bookentity.setLanguage(attrValue);
					}
				}
				System.out.println("******结束解析第" + (index + 1) + "本书******");

				booksList.add(bookentity);
				bookentity = null;

				System.out.println("总记录数为:" + booksList.size());
				for (Book tmpBook : booksList) {
					System.out.println("id: " + tmpBook.getId());
					System.out.println("name: " + tmpBook.getName());
					System.out.println("author: " + tmpBook.getAuthor());
					System.out.println("year: " + tmpBook.getYear());
					System.out.println("price: " + tmpBook.getPrice());
					System.out.println("language: " + tmpBook.getLanguage());

				}
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
