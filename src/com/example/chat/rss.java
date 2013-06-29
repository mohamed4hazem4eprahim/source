package com.example.chat;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

	@Root
	public class Rss {
		
	     @ElementList
	     private List<Item> channel;
		
		public List<Item> getchannel() {
			return channel;
		}

		public void setchannel(List<Item> channel) {
			this.channel = channel;
		}
}
