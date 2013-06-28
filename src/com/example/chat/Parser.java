package com.example.chat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;



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
		
		Serializer serializer = new Persister();

		try {
			rss r = serializer.read(rss.class, xml);
			System.out.println(r);
			rss.Channel c = r.getChannel();
			System.out.println(c);
			System.out.println(c.getItems().get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		System.out.println(xml);
//		 XmlPullParser parser = Xml.newPullParser();
//		 InputStream in = new ByteArrayInputStream(xml.getBytes());
//         try {
//        	 parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
//        	 parser.setInput(in, null);
//        	 parser.nextTag();
//        	 parser.require(XmlPullParser.START_TAG, null, null);
//        	 System.out.println("aq var");
//        	    while (parser.next() != XmlPullParser.END_TAG) {
//        	    	System.out.println("vtrualob");
//        	        if (parser.getEventType() != XmlPullParser.START_TAG) {
//        	            System.out.println("gastarta");
//        	        	continue;
//        	            
//        	        }
//        	        String name = parser.getName();
//        	        System.out.println(name);
//        	        if(name.equals("item")) {
//        	         
//        	        } else {
//        	          
//        	        }
//        	    }  
//		} catch (XmlPullParserException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//       
		  
		return null;
	}

}
