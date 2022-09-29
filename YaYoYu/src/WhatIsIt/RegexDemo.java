package WhatIsIt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexDemo {
	private static Pro probe = new Pro();
	
	public static void main(String[] args) {
		probe.pro = true;
		args = new String[]{
				// Шаблон для поиска примечаний к коду
//				".*/\\*.*\\*/|.*//.*$",
				"(<span)|(</span>)",
				"Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela\n" +
				"</span></b></span><span>Super</span><span>girl</span>" };
		//       0123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789
		if (args.length!=2) {
			System.err.println("usage: java RegexDemo regex input");
			return;
		}
		// Преобразуем символьные последовательности начала новой строки (\n) в символы начала строки.
		args[1] = args[1].replaceAll("\\\\n", "\n");
		try {
			System.out.println("regex = " + args[0]);
			System.out.println("input = " + args[1]);
			Pattern p = Pattern.compile(args[0]);
			Matcher m = p.matcher(args[1]);
			while (m.find())
				System.out.println(
						// 1 строка — код автора, 2 строка — чистый код
//						"Found [" + m.group() + "] starting at " + m.start() + " and ending at " + (m.end() - 1));
						"Found [" + m.group() + "] starting at " + m.start() + " and ending at " + (m.end()));
		} catch (PatternSyntaxException pse) {
			System.err.println("Неправильное регулярное выражение: " + pse.getMessage());
			System.err.println("Описание: " + pse.getDescription());
			System.err.println("Позиция: " + pse.getIndex());
			System.err.println("Неправильный шаблон: " + pse.getPattern());
		}
	}
}
