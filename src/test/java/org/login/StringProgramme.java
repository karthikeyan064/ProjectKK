package org.login;

import java.util.HashMap;
import java.util.Map;

public class StringProgramme {
	
	public static void main(String[] args) {
		
		String s ="hi how are you hi how you doing hi dojng well";
		Map<String, Integer> m = new HashMap();
		String[] split = s.split(" ");
		for (int i = 0; i < split.length; i++) {
			if (m.containsKey(split[i])) {
				Integer d = m.get(split[i]);
				m.put(split[i], d+1);
				
			}else {
				m.put(split[i], 1);
			}
		}
		System.out.println(m);
		
		
	}

}
