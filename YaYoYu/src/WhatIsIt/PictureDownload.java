package WhatIsIt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;

/*
https://images.suicidegirlsfree.com/d7/4318186/d74c11778bb8b8a66679b2fa8a9ad590/m/41.jpg
"D:\Users\User\Desktop\New folder"
https://fapopedia.net/photos/a/l/alicasanova/1000/0244.jpg
AliCasanova 
 */

public class PictureDownload {
	public static void main(String[] args) throws IOException {
		
		/*
		 */
		String s0 = "D:\\Users\\User\\Desktop\\123\\" +
					"AliCasanova" +
					" " +
					"1.";
		String s1 = "" +
//					"https://vip.sexhd.pics/gallery/isex/adria/brand-new-cam-sugar-babe/adria-" +
//					"https://nudecosplaygirls.com/wp-content/uploads/2020/11/AliCasanova-Patreon-Nudes-Leaks-00" +
					"https://fapopedia.net/photos/a/l/alicasanova/1000/000" +
					"";
		String s2 = "" +
					".jpg" +
//					".jpeg" +
					"";
		int begining = 9;
		int end = 0;
		
		
		int good = 0, bad = 0, all = 0;
		
//		for (int i = 1; i <= begining; i++) {
		for (int i = begining; i > end; i--) {
			System.out.print(i + " ... ");
			URL url = new URL(s1 + i + s2);
			try (InputStream inputStream = url.openStream();) {
				Files.copy(inputStream,
						   new File(s0 + i + s2).toPath());
				System.out.println("done");
				good++;
			} catch (FileAlreadyExistsException e) {
				bad++;
				System.out.println("Error!");
				System.out.println(e.getLocalizedMessage());
				System.out.println(e.getMessage());
//				break;
			} catch (FileNotFoundException e) {
				bad++;
				System.out.println("Error!");
				System.out.println(e.getMessage());
			} finally {
				all++;
			}
		}
		System.out.println("All = " + all + ", Good = " + good + ", Bad = " + bad);
	}
}
