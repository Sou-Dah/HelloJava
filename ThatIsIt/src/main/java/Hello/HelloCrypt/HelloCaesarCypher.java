package Hello.HelloCrypt;

public class HelloCaesarCypher {
	public static void main(String[] args) {
		
		//	65 90 97 122
		//	Расшифровка только букв
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
		
		int key = 'g' - 't';
		System.out.println("key = " + key);
	}
}
