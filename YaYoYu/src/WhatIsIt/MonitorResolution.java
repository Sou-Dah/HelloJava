package WhatIsIt;

public class MonitorResolution {
	public static void main(String[] args) {
		
		// Соотношение сторон и пиксели
		int ares = 16, bres = 9, res1920 = 1920, res2560 = 2560, res3840 = 3840;
		
		// Ширина, высота, диагональ сначала в сантиметрах, дальше — в дюймах
		double a = 52, b, c, d = 2.54, ad, bd, cd, cd24 = 23.5, cd27 = 27;
	
		// Ширина, высота, диагональ в дюймах округлённые
		double adr, bdr, cdr;
		String c0 = "%n%24s%12s";
		String c1 = "%n%12s";
		String cp = "%7s%5.0f";
		String cs = "%7s%5s";
		
		System.out.printf("%24s%12s", "24\"", "27\"");
		b = a * bres / ares;
		c = Math.sqrt(a * a + b * b);
		System.out.printf(c1+cp+cp, "Сантиметры", "a =", a, "a =", d*Math.sqrt(27*27-196));
		System.out.printf(c1+cp+cp,           "", "b =", b, "b =", d*Math.sqrt(27*27-81));
		System.out.printf(c1+cp+cp,           "", "c =", c, "c =", d*cd27);
		System.out.printf("\n");
		
		System.out.printf(c0, "24\"", "27\"");
		ad = a / d;
		bd = b / d;
		cd = c / d;
		System.out.printf(c1+cp+cp, "Дюймы", "ad =", ad, "ad =", Math.sqrt(27*27-196)); 
		System.out.printf(c1+cp+cp,      "", "bd =", bd, "bd =", Math.sqrt(27*27-81)); 
		System.out.printf(c1+cp+cp,      "", "cd =", cd, "cd =", cd27);
		System.out.printf("\n");
		
		System.out.printf(c0, "24\"", "27\"");
		System.out.printf(c1+cs+cs, "Разрешение", res1920, res1920/16*9, res1920, res1920/16*9);
		System.out.printf(c1+cp+cp,  "Плотность", "dpd =", res1920 / ad, "dpd =", res1920/Math.sqrt(27*27-196));
		System.out.printf("\n");
		
		System.out.printf(c0, "24\"", "27\"");
		System.out.printf(c1+cs+cs, "Разрешение", res2560, res2560/16*9, res2560, res2560/16*9);
		System.out.printf(c1+cp+cp,  "Плотность", "dpd =", res2560 / ad, "dpd =",
		                  res2560/Math.sqrt(27*27-196));
		System.out.printf("\n");
		
		System.out.printf(c0, "24\"", "27\"");
		System.out.printf(c1+cs+cs, "Разрешение", res3840, res3840/16*9, res3840, res3840/16*9);
		System.out.printf(c1+cp+cp,  "Плотность", "dpd =", res3840 / ad, "dpd =", res3840/Math.sqrt(27*27-196));
		System.out.printf("\n");
		
		
		
	}
	
}










