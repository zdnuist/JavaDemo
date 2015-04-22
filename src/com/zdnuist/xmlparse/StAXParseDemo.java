package com.zdnuist.xmlparse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXParseDemo {
	
	/**
	 * <com:depart />标签中，前缀com是命名空间，depart是localName，这两个合起来就是QName
	 */
	
	public static final String FILE_NAME = "D:\\tmp\\xml\\x1.xml";
	
	public static void main(String[] args) {
		
		XMLInputFactory factory = XMLInputFactory.newFactory();
		XMLStreamReader reader = null;
		try {
			 reader = factory.createXMLStreamReader(new FileReader(new File(FILE_NAME)));
			
			while(reader.hasNext()){
				int event = reader.next();  
                // 如果是元素的开始  
                if (event == XMLStreamConstants.START_ELEMENT) {  
                    // 列出所有用户名称  
                    if ("user".equalsIgnoreCase(reader.getLocalName())) {  
                        System.out.println("Name:"  
                                + reader.getAttributeValue(null, "name")+ ";Age:"  
                                        + reader.getAttributeValue(null, "age"));  
                    }  
                    
                }  else if(event == XMLStreamConstants.CHARACTERS){
                	 System.out.println(reader.getText());
                }
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				try {
					if(reader !=null)
					reader.close();
				} catch (XMLStreamException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

}
