package com.zdnuist.xmlparse;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParseDemo {

	public static final String FILE_NAME = "D:\\tmp\\xml\\x1.xml";

	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document document;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(new File(FILE_NAME));

			Element root = document.getDocumentElement();
			// 上面找到了根节点，这里开始获取根节点下的元素集合
			NodeList list = root.getElementsByTagName("depart");
			System.out.println(list.getLength());

			for (int i = 0; i < list.getLength(); i++) {
				// 通过item()方法找到集合中的节点，并向下转型为Element对象
				Element n = (Element) list.item(i);
				// 获取对象中的属性map，用for循环提取并打印
				NamedNodeMap node = n.getAttributes();
				for (int x = 0; x < node.getLength(); x++) {
					Node nn = node.item(x);
					System.out.println(nn.getNodeName() + ": "
							+ nn.getNodeValue());
				}

				NodeList list2 = n.getElementsByTagName("user");
				System.out.println(list2.getLength() + "---list2.size");
				getNode(list2);

				 System.out.println("user: " +
				 n.getElementsByTagName("user").item(0).getFirstChild().getNodeValue());
				System.out.println("--");
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void getNode(NodeList list) {
		for (int i = 0; i < list.getLength(); i++) {
			// 通过item()方法找到集合中的节点，并向下转型为Element对象
			Element n = (Element) list.item(i);
			// 获取对象中的属性map，用for循环提取并打印
			NamedNodeMap node = n.getAttributes();
			for (int x = 0; x < node.getLength(); x++) {
				Node nn = node.item(x);
				System.out.println(nn.getNodeName() + ": " + nn.getNodeValue());
			}
			System.out.println("-");
		}
	}

}
