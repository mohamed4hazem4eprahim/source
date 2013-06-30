package com.example.chat;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;

public class ReadMore extends AsyncTask<Void, Void, Void> {

	private String url;

	@Override
	protected Void doInBackground(Void... params) {

		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(url);
		try {
			HttpResponse response = client.execute(getRequest);
			HttpEntity entity = response.getEntity();
			String responseText = EntityUtils.toString(entity);
			String answer = getAddres(responseText);
			String telNumber =  getTelephone(responseText);
			System.out.println(answer);
			System.out.println(telNumber);
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
		
		
		return null;
	}
	
	
	private String getAddres(String response) {
		int missStart = response.indexOf("მის:");
		int startTag = 0;
		int endTag = 0;
		boolean temp1 = false;
		boolean temp2 = false;
		for (int i = missStart; i < missStart + 1; i--) {
			if(response.charAt(i)=='>'){
				endTag = i;
			}
			if(response.charAt(i)=='<'){
				startTag = i;
			}
			if(temp1 && temp2){
				break;
			}
		}
		
		String tagStart = response.substring(startTag, endTag);
		String tagEnd = response.charAt(0) + '/' + tagStart.substring(1);
		int missEnd = response.indexOf(tagEnd,missStart);
		String address = response.substring(missStart,missEnd);
		return address;
	}

}
