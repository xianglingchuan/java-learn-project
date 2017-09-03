package com.myspringmvc.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomDemo01 {

	public static void main(String[] args) {

		DomDemo01 domDemo01 = new DomDemo01();
		// domDemo01.xmlParse();
		domDemo01.xmlCreate();

	}

	public DocumentBuilder getDocumentBuilder() {
		// 创建一个DocumentBuilderFactory
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		// 创建一个DocumentBuilder
		DocumentBuilder documentBuilder = null;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return documentBuilder;
	}

	/**
	 * xml的解析
	 */
	public void xmlParse() {
		try {
			// //创建一个DocumentBuilderFactory
			// DocumentBuilderFactory documentBuilderFactory =
			// DocumentBuilderFactory.newInstance();
			// //创建一个DocumentBuilder
			// DocumentBuilder documentBuilder = getDocumentBuilder();
			// 通过DocumentBuilder对象的parser方法加载
			Document document = getDocumentBuilder().parse("books.xml");

			// 获取所有book节点的集合
			NodeList booklist = document.getElementsByTagName("book");

			System.out.println("一共有" + booklist.getLength() + "本书");
			// 遍历每一个book节点
			for (int i = 0; i < booklist.getLength(); i++) {
				Node book = booklist.item(i);
				// 获取book节点的所有属性集合
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("第" + (i + 1) + "本书共有" + attrs.getLength() + "个属性");
				for (int j = 0; j < attrs.getLength(); j++) {
					Node attr = attrs.item(j);
					String arrtName = attr.getNodeName();
					String arrtValue = attr.getNodeValue();
					System.out.println("属性:" + arrtName + "==" + arrtValue);
				}

				// 如果已知属性名称
				// Element eBook = (Element)booklist.item(i);
				// String id = eBook.getAttribute("id");
				// System.out.println("id值为:"+id);

				NodeList nodeList = book.getChildNodes();
				System.out.println("共有节点数是: " + nodeList.getLength());
				for (int k = 0; k < nodeList.getLength(); k++) {

					Node childNode = nodeList.item(k);
					Short nodeType = childNode.getNodeType();
					if (nodeType == Element.ELEMENT_NODE) {
						String nodeValue = childNode.getFirstChild().getNodeValue();
						// String nodeValue = childNode.getTextContent();
						String nodeName = childNode.getNodeName();
						System.out.println("属性:" + nodeName + "==" + nodeValue);
					}
				}
				System.out.println("***************************");
				System.out.println("***************************");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * xml的创建
	 */
	public void xmlCreate() {

		DocumentBuilder dBuilder = getDocumentBuilder();
		Document document = dBuilder.newDocument();

		// 去掉standalone="no"
		document.setXmlStandalone(true);

		Element bookStore = document.createElement("bookStore");
		// 向bookstore根节点中添加子节点book
		Element book = document.createElement("book");
		book.setAttribute("id", "1");

		Element name = document.createElement("name");
		name.setTextContent("两只老虎");
		book.appendChild(name);

		Element author = document.createElement("author");
		author.setTextContent("李二");
		book.appendChild(author);

		Element year = document.createElement("year");
		year.setTextContent("2011");
		book.appendChild(year);

		Element price = document.createElement("price");
		price.setTextContent("66");
		book.appendChild(price);

		// 将book节点添加到bookStore根节点中
		bookStore.appendChild(book);
		// 将bookStore节点添加到dom权中
		document.appendChild(bookStore);

		// 创建TransformerFactory对象
		TransformerFactory tff = TransformerFactory.newInstance();

		// 创建Transformer对象
		try {
			Transformer tf = tff.newTransformer();
			// 添加生成的xml有换行符
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.transform(new DOMSource(document), new StreamResult(new File("src/main/resources/newbooks.xml")));
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		System.out.println("生成文件成功.");

	}
}
