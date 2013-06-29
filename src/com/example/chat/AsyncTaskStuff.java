package com.example.chat;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import java.util.*;

public class AsyncTaskStuff extends AsyncTask<Object, Void, List<Item>> {
	
	private String link="http://www.hotsale.ge/index.php?option=com_sobi2&sobi2Task=rss&no_html=1&catid=4&Itemid=1&lang=ka";
	private List<Item> items;
	private Map <String, Object> param; 
	private Context mContext;
	
	public AsyncTaskStuff(Map<String, Object> map, Context applicationContext) {
		//param = new HashMap<String, Object>();
		param = map;
		mContext = applicationContext;
	}
	
	
	@Override
	protected List<Item> doInBackground(Object... params) {
		double price =  Double.parseDouble(param.get("price").toString());
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(link);
		try {
			HttpResponse response = client.execute(getRequest);
			HttpEntity entity = response.getEntity();
			String responseText = EntityUtils.toString(entity);
			Parser par = new Parser(responseText,price,null);
			items =  par.parse();
			System.out.println(items.size());
			System.out.println("raodenobaaaaaaa");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return items;
	}
	
	@Override
	protected void onPostExecute(List<Item> v) {
		//Intent newActivity = new Intent(mContext, ShowOffers.class);
	//	Bundle a = new Bundle();
		//a.
		//newActivity.putExtra("a", value);
	}
	
	public List<Item> getOffersInfo(){
        return this.items;
    }
	
}
