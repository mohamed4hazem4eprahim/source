package com.example.chat;

import java.util.ArrayList;

import com.example.chat.ShowOffers;
import com.example.chat.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ShowOffers extends Activity {

	private ArrayList<Item> items;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_offers);
		
		Bundle b = this.getIntent().getExtras();
		if(b != null) {
			items = b.getParcelableArrayList("A");
		}
	}
	
	private class MyAdapter extends BaseAdapter {
		private ArrayList<String> items = new ArrayList<String>();
		
		@Override
		public int getCount() {
			return items.size();
		}

		public void add(String item) {
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
			if (convertView ==  null) 
				convertView = View.inflate(ShowOffers.this, R.layout.list_item, null);
			((TextView)convertView.findViewById(R.id.text)).setText(getItem(position).toString());

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
