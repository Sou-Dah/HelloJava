package WhatIsIt;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class MotherFucker {
	static boolean pro = true;
	
	public static void main(String[] args) throws Exception {
		a1(args);
//		a2(args);
	}
	
	public static void a1(String[] args) throws IOException {
		/*
		 */
		String text = "Егор Алла Анна Дуся Клава Степан Жора   ";
		Pattern pattern = Pattern.compile("\\s");
		String[] strings = pattern.split(text,2);
		System.out.println(strings.length);
		for (String s : strings) {
			System.out.println(s);
		}
		System.out.println("---------");
		String[] strings1 = pattern.split(text);
		System.out.println(strings1.length);
		for (String s : strings1) {
			System.out.println(s);
		}
		
	}
	/*
	
	 */
	
	public static void a2(String[] args) throws IOException {
		
		if (pro) args = new String[]{ "src/JavaRushSolution/67890.txt" };
		if (args.length == 0) return;
		
		StringBuilder sb = new StringBuilder("");
		try (Reader fis = new InputStreamReader(new FileInputStream(args[0]))) {
			while (fis.ready()) sb.append((char) fis.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (pro) System.out.println(sb);
		
		Map<Character, Integer> map = new TreeMap<>();
		for (int i = 0; i < sb.length(); i++) {
			int n = 0;
			for (int j = 0; j < sb.length(); j++) {
				if (sb.charAt(i) == sb.charAt(j)) map.put(sb.charAt(i), ++n);
			}
		}
		
		
		for (Map.Entry me : map.entrySet()) System.out.println(me.getKey() + " " + me.getValue()); ;
		
	}
	
}








