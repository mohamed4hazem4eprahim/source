package com.example.chat;

public class addressParser  {
	private String address;

	public addressParser(String address) {
		this.address = address;
	}
	
	public String parseAddress(){
		String answer="";
		for(int i = 0;i<address.length();i++){
			char  ch = address.charAt(i); 
			if((ch>65 && ch<127 )||( ch>33 && ch<42)){
				continue;
			}
			else{
				answer += ch;
			}
		}
		return answer;
	}

}
