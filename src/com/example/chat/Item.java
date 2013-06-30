package com.example.chat;

import org.simpleframework.xml.Element;

import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

	public Item() { ; };
	
	public Item(Parcel in) { 
		readFromParcel(in);
	}
	
	@Element
	private String id;

	@Element
	private String title;

	@Element
	private String link;

	@Element
	private String description;

	@Element
	private String regPrice;

	@Element
	private String discPrice;

	@Element
	private String Price;

	@Element
	private String Percent;

	@Element
	private String Sold;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegPrice() {
		return regPrice;
	}

	public void setRegPrice(String regPrice) {
		this.regPrice = regPrice;
	}

	public String getDiscPrice() {
		return discPrice;
	}

	public void setDiscPrice(String discPrice) {
		this.discPrice = discPrice;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getPercent() {
		return Percent;
	}

	public void setPercent(String percent) {
		Percent = percent;
	}

	public String getSold() {
		return Sold;
	}

	public void setSold(String sold) {
		Sold = sold;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		 dest.writeString(id);
		 dest.writeString(title);
		 dest.writeString(link);
		 dest.writeString(description);
		 dest.writeString(regPrice);
		 dest.writeString(discPrice);
		 dest.writeString(Price);
		 dest.writeString(Percent);
		 dest.writeString(Sold);
	}

	private void readFromParcel(Parcel in) {
		 id = in.readString();
		 title = in.readString();
		 link = in.readString();
		 description = in.readString();
		 regPrice = in.readString();
		 discPrice = in.readString();
		 Price = in.readString();
		 Percent = in.readString();
		 Sold = in.readString();
	}

	@SuppressWarnings("rawtypes")
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		public Item createFromParcel(Parcel in) {
			return new Item(in);
		}

		public Item[] newArray(int size) {
			return new Item[size];
		}
	};
}
