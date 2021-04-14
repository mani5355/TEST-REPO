package com.mani;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class practice1 {
	public static void main(String[] args) {
		
		String s ="ABDEFGABEF";
		System.out.print(find(s));
	}

	static int find(String s) {
		char[] a = s.toCharArray();
		LinkedList<Character> list = new LinkedList<>();
		int count = 0;
		int rescount =0;
		for(char c:a) {
			if(list.contains(c)) {
				if(count<rescount) {
					count =rescount;
				}
				rescount=0;
				list = new LinkedList<>();
			}else {
				list.add(c);
				rescount++;
			}
		}
		if(count<rescount) {
		count =rescount;
		}
		
		/*
		 * char[] a = s.toCharArray(); HashMap<Character, Integer> map = new
		 * LinkedHashMap<>(); int count = 0; int rescount =0; for(char c:a) {
		 * if(map.containsKey(c)) { if(count<rescount) { count =rescount; } rescount=0;
		 * map = new LinkedHashMap<>(); }else { map.put(c, 1); rescount++; } }
		 * if(count<rescount) { count =rescount; }
		 */
		/*
		 * String res =""; for(Entry<Character, Integer> entry: map.entrySet()) { res =
		 * res + entry.getKey(); }
		 */
		return count;
	
		/*
		 * 
		 * char[] a = s.toCharArray(); HashMap<Character, Integer> map = new
		 * LinkedHashMap<>();
		 * 
		 * for(char c:a) { if(map.containsKey(c)) { break; }else { map.put(c, 1); } }
		 * String res =""; for(Entry<Character, Integer> entry: map.entrySet()) { res =
		 * res + entry.getKey(); } return res;
		 */}
}
