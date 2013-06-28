package com.example.chat;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class rss {
	
	@Element
	Channel channel;
	
	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@Root
	public class Channel {
		
		@ElementList
		List<Item> items;

		public List<Item> getItems() {
			return items;
		}

		public void setItems(List<Item> items) {
			this.items = items;
		}
	}
	
	@Root
	public class Item {

		@Element
		int id;
		
		@Element
		String title;
		
		@Element
		String link;
		
		@Element
		String description;
		
		@Element
		String regPrice;
		
		@Element
		String discPrice;
		
		@Element
		String price;
		
		@Element
		String percent;
		
		@Element
		String sold;

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
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getPercent() {
			return percent;
		}

		public void setPercent(String percent) {
			this.percent = percent;
		}

		public String getSold() {
			return sold;
		}

		public void setSold(String sold) {
			this.sold = sold;
		}

	}
}
