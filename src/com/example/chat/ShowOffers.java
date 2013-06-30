package com.example.chat;

import java.util.ArrayList;

import com.example.chat.ShowOffers;
import com.example.chat.R;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ShowOffers extends ListActivity {

	private ArrayList<Item> items;
	private MyAdapter adapter;
	private ListView listview;
	
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
		listview = (ListView) findViewById(R.id.my_list);
		adapter = new MyAdapter();
		listview.setAdapter(adapter);
		
		for(int i=0; i < items.size(); i++) {
			adapter.add(items.get(i));
		}
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
			Item item = (Item) getItem(position);
			
			TextView tv = (TextView) convertView.findViewById(R.id.text);
			tv.setText(item.getTitle());

			//ImageView iv = (ImageView) convertView.findViewById(R.id.image);
			//iv.setImageBitmap(bm)
			return convertView;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_offers, menu);
		return true;
	}

}
