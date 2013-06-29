package com.example.chat;

import org.simpleframework.xml.Element;

public class Item {
	
//	public Item(String id, String title, String description, String regPrice, String discPrice, String price, String percent, String sold, String pdown) {
//		// TODO Auto-generated constructor stub
//	}

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
	
}
