package com.example.chat;

import org.simpleframework.xml.Element;

public class Item {

	@Element
	private int id;

	@Element
	private String title;
	
	@Element
	private String link;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public double getRegPrice() {
		return regPrice;
	}

	public void setRegPrice(double regPrice) {
		this.regPrice = regPrice;
	}

	public double getDiscPrice() {
		return discPrice;
	}

	public void setDiscPrice(double discPrice) {
		this.discPrice = discPrice;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public double getPercent() {
		return Percent;
	}

	public void setPercent(double percent) {
		Percent = percent;
	}

	public double getSold() {
		return Sold;
	}

	public void setSold(double sold) {
		Sold = sold;
	}

	@Element
	private String description;
	
	@Element
	private double regPrice;
	
	@Element
	private double discPrice;
	
	@Element
	private double Price;
	
	@Element
	private double Percent;
	
	@Element
	private double Sold;
	
}
