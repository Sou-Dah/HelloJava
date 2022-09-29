package Hello.HelloString;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/*
https://javarush.ru/groups/posts/136-reguljarnihe-vihrazhenija-v-java-chastjh-1

 */

public class HelloRegExDemo {
	static boolean useArgs = false;
	static boolean useConsole = true;
	static boolean useStaticRegEx = false;
	static boolean useStaticText = true;
	static String regEx = ".ox";
	static String text = "Егор Алла Александр Анна Дуся Клава Степан Жора  ";
	
	public static void main(String[] args) throws IOException {
		if ( !useArgs ) {
			args = new String[2];
			
			if ( !useConsole ) {
				args[0] = regEx;
				args[1] = text;
			} else {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String console = null;
				while (true) {
					System.out.print("Regular expression: ");
					if ( useStaticRegEx ) 
						args[0] = regEx;
					else {
						console = br.readLine();
						if ( console.equals("") || console == null ) break;
						args[0] = console;
					}
					
					System.out.print("Text: ");
					if ( useStaticText )
						args[1] = text;
					else {
						console = br.readLine();
						args[1] = console;
					}
					
					RegExEngine(args);
					System.out.println();
				}
				br.close();
				return;
			}
		}
		
		RegExEngine(args);
	}
	
	public static void RegExEngine(String[] args) {
		
		if (args.length != 2)
		{
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
			System.out.println("groupCount = " + m.groupCount());
			int i = 0;
			while (m.find()) {
				System.out.println(++i + ". Found [" + m.group() + "] starting at "
								   + m.start() + " and ending at " + (m.end() - 1));
			}
		}
		catch (PatternSyntaxException pse)
		{
			System.err.println("Неправильное регулярное выражение: " + pse.getMessage());
			System.err.println("Описание: " + pse.getDescription());
			System.err.println("Позиция: " + pse.getIndex());
			System.err.println("Неправильный шаблон: " + pse.getPattern());
		}
	}
}
