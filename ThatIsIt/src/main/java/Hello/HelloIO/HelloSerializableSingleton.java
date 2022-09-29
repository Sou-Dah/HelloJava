package Hello.HelloIO;

import java.io.*;

public class HelloSerializableSingleton implements Serializable {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Singleton instance = Singleton.getInstance();
		
		ByteArrayOutputStream byteArrayOutputStream = serializeSingletonInstance(instance);
		
		Singleton singleton = deserializeSingletonInstance(byteArrayOutputStream);
		Singleton singleton1 = deserializeSingletonInstance(byteArrayOutputStream);
		
		System.out.println("Проверка ourInstance : " + singleton.getInstance());
		System.out.println("Проверка ourInstance : " + singleton1.getInstance());
		System.out.println("=========================================================");
		System.out.println("Проверка singleton : " + singleton);
		System.out.println("Проверка singleton1 : " + singleton1);
	}
	
	public static ByteArrayOutputStream serializeSingletonInstance(Singleton instance) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
		oos.writeObject(instance);
		oos.close();
		
		return byteArrayOutputStream;
	}
	
	public static Singleton deserializeSingletonInstance(ByteArrayOutputStream byteArrayOutputStream) throws IOException, ClassNotFoundException {
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		
		ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
		Singleton singleton = (Singleton) ois.readObject();
		ois.close();
		
		return singleton;
	}
	
	public static class Singleton implements Serializable {
		private static Singleton ourInstance;
		
		public static Singleton getInstance() {
			if (ourInstance == null) {
				ourInstance = new Singleton();
			}
			return ourInstance;
		}
		
		private Singleton() {
		}
		
		//	 Этот метод будет вызван после загрузки любого объекта этого класса и позволяет заменить его другим.
		//	Назначение этого метода – возвращать замещающий объект вместо объекта, на котором он вызван.
		//	Вызывается на десериализованном объекте.
		
		//	Существует и обратный метод – writeReplace, который, как вы, наверное, уже догадались, позволяет выдать 
		//	замещающий объект вместо текущего, для сериализации. Мне, честно сказать, трудно представить себе 
		//	ситуации, в которых это может понадобиться. Хотя в недрах кода Sun он как-то используется.
		//
		//	Оба метода, как readResolve, так и writeReplace, вызываются при использовании стандартных средств 
		//	сериализации (методов readObject и writeObject), вне зависимости от того, объявлен ли сериализуемый класс
		//	как Serializable или Externalizable.
		private Object readResolve() {
			return ourInstance;
		}
		
		
	}
}
