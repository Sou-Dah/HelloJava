package Hello.HelloHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
https://habr.com/ru/company/umbrellaitcom/blog/423591/
 */

public class HelloHttpClientJava {
	public static void main(String[] args) throws IOException {
		System.out.println(new HelloHttpClientJava().doGetResponse());
	}
	
	public String doGetResponse() throws IOException {
		final URL url = new URL("http://jsonplaceholder.typicode.com/posts?_limit=10");
		final HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		con.setConnectTimeout(10000);
		con.setReadTimeout(10000);
		
		try (final BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));) {
			String inputLine;
			final StringBuilder content = new StringBuilder();
			while ((inputLine = br.readLine()) != null)
				content.append(inputLine);
			return content.toString();
			
		} catch (final Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
