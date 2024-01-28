/*
public class ReverseArray{	
	public static void main(String[] args) { 
		
		int [] arr = {10, 20, 3000, 40, 50, 83}; 
		int [] b = new int [arr.length]; 
		int j = arr.length;
		
		// loop
		for (int i = 0; i < arr.length; i++) { 
			b[j - 1] = arr[i]; 
		    j = j - 1; 
		} 
		
		// print the reversed array
		System.out.println("Reversed array is: \n"); 
		for (int k = 0; k < arr.length; k++) { 
			    System.out.println(b[k]); 
		} 
	} 
}
*/
/*
public class ReverseArray{	
	public static void main(String[] args) { 
		
		int [] arr ={10, 20, 3000, 40, 50}; 
		reverse(arr, arr.length); 
		int [] arr2 ={10, 20, 3000, 40, 50, 56, 656}; 		
		reverse(arr2, arr2.length);
	} 
	
	// method to reverse array
	static void reverse(int a[], int n) {
		
		int[] b = new int[n]; 
		int j = n; 
		
		// loop
		for (int i = 0; i < n; i++) { 
		    b[j - 1] = a[i]; 
		    j = j - 1; 
		} 
		
		// print the reversed array
		System.out.println("Reversed array is: \n"); 
		for (int k = 0; k < n; k++) { 
			    System.out.println(b[k]); 
		} 
	} 
}
*/



public class ReverseArray{	
	public static void main(String[] args) { 
		
		int [] arr ={10, 20, 3000, 40, 50}; 
		int [] revarr = reverse(arr, arr.length);
		
		System.out.println("From main");
		// print the reversed array
		System.out.println("Reversed array is: \n"); 
		for (int k = 0; k < revarr.length; k++) { 
			    System.out.println(revarr[k]); 
		} 
	} 
	
	// method to reverse array
	static int[] reverse(int a[], int n) {
		
		int[] b = new int[n]; 
		int j = n; 
		
		// loop
		for (int i = 0; i < n; i++) { 
		    b[j - 1] = a[i]; 
		    j = j - 1; 
		} 
		
		System.out.println("From reverse");

		// print the reversed array
		System.out.println("Reversed array is: \n"); 
		for (int k = 0; k < n; k++) { 
			    System.out.println(b[k]); 
		} 
		
		return b;
	}
}
