package JavaRushSolution;

import java.io.*;

public class Main {
	public static String fileName = "src/JavaRushSolution/save.ser";
	public static String fileName1 = "C:\\Users\\Username\\Desktop\\save.ser";
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//создаем наш объект
		String[] territoryInfo = new String[]{"У Испании 6 провинций", "У России 10 провинций", "У Франции 8 провинций"};
		String[] resourcesInfo = new String[]{"У Испании 100 золота", "У России 80 золота", "У Франции 90 золота"};
		String[] diplomacyInfo = new String[]{"Франция воюет с Россией, Испания заняла позицию нейтралитета"};
		
		SavedGame savedGame = new SavedGame(territoryInfo, resourcesInfo, diplomacyInfo);
		
		//создаем 2 потока для сериализации объекта и сохранения его в файл
		FileOutputStream outputStream = new FileOutputStream(fileName);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		
		// сохраняем игру в файл
		objectOutputStream.writeObject(savedGame);
		
		//закрываем поток и освобождаем ресурсы
		objectOutputStream.close();
		
		
		FileInputStream fileInputStream = new FileInputStream(fileName);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		
		SavedGame savedGame1 = (SavedGame) objectInputStream.readObject();
		
		System.out.println(savedGame1);
	}
}
