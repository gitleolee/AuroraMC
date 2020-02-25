package com.plugin.String;

public class StringAPI {
	public static String titleCaptalize(String title) {
		String[] rv = title.toLowerCase().split(" ");
		String[] low = {"the","of","on","in","at","by","to","from","a","an","and","for","nor","but","or","yet","with","without","out"};
		
		for(int i = 0; i < rv.length; i++) {
			if(i == 0 || i == rv.length - 1) {
				rv[i] = captalizeFirstLetter(rv[i]);
			} else {
				boolean flag = false;
				for(int l = 0; l < low.length; l++) {
					if(low[l].equals(rv[i])) {
						flag = true;
					}
				}
				if(!flag) {
					rv[i] = captalizeFirstLetter(rv[i]);
				}
			}
		}
		
		return String.join(" ", rv);
	}
	
	
	public static String captalizeFirstLetter(String word) {
		word = word.toLowerCase();
		char c = Character.toUpperCase(word.charAt(0));
		return c + word.substring(1);
	}
}
