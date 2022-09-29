package Hello.HelloAAA;

import java.util.NoSuchElementException;
/*
	Optional - служебный класс для хранения в себе ссылки на любой объект, даже на нулёвый.
	
 */
public class HelloOptional<Type> {
	private final Type value;
	private HelloOptional() { this.value = null; }
	private HelloOptional(Type value) { this.value = value; }
	
	public static <Type> HelloOptional<Type> of(Type value) {
		return new HelloOptional<Type>(value);
	}
	
	public static <Type> HelloOptional<Type> ofNullavle(Type value) {
		if ( value == null )
			return new HelloOptional<Type>();
		else 
			return new HelloOptional<Type>(value);
	}
	
	public boolean isPresent() {
		return value != null;
	}
	
	public boolean isEmpy() {
		return value == null;
	}
	
	public Type get() {
		if ( value == null ) {
			throw new NoSuchElementException();
		}
		return value;
	}
	
	public Type orElse(Type other) {
		return value != null ? value : other;
	}
	
	public Type orElseThrow() {
		if ( value == null ) {
			throw new NoSuchElementException();
		}
		return value;
	}
}
