package Hello.HelloJSON;

import Skeleton.Human;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
/*
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.12.0</version>
        </dependency>
 */

public class HelloJackson {
	public static void main(String[] args) throws JsonProcessingException {
		
		Human human1 = new Human();
		human1.setName("Man");
		human1.setAge(18);
		human1.setSexIsMale(true);
		human1.setBirthday(new Date(2000, 9, 11));
		human1.setHight(1.85);
		human1.setChildren(new String[]{ "child1", "child2" });
		
		Human human2 = new Human("Woman", 
		                         18, 
		                         false, 
		                         new Date(2002, 11, 29), 
		                         1.75, 
		                         new String[]{ "child1", "child2" });
		
		ObjectMapper objectMapper = new ObjectMapper();
		String str = objectMapper.writeValueAsString(human1);
//		objectMapper.
		System.out.println(str);
		
		Human humanNew = objectMapper.readValue(str, Human.class);
		System.out.println(humanNew);
		
	}
}
