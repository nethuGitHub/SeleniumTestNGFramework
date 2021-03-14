package com.application1.staticblocks;

import java.util.HashMap;
import java.util.Map;

public class Runner {


	private static String o = "Rajathi Raja";

	private static Map<String,String> map = new HashMap<>();
	static {
		map.put("A", "AA");
	}

	static {
		o = "Manithan";
		map.put("B", "BB");
	}
	public static void main(String[] args) {
		System.out.println(o);
		System.out.println(map);
	}
}


