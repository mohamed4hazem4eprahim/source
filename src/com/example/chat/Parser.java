package com.example.chat;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class Parser {
	private String xml;
	private String price;
	private String length;
	
	public Parser(String xml,String price,String length){
		this.xml = xml;
		this.price = price;
		this.length = length;
	}
	public String parse(){
		  try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
