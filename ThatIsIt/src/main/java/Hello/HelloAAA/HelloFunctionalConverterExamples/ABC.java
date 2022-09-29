package Hello.HelloAAA.HelloFunctionalConverterExamples;

import Hello.HelloAAA.HelloFunctionalConverter;

public class ABC {
	public static void main(String[] args) {
		Dog dog = new Dog("Bobbie", 5, 3);
		
		HelloFunctionalConverter<Dog, Raccon> converter = x -> new Raccon(x.name, x.age, x.weight);
		
		Raccon raccon = converter.convert( dog );
		
		System.out.println("raccon.name = " + raccon.name);
		System.out.println("raccon.age = " + raccon.age);
		System.out.println("raccon.weight = " + raccon.weight);
	}
}
