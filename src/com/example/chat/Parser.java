package com.example.chat;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;



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
		System.out.println("aqvar");
		
		Serializer serializer = new Persister();
		
		System.out.println("aqvar");
		try {
			System.out.println("adasdas");
			
			
			
			System.out.println("momomomomomo");
			
			
			System.out.println("aaaaa");

			
			xml = "<rss version=\"2.0\">  <channel><title>HotSale - HotSale ფასდაკლებები</title><description /><opt><serT>1372454846</serT><timeout>15</timeout> </opt><link>http://www.hotsale.ge/index.php?option=com_sobi2&catid=1&Itemid=1&lang=ka</link><lastBuildDate>Sat, 29 Jun 2013 01:27:26 +0400</lastBuildDate><generator>Sigsiu Online Business Index 2 FeedCreator</generator> <item><id>6729</id><title>მათთვის ვისაც მართვის მოწმობის აღება სურს. თეორიული და პრაქტიკული სრული კურსი VIP ცენტრში</title><link>http://www.hotsale.ge/index.php?option=com_sobi2&sobi2Task=sobi2Details&sobi2Id=6729&Itemid=1&lang=ka</link><description><IMG src='http://hotsales.ge/images/com_sobi2/clients/6729_ico.jpg' /></description><regPrice>300</regPrice><discPrice>145</discPrice><Price>15</Price><Percent>52</Percent><Sold>36</Sold><pdown>1372620600</pdown> </item> </channel></rss>";
			

			Rss r = serializer.read(Rss.class, xml);
			System.out.println(r.getchannel().size());
			System.out.println(r.getchannel().get(0).getDescription());
//			System.out.println("keko");
//			System.out.println(r);
//			rss.Channel c = r.getChannel();
//			System.out.println(c);
//			System.out.println(c.getItems().get(0));
		} catch (Exception e) {
			System.out.println("pirshi sheveci");
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
