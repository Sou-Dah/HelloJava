package WhatIsIt;

public class Pro {
	public static boolean pro = true;
	public static void pp () {
		if (pro) System.out.print("\t");
	}
	public static void pl () {
		if (pro) System.out.print("\t\n");
	}
	public static void pp (Object ob) {
		if (pro) System.out.print("\t"+ob);
	}
	public static void pl (Object ob) {
		if (pro) System.out.print("\t"+ob+"\n");
	}
	
}
