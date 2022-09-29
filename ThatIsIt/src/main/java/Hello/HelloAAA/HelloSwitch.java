package Hello.HelloAAA;

import java.util.ArrayList;
import java.util.List;

public class HelloSwitch {
	public static void main(String[] args) {
		System.out.println(getPlanetAtmosphere(3));
	}
	
	public static List<String> getPlanetAtmosphere(int seqNumberFromSun) {
		List<String> result = new ArrayList<>();
		switch (seqNumberFromSun) {
			case 1: result.add("Нет атмосферы");
				break;
			case 2:
			case 4: result.add("Углекислый газ");
				break;
			case 3: result.add("Углекислый газ");
				result.add("Азот");
				result.add("Кислород");
				break;
			case 5:
			case 6: result.add("Водород");
				result.add("Гелий");
				break;
			case 7:
			case 8: result.add("Метан");
				result.add("Водород");
				result.add("Гелий");
				break;
			default:
				break;
		}
		return result;
	}
}
