
public class Lab1 {
	
	// TODO: Implement the methods that are tested in Lab1test.java
	public static void main (String [] args) {
		
	}

	//This method gets the sum of two numbers.
	public static double sum (double x, double y) {
		
		return x + y;
	}
	
	//This method casts doubles to ints
	public static int castToInt (double x) {
		
		return (int) x;
		
	}
	
	//This method puts (***) emphasis on the words given
	public static String emphasize (String x) {
		
		return "***" + x + "***";
		
	}
	
	//This method tests whether a number is odd
	public static boolean isOdd (int z) {
		
		boolean b = true;
		
		if(z%2 == 0) {
			b = false;
		}else {
			b = true;
		}
			
		
		
		return b;
	}
	
	//This method gets 3 ints and finds out which one is the largest of them.
	public static int findMax (int a, int b, int c) {
		
		if(a > b && a > c) {
			return a;
		}else if(b > a && b > c) {
			return b;
		}else {
			return c;
		}
		
		
	}
	
	//This method takes an array and adds up all of the separate elements in the indices.
	public static int sum (int[] x) {
		
		int sum = 0;
		for(int i = 0; i < x.length; i++) {
			sum += x[i];
		}
		
		return sum;
		
	}
	
	//This method takes an array, gets the sum of the elements, and and adds up the odd elements.
	public static int sumOdd ( int[] z) {
		
		int sum = 0;
		for(int k = 0; k < z.length; k++) {
			if(z[k] % 2 != 0) {
				sum = sum + z[k];
			}
		}
		
		
		return sum;
	}
	
	//This method takes an array and finds the largest number within in.
	public static int findMax (int[] y) {
		
		int max = 0;
		for(int j = 0; j < y.length; j++) {
			if(y[j] > max) {
				max = y[j];
			}
		}
		
		return max;
		
	}
	 
}
