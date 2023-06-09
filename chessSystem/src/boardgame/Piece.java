package boardgame;

public abstract class Piece {
	//this is a simple position in a matrix, it's not the game position
	//I don't want this to visible in the chess layer
	//this piece knows where it is, I need an association Piece with Board
	//the same way the Board with be associated with Pieces
	protected Position position;
	private Board board;
	
	//initial position, when creating, will be null, it will not be
	//put on board first, at the beginning, that's why there are no getter
	// and setters for position attribute
	public Piece(Board board) {
		this.board = board;
		 
	}

	//only classes and subclasses in the same pack will be able to access the board
	//board cannot be accessed by the chess layer
	protected Board getBoard() {
		return board;
	}

	//I don't allow to change my board
	//public void setBoard(Board board) {
		//this.board = board;
	//}
	
	public abstract boolean[][] possibleMoves();
	
	//hook method - concrete method that calls abstract method
	public boolean possibleMove(Position position) {
		
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][]mat = possibleMoves();
		for (int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length ; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	

}
