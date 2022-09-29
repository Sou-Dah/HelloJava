import java.io.IOException;

public class ReadySteadyGo {
	public static void main(String[] args) throws IOException {
		Character ch1 = 12;
		Character ch2 = 12;
		char ch3 = 12;
		System.out.println(12);
		System.out.println("ch1 == ch2: " + (ch1 == ch2));
		System.out.println("ch1 == ch3: " + (ch1 == ch3));
		System.out.println("ch2 == ch3: " + (ch2 == ch3));
		ch1 = 200;
		ch2 = 200;
		ch3 = 200;
		System.out.println(200);
		System.out.println("ch1 == ch2: " + (ch1 == ch2));
		System.out.println("ch1 == ch3: " + (ch1 == ch3));
		System.out.println("ch2 == ch3: " + (ch2 == ch3));
		
//		while (true) {
//			int x = System.in.read();
//			System.out.println(x);
//			if (x == 43)
//				break;
//		}
		
		String s;
		for (int i1 = 0, i2 = 10, i3 = 100; i1 < 10; i1++, i2+=10, i3+=100, s = "2") {
			System.out.println(i1 + i2 + i3);
		}
		System.out.println("===============================");
		
		System.out.println("A: " + (int)'A');
		System.out.println("Z: " + (int)'Z');
		System.out.println("a: " + (int)'a');
		System.out.println("z: " + (int)'z');
		//	65 90 97 122
		String str = "uggc://jjj.lbhghor.pbz/jngpu?i=bUt5FWLEUN0";
		System.out.println(str);
		for (int i = 0, sLen = str.length(); i < sLen; i++) {
			int shift = 'g' - 't';
			char char2 = str.charAt(i);
			char char1 = char2;
			if ( Character.isLetter(char2) ) {
				char1 = (char)(char2 - shift);
				if ( !Character.isLetter(char1) )
					char1 = (char)(char2 + shift);
			}
			System.out.print(char1);
		}
		System.out.println();
		
		int a = 36, b = 400;
		System.out.println("a =    " + Integer.toBinaryString(a));
		System.out.println("b = " + Integer.toBinaryString(b));
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
	
}
