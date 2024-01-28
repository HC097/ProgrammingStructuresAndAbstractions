import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Move;
import model.Peg;
import model.TowerOfHanoi;
import model.exceptions.IllegalMoveException;

class SolveTowerTest {

	@Test
	void testEdgeAndBaseCases() {
		// Edge cases
		assertThrows(IllegalArgumentException.class, 
				() -> TowerOfHanoi.solveTower(0, Peg.LEFT, Peg.MIDDLE));
		assertThrows(IllegalArgumentException.class, 
				() -> TowerOfHanoi.solveTower(-1, Peg.LEFT, Peg.RIGHT));
		
		List<Move> moves = Arrays.asList();
		assertEquals(moves, TowerOfHanoi.solveTower(1, Peg.LEFT, Peg.LEFT));
		assertEquals(moves, TowerOfHanoi.solveTower(4, Peg.MIDDLE, Peg.MIDDLE));
		assertEquals(moves, TowerOfHanoi.solveTower(64, Peg.RIGHT, Peg.RIGHT));
		
		// Base case
		moves = Arrays.asList(Move.LEFT_TO_MIDDLE);
		assertEquals(moves, TowerOfHanoi.solveTower(1, Peg.LEFT, Peg.MIDDLE));
		moves = Arrays.asList(Move.LEFT_TO_RIGHT);
		assertEquals(moves, TowerOfHanoi.solveTower(1, Peg.LEFT, Peg.RIGHT));
		moves = Arrays.asList(Move.MIDDLE_TO_LEFT);
		assertEquals(moves, TowerOfHanoi.solveTower(1, Peg.MIDDLE, Peg.LEFT));
		moves = Arrays.asList(Move.MIDDLE_TO_RIGHT);
		assertEquals(moves, TowerOfHanoi.solveTower(1, Peg.MIDDLE, Peg.RIGHT));
		moves = Arrays.asList(Move.RIGHT_TO_LEFT);
		assertEquals(moves, TowerOfHanoi.solveTower(1, Peg.RIGHT, Peg.LEFT));
		moves = Arrays.asList(Move.RIGHT_TO_MIDDLE);
		assertEquals(moves, TowerOfHanoi.solveTower(1, Peg.RIGHT, Peg.MIDDLE));
	}

	@Test
	void testRecursiveCase() throws IllegalMoveException {		
		// 2 disks
		List<Move> moves = Arrays.asList(
				Move.LEFT_TO_RIGHT, 
				Move.LEFT_TO_MIDDLE, 
				Move.RIGHT_TO_MIDDLE);
		assertEquals(moves, TowerOfHanoi.solveTower(2, Peg.LEFT, Peg.MIDDLE));
		
		moves = Arrays.asList(
				Move.LEFT_TO_MIDDLE, 
				Move.LEFT_TO_RIGHT, 
				Move.MIDDLE_TO_RIGHT);
		assertEquals(moves, TowerOfHanoi.solveTower(2, Peg.LEFT, Peg.RIGHT));
		
		moves = Arrays.asList(
				Move.MIDDLE_TO_RIGHT, 
				Move.MIDDLE_TO_LEFT, 
				Move.RIGHT_TO_LEFT);
		assertEquals(moves, TowerOfHanoi.solveTower(2, Peg.MIDDLE, Peg.LEFT));
		
		moves = Arrays.asList(
				Move.MIDDLE_TO_LEFT, 
				Move.MIDDLE_TO_RIGHT, 
				Move.LEFT_TO_RIGHT);
		assertEquals(moves, TowerOfHanoi.solveTower(2, Peg.MIDDLE, Peg.RIGHT));
		
		moves = Arrays.asList(
				Move.RIGHT_TO_MIDDLE, 
				Move.RIGHT_TO_LEFT, 
				Move.MIDDLE_TO_LEFT);
		assertEquals(moves, TowerOfHanoi.solveTower(2, Peg.RIGHT, Peg.LEFT));
		
		moves = Arrays.asList(
				Move.RIGHT_TO_LEFT, 
				Move.RIGHT_TO_MIDDLE, 
				Move.LEFT_TO_MIDDLE);
		assertEquals(moves, TowerOfHanoi.solveTower(2, Peg.RIGHT, Peg.MIDDLE));
		
		// 3 disks
		moves = Arrays.asList(
				Move.LEFT_TO_RIGHT,   // 2 disks from LEFT to MIDDLE
				Move.LEFT_TO_MIDDLE, 
				Move.RIGHT_TO_MIDDLE,
				Move.LEFT_TO_RIGHT,   // 1 disk from LEFT to RIGHT
				Move.MIDDLE_TO_LEFT,  // 2 disks from MIDDLE to RIGHT
				Move.MIDDLE_TO_RIGHT, 
				Move.LEFT_TO_RIGHT);
		assertEquals(moves, TowerOfHanoi.solveTower(3, Peg.LEFT, Peg.RIGHT));
		
		TowerOfHanoi game = new TowerOfHanoi(3, Peg.LEFT);
		String string = "  LEFT: [3, 2, 1]\nMIDDLE: []\n RIGHT: []";
		assertEquals(string, game.toString());
		for (Move move : moves) {
			game.moveDisk(move);
		}
		string = "  LEFT: []\nMIDDLE: []\n RIGHT: [3, 2, 1]";
		assertEquals(string, game.toString());
		
		moves = Arrays.asList(
				Move.RIGHT_TO_MIDDLE,  // 2 disks from RIGHT to LEFT
				Move.RIGHT_TO_LEFT, 
				Move.MIDDLE_TO_LEFT,
				Move.RIGHT_TO_MIDDLE,  // 1 disk from RIGHT to MIDDLE
				Move.LEFT_TO_RIGHT,    // 2 disks from LEFT to MIDDLE
				Move.LEFT_TO_MIDDLE, 
				Move.RIGHT_TO_MIDDLE);
		assertEquals(moves, TowerOfHanoi.solveTower(3, Peg.RIGHT, Peg.MIDDLE));
		
		game = new TowerOfHanoi(3, Peg.RIGHT);
		string = "  LEFT: []\nMIDDLE: []\n RIGHT: [3, 2, 1]";
		assertEquals(string, game.toString());
		for (Move move : moves) {
			game.moveDisk(move);
		}
		string = "  LEFT: []\nMIDDLE: [3, 2, 1]\n RIGHT: []";
		assertEquals(string, game.toString());
	}
}
