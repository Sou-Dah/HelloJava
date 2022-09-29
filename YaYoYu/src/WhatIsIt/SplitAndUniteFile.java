package WhatIsIt;

import java.io.*;
import java.util.Date;

public class SplitAndUniteFile {
	private static String originFileName = "" +
//										   "src/JavaRushSolution/67890.txt" +
										   "src/JavaRushSolution/12345.txt" +
										   "";
	private static String newFileName = "src/JavaRushSolution/0temp.txt";
	private static String fileNamesForConsole = null;
	
	public static void main(String[] args) {
		splitFile(originFileName);
		System.out.println(fileNamesForConsole);
		
		InputStream savedSystemIn = System.in;
		System.setIn(new ByteArrayInputStream(fileNamesForConsole.getBytes()));
		uniteFile(newFileName);
		
		System.setIn(savedSystemIn);
		System.out.print(new Date());
	}
	
	private static void splitFile(String fileName) {
		splitFile(fileName, 10);
	}
	
	private static void splitFile(String fileName, int partsCount) {
		StringBuilder fileNamesSB = new StringBuilder();
		try (FileInputStream fis = new FileInputStream(fileName);) {
			int regularPartsSize = fis.available() / (partsCount - 1);
			int lastPartSize = fis.available() % (partsCount - 1);
			System.out.println("file size = " + fis.available());
			System.out.println("regularParts Count x Size = " + (partsCount - 1) +
							   " x " + regularPartsSize);
			System.out.println("lastPart Size = " + lastPartSize);
			
			FileOutputStream fos;
			for (int i = 0; i < partsCount - 1; i++) {
				fileNamesSB.append(fileName + ".part" + (i + 1) + "\n");
				fos = new FileOutputStream(fileName + ".part" + (i + 1));
				for (int j = 0; j < regularPartsSize; j++) {
					int readedByte = fis.read();
					fos.write(readedByte);
				}
				
			}
			
			fileNamesSB.append(fileName + ".part" + partsCount + "\n");
			fos = new FileOutputStream(fileName + ".part" + partsCount );
			for (int j = 0; j < lastPartSize; j++) {
				int readedByte = fis.read();
				fos.write(readedByte);
			}
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileNamesForConsole = fileNamesSB.toString();
	}
	
	private static void uniteFile() {
		uniteFile(originFileName);
	}
	
	private static void uniteFile(String newFileName) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 FileOutputStream fos = new FileOutputStream(newFileName);) {
			while (br.ready()) {
				String fileName = br.readLine();
				FileInputStream fis = new FileInputStream(fileName);
				while (fis.available() > 0) {
					int readedInt = fis.read();
					fos.write(readedInt);
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
