package com.example.chat;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.os.AsyncTask;

public class ReadMore extends AsyncTask<Void, Void, Void> {

	private String url;
	private String address;
	private String telNumber;

	public ReadMore(String link, Context ctx) {
		url = link;
	}
	
	
	@Override
	protected Void doInBackground(Void... params) {

		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(url);
		try {
			HttpResponse response = client.execute(getRequest);
			HttpEntity entity = response.getEntity();
			String responseText = EntityUtils.toString(entity);
			address = getAddres(responseText);
			telNumber =  getTelephone(responseText);
			addressParser parser = new addressParser(address);
			address = parser.parseAddress();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private String getTelephone(String response){
		int tellStart = response.indexOf("ტელ");
		int startTag = 0;
		int endTag = 0;
		boolean temp1 = false;
		boolean temp2 = false;
		for (int i = tellStart; i > 0; i--) {
			if(response.charAt(i)=='>'){
				endTag = i;
				temp1=true;
			}
			if(response.charAt(i)=='<'){
				startTag = i;
				temp2=true;
			}
			if(temp1 && temp2){
				break;
			}
		}
		String tagStart = response.substring(startTag,endTag+1);
		String tagEnd = tagStart.charAt(0) + "/" + tagStart.substring(1);
		int missEnd = response.indexOf(tagEnd,tellStart);
		String answer = response.substring(tellStart,missEnd);
		System.out.println(telNumber);
		return answer;
		
	}
	
	private String getAddres(String response) {
		int missStart = response.indexOf("მის:");
		int startTag = 0;
		int endTag = 0;
		boolean temp1 = false;
		boolean temp2 = false;
		for (int i = missStart; i >0; i--) {
			if(response.charAt(i)=='>'){
				endTag = i;
				temp1=true;
			}
			if(response.charAt(i)=='<'){
				startTag = i;
				temp2=true;
			}
			if(temp1 && temp2){
				break;
			}
		}
		String tagStart = response.substring(startTag, endTag+1);
		String tagEnd = tagStart.charAt(0) + "/" + tagStart.substring(1);
		int missEnd = response.indexOf(tagEnd,missStart);
		String answer = response.substring(missStart,missEnd);
		return answer;
	}

}
