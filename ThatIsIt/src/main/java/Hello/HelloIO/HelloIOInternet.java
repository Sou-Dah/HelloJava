package Hello.HelloIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

public class HelloIOInternet {
	public static void main(String[] args) throws IOException {
		URL url;
		
		System.out.println("	+	Содержимое HTML-файла");
		url = new URL("https://javarush.ru");
		InputStream inputStream0 = url.openStream();
		byte[] buffer = inputStream0.readAllBytes();
		String str = new String(buffer);
		System.out.println(str);
		
		System.out.println("	+	Двустороннее соединение с записью и чтением");
		url = new URL("https://javarush.ru");
		URLConnection connection = url.openConnection();
		//	Поток записи
		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(1);
		outputStream.close();
		//	Поток чтения
		InputStream inputStream = connection.getInputStream();
		int data = inputStream.read();
		inputStream.close();
		
		System.out.println("	+	Сохранение файла на диск");
		String image = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png";
		URL urlGoogleImage = new URL( image );
		InputStream inputStreamGoogle = urlGoogleImage.openStream(); 
		Path path = Path.of("src/main/resources/public/GoogleLogo.png");
		Files.copy( inputStreamGoogle, path );
		inputStreamGoogle.close();
		
		System.out.println("	+	Сохранение файла на диск сокращённо");
		Files.copy(
				new URL("https://www.google.com/logo.png").openStream(),
				Path.of("src/main/resources/public/GoogleLogo1.png")
				  );
		
	}
}
