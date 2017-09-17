package com.myspringmvc.xml;

import java.awt.image.RescaleOp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.myspringmvc.xml.bean.BookHandler;
import com.myspringmvc.xml.entity.Book;

public class SAXDemo01 {
	
	public static void main(String[] args) {
		
		//解析xml
		SAXDemo01 demo01 = new SAXDemo01();
		//demo01.parseXml();
		demo01.createXml();
		
		
		
	}
	
	public void createXml(){
		
		List<Book> bookList =  parseXml();
		//生成xml
		//1、创建一个TransformerFactory类的对象
		SAXTransformerFactory tff = (SAXTransformerFactory)SAXTransformerFactory.newInstance();
		
		
		try {
			//2、通过SAXTransformerFactory对象创建一个TransformerHandler对象
			TransformerHandler handler = tff.newTransformerHandler();
			//3、通过handler对象创建一个Transformer对象
			Transformer tr = handler.getTransformer();
			//4、通过Transformer对象对生成的xml文件进行设备
			//设备xml的编码
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			//设备xml是否换行
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			
			//5、创建一个Result对象
			File file = new File("src/main/resources/SAXbooks.xml");
			if(!file.exists()){
				file.createNewFile();
			}
			//6、创建Result对象，并且使其与handler关联
			Result result = new StreamResult(new FileOutputStream(file));
			handler.setResult(result);
			
			//7、利用handler对象进行xml文件内容的编写
			//打开document
			handler.startDocument();
			
			AttributesImpl attr = new AttributesImpl();
			handler.startElement("", "", "bookstore", attr);
			
			
			for (Book book : bookList) {
				attr.clear();
				attr.addAttribute("", "", "id", "", book.getId());
				handler.startElement("", "", "book", attr);
				
				attr.clear();
				handler.startElement("", "", "name", attr);
				handler.characters(book.getName().toCharArray(), 0, book.getName().toCharArray().length);
				handler.endElement("", "", "name");
				
				if(book.getAuthor()!=null){
					attr.clear();
					handler.startElement("", "", "author", attr);
					handler.characters(book.getAuthor().toCharArray(), 0, book.getAuthor().toCharArray().length);
					handler.endElement("", "", "author");					
				}
				
				attr.clear();
				handler.startElement("", "", "year", attr);
				handler.characters(book.getYear().toCharArray(), 0, book.getYear().toCharArray().length);
				handler.endElement("", "", "year");	
				
				attr.clear();
				handler.startElement("", "", "price", attr);
				handler.characters(book.getPrice().toCharArray(), 0, book.getPrice().toCharArray().length);
				handler.endElement("", "", "price");					
				
				if(book.getLanguage()!=null){
					attr.clear();
					handler.startElement("", "", "language", attr);
					handler.characters(book.getLanguage().toCharArray(), 0, book.getLanguage().toCharArray().length);
					handler.endElement("", "", "language");										
				}
				
				
				handler.endElement("", "", "book");
			}
			
			

			
			
			
			

			
			
			
			
			
			handler.endElement("", "", "bookstore");
			handler.endDocument();
			
			
			
			
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
	
	
	public List<Book> parseXml(){
		//获取一个ASXParserFactory的实例
		SAXParserFactory factory = SAXParserFactory.newInstance();
		BookHandler bookHandler = new BookHandler();
		List<Book> bookList = new ArrayList<Book>();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse("books.xml", bookHandler);
			bookList = bookHandler.getBookList();
			System.out.println("当前有:"+bookList.size()+"本图书");
			for (Book book : bookList) {
				System.out.println("id="+book.getId());
				System.out.println("name="+book.getName());
				System.out.println("year="+book.getYear());
				System.out.println("author="+book.getAuthor());
				System.out.println("price="+book.getPrice());
				System.out.println("language="+book.getLanguage());
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookList;
	}
	

}
