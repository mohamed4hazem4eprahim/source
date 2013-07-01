package com.example.chat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ReadMoreActivity extends Activity {

	private Item item;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read_more);

		Bundle b = this.getIntent().getExtras();
		if (b != null) {
			item = b.getParcelable("A");
			String link = item.getLink();
			ReadMore task = new ReadMore(link, ReadMoreActivity.this);
			task.execute();
		}
	}

	public void setMoreInfo(String v) {

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.read_more, menu);
		return true;
	}

}
