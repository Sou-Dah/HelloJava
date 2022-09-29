package Hello.HelloString;

import java.io.*;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/* 
https://javarush.ru/quests/lectures/questcore.level09.lecture11
Знакомство с тегами

	Из текста
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

	Изъять все тэги в порядке появлеия
span

	Ожидаемый результат
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

*/

public class HelloTagParser {
	private static String tag;
	public static void main(String[] args) throws IOException, InterruptedException {
		args = new String[]{
				"span"
		};
		tag = args[0];
		String console = "src/JavaRushSolution/0.txt";
		System.setIn(new ByteArrayInputStream(console.getBytes()));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String fileName = br.readLine();
		br.close();
		
		StringBuilder textSBFromFile = new StringBuilder();
		boolean isAppendSB = false;
		
		br = new BufferedReader(new FileReader(fileName));
		while ( br.ready() ) {
			String readedStr = br.readLine();
			textSBFromFile.append(readedStr);
		}
		br.close();
		System.out.println(textSBFromFile.toString() + "\n");

		System.out.println("-----------------------------------");
		int iPos = 1, iTag = 0, i1span = 0, i2span = 0;
		String resStr;
		Stack<Integer> iSpan = new Stack();
		Map<Integer, String> resMap = new TreeMap<>();
		
		
		while (iPos < textSBFromFile.length()) {
			iTag = textSBFromFile.indexOf(tag, iPos);
			System.out.print("iTag = " + iTag + "\t");
			if ( textSBFromFile.substring(iTag - 1, iTag + 4).equals("<span") ) {
				i1span = iTag - 1;
				System.out.println(textSBFromFile.substring(iTag - 1, iTag + 4));
				iSpan.push(i1span);
				iPos = iTag + 4;
			} else if ( textSBFromFile.substring(iTag - 2, iTag + 5).equals("</span>") ) {
				i2span = iTag + 5;
				System.out.print(textSBFromFile.substring(iTag - 2, iTag + 5));
				
				resStr = textSBFromFile.substring(iSpan.peek(), iTag + 5);
				
				resMap.put(iSpan.pop(), resStr);

				System.out.println();
				System.out.println("resStr = " + resStr);
				iPos = i2span;
			}

			System.out.println();
			Thread.sleep(10);
		}
		
		System.out.println("-----------------------------------");
		for (Map.Entry entry : resMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
//		for (Map.Entry entry : resMap.entrySet()) {
//			System.out.println(entry.getKey());
//		}
//		for (Map.Entry entry : resMap.entrySet()) {
//			System.out.println(entry.getValue());
//		}
	}
	
}
