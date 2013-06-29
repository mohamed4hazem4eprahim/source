package com.example.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;

public class MainActivity extends Activity {

	private Spinner spinner1;
	private EditText editText1;
	private Button button1;
	
	private ArrayList<Item> items;
	
	HashMap<String, Object> map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		editText1 = (EditText) findViewById(R.id.editText1);
		button1 = (Button) findViewById(R.id.button1);
		
		map = new HashMap<String, Object>();
		
		addListenerOnButton();
	}

	public void addListenerOnButton() {

		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String category = String.valueOf(spinner1.getSelectedItem());
				String price = editText1.getText().toString();
				
				map.put("category", category);
				map.put("price", price);
				
				AsyncTaskStuff task = new AsyncTaskStuff(map, MainActivity.this);
				task.execute();
			}
		});
	}
	
	public void setOffersInfo(List<Item> list) {
		this.items = (ArrayList<Item>) list;
		callNewActivity();
	}
	
	private void callNewActivity() {
		Intent intent = new Intent(MainActivity.this, ShowOffers.class);
		Bundle b = new Bundle();
		b.putParcelableArrayList("A", (ArrayList<? extends Parcelable>) items);
		intent.putExtras(b);
		MainActivity.this.startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
