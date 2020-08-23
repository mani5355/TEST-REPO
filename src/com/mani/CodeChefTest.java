package com.mani;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class CodeChefTest {
	public static void main(String[] args) throws UnsupportedEncodingException {

		//FormURLEncodedProperties FormURLEncodedProperties =new FormURLEncodedProperties();
		String url ="starfleet openid profile email ^\\/package\\/batchGeneratePackages\\:POST$ ^\\/package\\/batchGeneratePackages\\/.+\\:GET$ ^\\/package\\/auth-track\\/.+\\:GET$ ^\\/package\\/.+\\/invoice\\:GET$ ^\\/package\\/.+\\/shipping-label\\:GET$";
		//starfleet+openid+profile+email+%5E%5C%2Fpackage%5C%2FbatchGeneratePackages%5C%3APOST%24+%5E%5C%2Fpackage%5C%2FbatchGeneratePackages%5C%2F.%2B%5C%3AGET%24+%5E%5C%2Fpackage%5C%2Fauth-track%5C%2F.%2B%5C%3AGET%24+%5E%5C%2Fpackage%5C%2F.%2B%5C%2Finvoice%5C%3AGET%24+%5E%5C%2Fpackage%5C%2F.%2B%5C%2Fshipping-label%5C%3AGET%24
		String encodeURL=URLEncoder.encode( url, "UTF-8" ); 
		System.out.print("Encoded url " + encodeURL);
		// PROBLEM: https://www.codechef.com/JULY20B/problems/CHFNSWPS
		int res = find();
		System.out.print("number of swaps: " + res);
	}

	static int find() {
		Scanner sc = new Scanner(System.in);

		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		List<Integer> a1 = new ArrayList<>();
		List<Integer> a2 = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= n1; i++) {
			a1.add(sc.nextInt());
		}
		for (int i = 1; i <= n2; i++) {
			a2.add(sc.nextInt());
		}
		sc.close();
		for (int i = 0; i < a1.size(); i++) {

			if (map.containsKey(a1.get(i))) {
				int count = map.get(a1.get(i)) + 1;
				map.put(a1.get(i), count);
			} else
				map.put(a1.get(i), 1);

		}
		for (int i = 0; i < a2.size(); i++) {

			if (map.containsKey(a2.get(i))) {
				int count = map.get(a2.get(i)) + 1;
				map.put(a2.get(i), count);
			} else
				map.put(a2.get(i), 1);

		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {

			if (entry.getValue() % 2 != 0) {
				return -1;
			}
		}

		Collections.sort(a1);
		Collections.sort(a2);

		if (a1.equals(a2)) {
			return 0;
		}

		return n2;
	}
}
