package Hello.HelloIO;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;

//	простейший перечислимый тип. Всего два значения – Answer.YES и Answer.NO
public class HelloSerializableSingletonAnswer {
	
	public static class Answer implements Serializable {
		
		private static final String STR_YES = "Yes";
		private static final String STR_NO = "No";
		
		public static final Answer YES = new Answer(STR_YES);
		public static final Answer NO = new Answer(STR_NO);
		
		private String answer = null;
		
		private Answer(String answer){
			this.answer = answer;
		}
		
		//	Назначение этого метода – возвращать замещающий объект вместо объекта, на котором он вызван.
		//	Вызывается на десериализованном объекте.
		
		//	Существует и обратный метод – writeReplace, который, как вы, наверное, уже догадались, позволяет выдать 
		//	замещающий объект вместо текущего, для сериализации. Мне, честно сказать, трудно представить себе 
		//	ситуации, в которых это может понадобиться. Хотя в недрах кода Sun он как-то используется.
		//
		//	Оба метода, как readResolve, так и writeReplace, вызываются при использовании стандартных средств 
		//	сериализации (методов readObject и writeObject), вне зависимости от того, объявлен ли сериализуемый класс
		//	как Serializable или Externalizable.
		private Object readResolve() throws ObjectStreamException {
			if (STR_YES.equals(answer))
				return YES;
			if (STR_NO.equals(answer))
				return NO;
			throw new InvalidObjectException("Unknown value: " + answer);
		}
	}
	
}
