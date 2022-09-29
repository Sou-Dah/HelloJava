package WhatIsIt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения

оригинальный    редактированный    общий
file1:          file2:             результат:(lines)
 
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка4            ADDED строка4
строка5         строка5            SAME строка5
строка0                            REMOVED строка0
*/

public class FindChangesInFile {
	
	public static List<LineItem> lines = new ArrayList<LineItem>();
	
	public static void main(String[] args) throws IOException {
		String console = "" +
						 "src/JavaRushSolution/0.txt\n" +
						 "src/JavaRushSolution/1.txt\n" +
						 "";
		System.setIn(new ByteArrayInputStream(console.getBytes()));
		String file1 = null, file2 = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		file1 = br.readLine();
		file2 = br.readLine();
		br.close();
		
		try (BufferedReader br1 = new BufferedReader(new FileReader(file1));
			 BufferedReader br2 = new BufferedReader(new FileReader(file2));) {
			
			String f1str = null, f2str = null, f1newStr = null, f2newStr = null;
			int round = 1;
			int continuedCount = 1;
			
			while (continuedCount > 0) {
				if ( br1.ready() || br2.ready() )
					continuedCount = 3;
				continuedCount--;
				
				System.out.println(round + " круг " + br1.ready() + " " + br2.ready());
				round++;
				if (round > 20)
					break;
				
				//	Заполнение 1 переменных
				if ( f1newStr == null && br1.ready() )
					f1newStr = br1.readLine();
				if ( f1str == null ) {
					f1str = f1newStr;
					f1newStr = null;
				}
				if ( f1newStr == null && br1.ready() )
					f1newStr = br1.readLine();
				
				//	Заполнение 2 переменных
				if ( f2newStr == null && br2.ready() )
					f2newStr = br2.readLine();
				if ( f2str == null ) {
					f2str = f2newStr;
					f2newStr = null;
				}
				if ( f2newStr == null && br2.ready() )
					f2newStr = br2.readLine();
				
				//	Сравнение полупустых переменных и переход на следующий круг цикла
				if ( (f1str != null) && (f2str == null) ) {
					lines.add(new LineItem(Type.REMOVED, f1str));
					System.out.println("REMOVED");
					f1newStr = null;
					continue;
				}
				if ( (f1str == null) && (f2str != null) ) {
					lines.add(new LineItem(Type.ADDED, f2newStr));
					System.out.println("ADDED");
					f2str = null;
					continue;
				}
				
				//	Сравнение заполненных переменных
				if ( f1str.equals(f2str) ) {
					lines.add(new LineItem(Type.SAME, f1str));
					System.out.println("SAME");
					f1str = f1newStr;
					f1newStr = null;
					f2str = f2newStr;
					f2newStr = null;
				} else if ( f1str.equals(f2newStr) ) {
					lines.add(new LineItem(Type.ADDED, f2str));
					System.out.println("ADDED");
					f2str = f2newStr;
					f2newStr = null;
				} else if ( f1newStr.equals(f2str) ) {
					lines.add(new LineItem(Type.REMOVED, f1str));
					System.out.println("REMOVED");
					f1str = f1newStr;
					f1newStr = null;
				}
				
				Thread.sleep(100);
			}
			
			
			
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nИтог");
		for (LineItem li : lines) {
			System.out.println(li.type + " " + li.line);
		}
		
	}
	
	
	public static enum Type {
		ADDED,        //добавлена новая строка
		REMOVED,      //удалена строка
		SAME          //без изменений
	}
	
	public static class LineItem {
		public Type type;
		public String line;
		
		public LineItem(Type type, String line) {
			this.type = type;
			this.line = line;
		}
		
	}
	
}
