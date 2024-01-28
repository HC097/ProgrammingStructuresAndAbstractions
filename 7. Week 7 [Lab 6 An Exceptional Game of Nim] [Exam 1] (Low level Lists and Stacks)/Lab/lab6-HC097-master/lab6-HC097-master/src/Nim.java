
public class Nim {

	private Player currentPlayer;
	private Player waitingPlayer;
	private Piles piles;
	private Player winner = null;
	private Player loser = null;
	
	public Nim(Player p1, Player p2) throws InvalidInitPilesException {
		this(p1, p2, new int[] {3, 4, 5});
	}
	
	public Nim(Player p1, Player p2, int[] initSizes) throws 
	InvalidInitPilesException {
		currentPlayer = p1;
		waitingPlayer = p2;
		piles = new Piles(initSizes);
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public Player getWaitingPlayer() {
		return waitingPlayer;
	}
	
	public int[] getPileSizes() {
		return piles.getSizes();
	}
	
	public Player getWinner() {
		return winner;
	}
	
	public Player getLoser() {
		return loser;
	}
	
	public void takeTurn() {		
		// TODO: Implement this method.
	}
	
	public void checkGameOver() {
		if (piles.isEmpty()) {
			winner = waitingPlayer;
			loser = currentPlayer;
		}
	}
	
	public void swapPlayers() {
		Player temp = currentPlayer;
		currentPlayer = waitingPlayer;
		waitingPlayer = temp;
	}
	
	public void play() {
		while (winner == null || loser == null) {
			takeTurn();
			checkGameOver();
			swapPlayers();
		}
		winner.notifyWin();
		loser.notifyLose();
	}
}
