package Hello.HelloXMLserialization;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.*;

// Скопировано из D:\code\IdeaProjects\YaYoYu\src\WhatIsIt\MotherFucker.java
// Ошибка на строке 34 при запуске (создании экзэмпляра)
public class HelloXMSerialization {
	
	public static void main(String[] args) throws Exception { aaa0(args); }
	
	public static void aaa0(String[] args) throws IOException, JAXBException {
		// создание объектов Cat&Zoo для сериализации в XML
		Cat cat = new Cat();
		cat.name = "Murka";
		cat.age = 5;
		cat.weight = 4;
		

		Zoo zoo = new Zoo();
		zoo.animals.add(cat);
		zoo.animals.add(cat);
		
		// писать результат сериализации будем во Writer(StringWriter)
		StringWriter writer = new StringWriter();
		
		// создание объекта Marshaller, который выполняет сериализацию
		JAXBContext context = JAXBContext.newInstance(Cat.class, Zoo.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		// самосериализация
		marshaller.marshal(zoo, writer);
		
		// преобразовываем все записанное в StringWriter в строку
		System.out.println(writer.toString());
		
	}
	
	@XmlType(name = "zoo")
	@XmlRootElement
	static class Zoo {
		@XmlElementWrapper(name="wild-animals", nillable = true)
		public List animals = new ArrayList();
	}
	
	@XmlType(name = "tiger")
	static class Cat {
		@XmlElement(name = "catname")
		public String name;
		@XmlAttribute(name = "age")
		public int age;
		@XmlAttribute(name = "w")
		public int weight;
		
		Cat()
		{
		}
	}
	
	public static void aaa(String[] args) {
		/*
		 */
		
		
	}
	
}
