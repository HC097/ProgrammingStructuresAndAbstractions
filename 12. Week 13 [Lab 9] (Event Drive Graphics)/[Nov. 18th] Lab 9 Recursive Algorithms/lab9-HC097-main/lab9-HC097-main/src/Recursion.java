import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Recursion {

	/**
	 * Returns the nth term in the Fibonacci sequence.
	 * 
	 * @param n the term index
	 * @return the nth Fibonacci number
	 * @throws IllegalArgumentException if n is less than 0
	 */
	public static int fibonacci(int n) {
		
		if(n < 0) {
			throw new IllegalArgumentException("");
		}
		
		if(n == 0 || n == 1) {
			return n;
		}else {
			//System.out.println(fibonacci(n-1) + fibonacci(n-2));
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
		  
		//return 0;
	}
	
	/**
	 * Returns the nth term in the Fibonacci sequence using a map to memorize 
	 * the method. If the term is stored in the map, its value is returned. 
	 * Otherwise, the term is calculated and added to the map before returning 
	 * it.
	 * 
	 * @param n the term index
	 * @param cache the map used to memorize the method
	 * @return the nth Fibonacci number
	 * @throws IllegalArgumentException if n is less than 0
	 */
	public static int fibonacci(int n, Map<Integer, Integer> cache) {
		
		int term0 = 0;
		int term1 = 1;
		
		int changingTerm = 0;
		int sum = 0;//Didn't really need the sum: it wanted the term;
		
		if(n < 0) {
			throw new IllegalArgumentException("index less than zero");
		}
		
		if(cache.isEmpty()) {
			for(int i = 0; i < n; i++) {
				
				if(n == 0) {
					sum = term0;
					cache.put(0, term0);
				}else {
					sum = term0 + term1;
					
					changingTerm = term0 + term1;
					term0 = term1;
					term1 = changingTerm;
					
					cache.put(i, term0);
				}	
			}
		}
		  
		cache.put(n , 0);
		
		//System.out.println(term0);
		return term0;
	}
	
	/**
	 * Searches a sorted list of strings using binary search. Returns a list of 
	 * the indices of the strings checked during the search in the order they 
	 * are checked. If the target string is not found, the last element of the 
	 * returned list is -1. Otherwise, the last element is the index of the 
	 * target.
	 * 
	 * @param words the list to be searched
	 * @param target the string to be searched for
	 * @param fromIdx the index of the first string in the range of strings to 
	 *        be searched (inclusive)
	 * @param toIdx the index of the last string in the range of strings to be 
	 *        searched (inclusive)
	 * @return a list of the indices of the strings checked during the search.
	 *         The last element is -1 if the target is not found.
	 */
	public static List<Integer> binarySearch(List<String> words, String target, 
			int fromIdx, int toIdx) {
		
		
		
		
			List<Integer> indices = new ArrayList<Integer>();
			int midIdx;
			
			
			//Present at middle
			System.out.println(0);
			if(fromIdx > toIdx) {
				
				indices.add(-1);
				//return indices;
			}else{
				
				midIdx = (fromIdx + toIdx) / 2;
				
				if(words.get(midIdx) ==  target) {	
					
					indices.add(midIdx);
					//return indices;
					
				}else if(words.indexOf(target) > midIdx) {
					toIdx = midIdx - 1;
					binarySearch(words, target, fromIdx, toIdx);
				}else{
					fromIdx = midIdx + 1;
					binarySearch(words, target, fromIdx, toIdx);
				}
				
			}
					
				
			
				
			System.out.println(indices);
			
		
		
		return indices;
	}
	
	
	/**
	 * Returns a list of moves that solve the Tower of Hanoi puzzle. The method 
	 * assumes that the disks are initially on the given start peg and that the 
	 * puzzle is solved by moving them to the given end peg.
	 * 
	 * @param numDisks the number of disks in the puzzle
	 * @param start the start peg
	 * @param end the end peg
	 * @return a list of legal moves that transfers the disks from the start 
	 *         peg to the end peg
	 * @throws IllegalArgumentException if numDisks is less than or equal to 0
	 */
	public static List<Move> solveTower(int numDisks, Peg start, Peg end) {
		return null;
	}
	
	/**
	 * Returns a sorted list of all the unique sums that can be calculated from 
	 * subsets of the integers in a given list.
	 * 
	 * @param numbers the list of integers
	 * @return the sorted list of unique sums
	 */
	public static List<Integer> subsetSums(List<Integer> numbers) {
		return null;
	}
}
