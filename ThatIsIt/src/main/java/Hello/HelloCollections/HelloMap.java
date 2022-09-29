package Hello.HelloCollections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*
Map		HashMap		
Map		TreeMap		
Map		SortedMap	
Map		HashTable
 */
public class HelloMap {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("first", "Mama");
		map.put("second", "Mila");
		map.put("third", "Ramu");
		
		// Добавление всех пар из одного словаря в другой
		// map1.putAll(map2);
		
		Iterator < Map.Entry<String, String> > iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> pair = iterator.next();
			String key = pair.getKey();            //ключ
			String value = pair.getValue();        //значение
			System.out.println(key + ":" + value);
		}
		
		// Набор пар ключ : значение
		for (Map.Entry<String, String> pair : map.entrySet()) {
			String key = pair.getKey();                      //ключ
			String value = pair.getValue();                  //значение
			System.out.println(key + ":" + value);
		}
		
		// Набор ключей
		for (String s : map.keySet()) {
			System.out.println(s);
		}
		
		// Набор значений
		for (String s : map.values()) {
			System.out.println(s);
		}
	}
}

