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

import java.util.*;

public class AsyncTaskStuff extends AsyncTask<Object, Void, List<Item>> {
	
	private List<Item> items;
	private Map <String, Object> param; 
	private Context mContext;
	private Map <String ,String> link;
	private String url;
	
	public AsyncTaskStuff(Map<String, Object> map, Context applicationContext) {
		link.put("kvebis obieqtebi","http://www.hotsale.ge/index.php?option=com_sobi2&sobi2Task=rss&no_html=1&catid=3&Itemid=1&lang=ka");
		link.put("gartoba","http://www.hotsale.ge/index.php?option=com_sobi2&sobi2Task=rss&no_html=1&catid=4&Itemid=1&lang=ka");
		link.put("janmrteloba da silamaze","http://www.hotsale.ge/index.php?option=com_sobi2&sobi2Task=rss&no_html=1&catid=5&Itemid=1&lang=ka");
		link.put("turizmi da sastumroebi","http://www.hotsale.ge/index.php?option=com_sobi2&sobi2Task=rss&no_html=1&catid=6&Itemid=1&lang=ka");
		link.put("bavshvebs","http://www.hotsale.ge/index.php?option=com_sobi2&sobi2Task=rss&no_html=1&catid=7&Itemid=1&lang=ka");
		link.put("wignebi da jurnalebi","http://www.hotsale.ge/index.php?option=com_sobi2&sobi2Task=rss&no_html=1&catid=10&Itemid=1&lang=ka");
		link.put("sayofacxovrebo teqnika","http://www.hotsale.ge/index.php?option=com_sobi2&sobi2Task=rss&no_html=1&catid=11&Itemid=1&lang=ka");
		link.put("swavla da ganatleba","http://www.hotsale.ge/index.php?option=com_sobi2&sobi2Task=rss&no_html=1&catid=12&Itemid=1&lang=ka");
		link.put("sxva momsaxurebebi","http://www.hotsale.ge/index.php?option=com_sobi2&sobi2Task=rss&no_html=1&catid=8&Itemid=1&lang=ka");
		link.put(" sxva produqcia","http://www.hotsale.ge/index.php?option=com_sobi2&sobi2Task=rss&no_html=1&catid=37&Itemid=1&lang=ka");
		//param = new HashMap<String, Object>();
		param = map;
		String category  = param.get("category").toString();
		url = link.get(category);
		mContext = applicationContext;
	}
	
	
	@Override
	protected List<Item> doInBackground(Object... params) {
		double price =  Double.parseDouble(param.get("price").toString());
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(url);
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
		super.onPostExecute(v);
		MainActivity a = (MainActivity)mContext;
		a.setOffersInfo(v);
	}
	
}
