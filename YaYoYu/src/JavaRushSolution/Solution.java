package JavaRushSolution;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Алгоритмы-числа

370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8
*/

public class Solution {
	
	public static long[] getNumbers(long N) {
		return getNumbers(1, N);
	}
	
	public static long[] getNumbers(int startFrom, long N) {
		ArrayList<Long> resultList = new ArrayList<Long>();
		long number = N;
		
		for (long iNumber = startFrom; iNumber < number; iNumber++) {
			
			int inLength = ("" + iNumber).length();
			System.out.printf("\n%d-%d, ", iNumber, inLength);
			
			long sum = 0;
			String siNumber = "" + iNumber;
			for (int rank = 0; rank < siNumber.length(); rank++) {
				int digit = Integer.parseInt("" + siNumber.charAt(rank));
				System.out.printf("%d.%d.%d ", digit, siNumber.length(), digit * digit * digit);
				sum += Math.pow(digit, siNumber.length());
				
			}
			if ( iNumber == sum ) {
				resultList.add(iNumber);
				System.out.printf("adding %d\n", iNumber);
			}
			
		}
		
		long[] result = new long[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			result[i] = (long) resultList.get(i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getNumbers(365, 375)));
//		System.out.println(Arrays.toString(getNumbers(20)));
//		long a = System.currentTimeMillis();
//		System.out.println(Arrays.toString(getNumbers(1000)));
//		long b = System.currentTimeMillis();
//		System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
//		System.out.println("time = " + (b - a) / 1000);
//		
//		a = System.currentTimeMillis();
//		System.out.println(Arrays.toString(getNumbers(1000000)));
//		b = System.currentTimeMillis();
//		System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
//		System.out.println("time = " + (b - a) / 1000);
	}
}
