package Hello.HelloJSON;

import Skeleton.Human;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
/*
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.6</version>
        </dependency>
 */

public class HelloGSON {
	public static void main(String[] args) {
		
		Human human2 = new Human("Woman",
		                         18,
		                         false,
		                         new Date(2002, 11, 29),
		                         1.75,
		                         new String[]{ "child1", "child2" });
		
		Gson gson = new Gson();
		System.out.println( gson.toJson(human2) );
		
		Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
		System.out.println( gsonPretty.toJson(human2) );
		
		/*
		
		DataObject datObj = new DataObject();
		Gson gson = new Gson();
		String json = gson.toJson(datObj);
		System.out.println(json);
		DataObject obj = gson.fromJson(json, DataObject.class);
		
		// Строка с отступами и форматированием
		Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
		String jsonPretty = gsonPretty.toJson(obj);
		
		// сохранение области видимости полей
		excludeFieldModifiers(..)
		// ручные восстановление и загрузка объектов
		registerTypeAdapter(..)
		// настройка формата времени
		disableInnerClassSerialization()
		
		 */
	}
}
