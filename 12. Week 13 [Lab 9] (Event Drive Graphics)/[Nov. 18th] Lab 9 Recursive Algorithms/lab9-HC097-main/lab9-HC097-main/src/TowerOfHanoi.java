import java.util.Deque;
import java.util.Iterator;

/**
 * A class that represents a game of Tower of Hanoi.
 */
public class TowerOfHanoi {
	
	/**
	 * Returns a string representation of a Deque of integers in the reverse 
	 * order of its toString method.
	 * 
	 * @param deque a Deque of integers
	 * @return a string representation of the Deque
	 */
	private static String reverseToString(Deque<Integer> deque) {
		if (deque.isEmpty()) {
			return "[]";
		}
		Iterator<Integer> iterator = deque.descendingIterator();
		StringBuilder sb = new StringBuilder("[" + iterator.next());
		while (iterator.hasNext()) {
			sb.append(", ");
			sb.append(iterator.next());
		}
		sb.append("]");
		return sb.toString();
	}
}
