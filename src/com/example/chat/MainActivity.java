package com.example.chat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Spinner spinner1;
	private Button button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		addListenerOnSpinnerItemSelection();
		addListenerOnButton();
	}

	public void addListenerOnSpinnerItemSelection() {
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	}

	public void addListenerOnButton() {
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		button1 = (Button) findViewById(R.id.button1);

		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(
						MainActivity.this,
						"OnClickListener : " + "\nSpinner 1 : "
								+ String.valueOf(spinner1.getSelectedItem()),
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//public void test(View v) {
	//	HttpRequest request = new HttpRequest();
	//	request.execute();
	//}
}
