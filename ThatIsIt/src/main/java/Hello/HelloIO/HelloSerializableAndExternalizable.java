package Hello.HelloIO;

import java.io.*;

/*
implements Serializable - для автоматического сохранения и восстановления всего и вся
Записываюся и читаются  последовательно: данные класса, данные родителя, поля родителей, поля класса.
	private static final long serialVersionUID = 1L; - если набор полей и их порядок определён, а методы могут меняться
		Некоторые предпочитают ставить его равным дате изменения кода.
		В версии 5.0 в документации появилось приблизительно следующее: крайне рекомендуется всем сериализуемым 
		классам декларировать это поле в явном виде, ибо вычисление по умолчанию очень чувствительно к деталям 
		структуры класса, которые могут различаться в зависимости от реализации компилятора, и вызывать таким образом 
		неожиданные InvalidClassException при десериализации. Объявлять это поле лучше как private, т.к. оно 
		относится исключительно к классу, в котором объявляется. Хотя в спецификации модификатор не оговорен.
	static поле - не сохраняется и не восстанавливается;
	final поле - сохраняется и восстанавливется;
	transient - модификатор переменных для пропуска;
	private void writeObject(ObjectOutputStream out) throws IOException
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	private Object readResolve() throws ObjectStreamException
	private Object writeReplace() throws ObjectStreamException
	
	При сохранении
	Класс разбирается как набор полей через отражения и пишется в выходной поток.
		родитель.конструктор() {} - вызывается и должен быть, иначе ошибка (исключение)
		конструктор() {} - не вызывается
	При восстановлении
	Поди объект выделяется память, поля его заполняются из потока.
		конструктор() {} - не вызывается
	
	При наследовании
		Никаких дополнительных действий предпринимать не надо, сериализация будет распространяться и на дочерний класс.
	
implements Externalizable - для ручного, требует конструктор по умолчанию и переопределения 2 методов:
	static поле - можно сохранить, но крайне не рекомендуеся, ибо приводит к трудноуловимым ошибкам
	final поле - сохраняется, но невозможно измеить в readExternal после первичного заполнения;
	public void writeExternal (ObjectOutput out) throws IOException
	public void readExternal (ObjectInput in) throws IOException, ClassNotFoundException
	public конструктор() {}
	private Object readResolve() throws ObjectStreamException
	private Object writeReplace() throws ObjectStreamException
	
	При сохранении
		конструктор() {} - вызывается и должен быть, иначе ошибка (исключение), потом метод readExternal()
			Dсе наследники такого класса тоже будут считаться реализующими интерфейс Externalizable, у них тоже должен 
			быть конструктор без параметров!
	
	При наследовании
		Необходимо переопределить методы родительского класса readExternal и writeExternal, иначе поля дочернего 
		класса сериализованы не будут. 
		В этом случае надо бы не забыть вызвать родительские методы, иначе не сериализованы будут уже родительские поля.

Безопасность данных
	Правило 1. После десериализации объекта необходимо проверить его внутреннее состояние (инварианты) на 
	правильность, точно так же, как и при создании с помощью конструктора. Если объект не прошел такую проверку, 
	необходимо инициировать исключение java.io.InvalidObjectException
	
	Правило 2. Если в составе класса A присутствуют объекты, которые не должны быть доступными для изменения извне, 
	то при десериализации экземпляра класса A необходимо вместо этих объектов создать и сохранить их копии.
 */

/**
 * Переопределяем сериализацию.
 * Для этого необходимо объявить методы:
 * private void writeObject(ObjectOutputStream out) throws IOException
 * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
 * Теперь сериализация/десериализация пойдет по нашему сценарию :)
 */
public class HelloSerializableAndExternalizable {
	
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		
		
	}
	
	static class Dog implements Serializable {
		public static final String typeAnimal = "dog";
		public String name;
		public int age;
		public int weight;
		
		transient public InputStream in = System.in;
		
		private void writeObject(ObjectOutputStream out) throws IOException {
			out.defaultWriteObject();
		}
		
		private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
			in.defaultReadObject();
		}
	}
	
	static class Cat implements Externalizable {
		public static final String typeAnimal = "cat";
		public String name;
		public int age;
		public int weight;
		
		transient public InputStream in = System.in;
		
		public void writeExternal(ObjectOutput out) throws IOException {
			out.writeObject(name);
			out.writeInt(age);
			out.writeInt(weight);
		}
		
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			name = (String) in.readObject();
			age = in.readInt();
			weight = in.readInt();
		}
	}
	
}
