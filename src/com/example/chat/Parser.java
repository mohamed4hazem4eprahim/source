package com.example.chat;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import android.util.Log;



public class Parser {
	private String xml;
	private String price;
	private String length;
	
	public Parser(String xml,String price,String length){
		this.xml = xml;
		this.price = price;
		this.length = length;
	}
	public List<Item> parse(){

		
		  Document doc = null;
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        try {
	 
	            DocumentBuilder db = dbf.newDocumentBuilder();
	 
	            InputSource is = new InputSource();
	                is.setCharacterStream(new StringReader(xml));
	                doc = db.parse(is); 
	 
	            } catch (ParserConfigurationException e) {
	                Log.e("Error: ", e.getMessage());
	                return null;
	            } catch (SAXException e) {
	                Log.e("Error: ", e.getMessage());
	                return null;
	            } catch (IOException e) {
	                Log.e("Error: ", e.getMessage());
	                return null;
	            }

	        List<Item> itemList = new ArrayList<Item>();
	        NodeList nl = doc.getElementsByTagName("item");
	        for (int i=0; i< nl.getLength(); i++) {
	        	NodeList n = nl.item(i).getChildNodes();
	        	Item item = new Item();
	        	for (int j=0; j < 10;j++) {
	        		item.setId(n.item(j).getTextContent());
	        	}
	        	itemList.add(item);
	        }  		  
		return itemList;
	}
}
