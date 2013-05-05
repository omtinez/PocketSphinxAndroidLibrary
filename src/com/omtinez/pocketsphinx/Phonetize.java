package com.omtinez.pocketsphinx;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Phonetize {
	private static final LinkedHashMap<String, String> es_dictionary = createEsDictionary();
		
	private static LinkedHashMap<String, String> createEsDictionary() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		
		// A E I O U
		map.put("Á", "A");
		map.put("É", "E");
		map.put("Í", "I");
		map.put("Ó", "O");
		map.put("Ú", "U");
		
		// V B
		map.put("V", "B");
		
		// Z K
		map.put("C ([AOU])", "K $1");
		map.put("C ([EI])", "Z $1");
		map.put("Q U ([EI])", "K $1");
		
		// G J
		map.put("G ([EI])", "J $1");
		map.put("G U ([EI])", "G $1");
		
		// H
		map.put("H","");
		
		// CH GN LL RR
		map.put("C H", "CH");
		map.put("Ñ", "GN");
		map.put("L L", "LL");
		map.put("R R", "RR");
		
		// Y
		map.put("Y$", "I");
		
		return map;
	}
	
	private static String addSpaces(String word) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			res.append(word.charAt(i));
			res.append(' ');
		}
		return res.substring(0, word.length() * 2);
	}
		
	public static String spanish(String word) {
		String phone = addSpaces(word.toUpperCase());
		Set<Entry<String, String>> entries = es_dictionary.entrySet();
		for (Entry<String, String> entry : entries)
			phone = phone.replaceAll(entry.getKey(), entry.getValue());
		
		return phone;
	}
}
