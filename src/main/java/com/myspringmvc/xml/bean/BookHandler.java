package com.myspringmvc.xml.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.hankcs.hanlp.corpus.tag.NT;
import com.myspringmvc.xml.entity.Book;

public class BookHandler extends DefaultHandler {
	
	
	private Book book;
	
	private String currentValue;
	
	private List<Book> bookList = new ArrayList<Book>();
	
	
	public List<Book> getBookList() {
		return bookList;
	}


	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		
		
		if(qName.equals("book")){
			book = new Book();
			//1、已知属性名的时候
//			String value = attributes.getValue("id");
//			System.out.println("book的属性ID值是:"+value);
			
			//2、不知属性名的时候
			int length = attributes.getLength();
			System.out.println("book的属性长度为"+length);
			for(int i=0; i<length; i++){
				 String attrName =  attributes.getQName(i);
				 String attrValue = attributes.getValue(i);
				 System.out.println("book的属性:"+attrName+"="+attrValue);
				 if(attrName.equals("id")){
					 book.setId(attrValue);
				 }
			}
		}else if(!qName.equals("bookstore")){
			System.out.print("当前节点值为:"+qName+" ");
		}
	}
	
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		if(qName.equals("book")){
			bookList.add(book);
			book = null;
			
		}else if(qName.equals("name")){
			book.setName(currentValue);
		}else if(qName.equals("author")){
			book.setAuthor(currentValue);
		}else if(qName.equals("year")){
			book.setYear(currentValue);
		}else if(qName.equals("price")){
			book.setPrice(currentValue);
		}else if(qName.equals("language")){
			book.setLanguage(currentValue);
		}
	}
	
	
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("SAX开始解析xml文件");
	}
	
	
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("SAX结束解析xml文件");
	}
	
	
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		String value = new String(ch, start, length);
		if(!value.trim().equals("")){
			System.out.println("值为:"+value);	
			currentValue = value;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
