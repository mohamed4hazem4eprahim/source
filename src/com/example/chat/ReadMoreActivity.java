package com.example.chat;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

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
		int spaceIndex = v.indexOf(' ');
		String address = v.substring(5, spaceIndex);
		int phoneIndex = v.indexOf("tel=")+4;
		String tel = v.substring(phoneIndex);
		
		Typeface type = Typeface.createFromAsset(getAssets(), "fonts/sylfaen.ttf");
		
		TextView title = (TextView) findViewById(R.id.title);
		title.setTypeface(type);
		title.setText(item.getTitle());
		
		ImageView image = (ImageView) findViewById(R.id.imageMore);
		
		image.getLayoutParams().height = 350;
		image.getLayoutParams().width = 475;
		
		String parsedLink = ShowOffers.parsePictureLink(item.getDescription());
		Drawable d = ShowOffers.LoadImageFromWebOperations(parsedLink);

		image.setImageDrawable(d);
		
		TextView price = (TextView) findViewById(R.id.price_product);
		price.setTypeface(type);
		price.setText("ფასი: " + item.getPrice() + " ლარი");
		
		TextView sold = (TextView) findViewById(R.id.sold_quantity);
		sold.setTypeface(type);
		sold.setText("სულ გაიყიდა: " + item.getSold() + " ვაუჩერი");
		
		TextView addr = (TextView) findViewById(R.id.address);
		addr.setTypeface(type);
		addr.setText(address);
		
		TextView phone = (TextView) findViewById(R.id.phone);
		phone.setTypeface(type);
		phone.setText(tel);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.read_more, menu);
		return true;
	}

}
