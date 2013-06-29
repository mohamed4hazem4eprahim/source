package com.example.chat;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;

import java.util.*;

public class AsyncTaskStuff extends AsyncTask<Map,Void, Void> {
	
	private String link="http://www.hotsale.ge/index.php?option=com_sobi2&sobi2Task=rss&no_html=1&catid=4&Itemid=1&lang=ka";
	private List<Item> items;
	
	@Override
	protected Void doInBackground(Map... params) {
		Map<String, Object> param = new HashMap<String, Object>();
		param = params[0];
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(link);
		try {
			HttpResponse response = client.execute(getRequest);
			HttpEntity entity = response.getEntity();
			String responseText = EntityUtils.toString(entity);
			Parser par = new Parser(responseText, null,null);
			items =  par.parse();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	
	@Override
	protected void onPostExecute(Void v) {
		

	}
	
	

}
