package com.zdnuist.xmlparse;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParseDemo {

	public static final String FILE_NAME = "D:\\tmp\\xml\\x1.xml";

	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();

			parser.parse(new File(FILE_NAME), new MyParserHandler());

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class MyParserHandler extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		System.out.println("…………开始解析文档…………\n");
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("\n…………结束解析文档…………");
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("开始解析元素 " + qName);
		if (attributes != null) {
			for (int i = 0; i < attributes.getLength(); i++) {
				// getQName()是获取属性名称，
				System.out.println(attributes.getQName(i) + "=\""
						+ attributes.getValue(i) + "\"");
			}
		}
		System.out.print(qName + ":");
		super.startElement(uri, localName, qName, attributes);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("结束解析元素  " + qName);
		super.endElement(uri, localName, qName);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String content = new String(ch, start, length);
		System.out.println(content);
		super.characters(ch, start, length);
	}

}