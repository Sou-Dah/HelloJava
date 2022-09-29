package WhatIsIt;

public class Calc {
	public int add (int a, int b) {
		return a+b;
	}
	
	public double div (int a, int b) {
		if (b == 0) throw new IllegalArgumentException();
		return a/b;
	}
}
