package com.example.chat;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import com.example.chat.ShowOffers;
import com.example.chat.R;

import android.os.Bundle;
import android.app.ListActivity;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowOffers extends ListActivity {

	private ArrayList<Item> items;
	private MyAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_offers);
		
		Bundle b = this.getIntent().getExtras();
		if(b != null) {
			items = b.getParcelableArrayList("A");
			createList();
		}
	}
	
	private void createList() {
		adapter = new MyAdapter();
		
		for(int i=0; i < items.size(); i++) {
			adapter.add(items.get(i));
		}
		
		setListAdapter(adapter);
	}
	
	private class MyAdapter extends BaseAdapter {
		private ArrayList<Item> items = new ArrayList<Item>();
		
		@Override
		public int getCount() {
			return items.size();
		}

		public void add(Item item) {
			items.add(item);
			notifyDataSetChanged();
		}
		
		@Override
		public Object getItem(int position) {
			return items.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView ==  null) convertView = View.inflate(ShowOffers.this, R.layout.list_item, null);
			final Item item = (Item) getItem(position);
			
			TextView tv = (TextView) convertView.findViewById(R.id.text);
			tv.setText(item.getTitle());
			
			String parsedLink = parsePictureLink(item.getDescription());
			
			Drawable d = LoadImageFromWebOperations(parsedLink);
			
			ImageView iv = (ImageView) convertView.findViewById(R.id.image);
			iv.setImageDrawable(d);
			
			Button button = (Button) convertView.findViewById(R.id.button);
			button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					String link = item.getLink();
					ReadMore task = new ReadMore(link, ShowOffers.this);
					task.execute();
				}
			});
			button.setText("Read More");
			
			return convertView;
		}
	}
	
	private static String parsePictureLink(String linkToParse) {
		int linkStartIndex = 10;
		int linkEndIndex = linkToParse.indexOf(".jpg")+4;
		String cut = linkToParse.substring(0, linkEndIndex);
		String newLink = cut.substring(linkStartIndex);
		return newLink;
	}
	
	private static Drawable LoadImageFromWebOperations(String url) {
	    try {
	        InputStream is = (InputStream) new URL(url).getContent();
	        Drawable d = Drawable.createFromStream(is, "src name");
	        return d;
	    } catch (Exception e) {
	        return null;
	    }
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_offers, menu);
		return true;
	}

}
