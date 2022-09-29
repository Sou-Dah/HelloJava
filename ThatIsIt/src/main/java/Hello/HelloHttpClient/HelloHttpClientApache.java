package Hello.HelloHttpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
/*
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpclient</artifactId>
            <version>4.5.13</version>
        </dependency>
 */

public class HelloHttpClientApache {
	public static void main(String[] args) throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		// get request
		HttpGet httpGet = new HttpGet("http://yandex.ru");
		HttpResponse httpResponseGet = httpClient.execute(httpGet);
		String bodyGet = EntityUtils.toString(httpResponseGet.getEntity());
		System.out.println(bodyGet);
		
		System.out.println();
		
		// post request
		HttpPost httpPost = new HttpPost("http://yandex.ru");
		httpPost.setHeader("qwe", "qwe");
		HttpResponse httpResponsePost = httpClient.execute(httpPost);
		String bodyPost = EntityUtils.toString(httpResponsePost.getEntity());
		System.out.println(bodyPost);
		
	}
}
