package com.example.chat;

import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Spinner spinner1;
	private EditText editText1;
	private Button button1;
	
	private List<Item> items;
	
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
		this.items = list;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
