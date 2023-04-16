package chess;
import boardgame.Board;

public class ChessMatch {
	
	//a match needs a board
	private Board board;
	
	//it's the class ChessMatch that has to know the size of the board
	public ChessMatch() {
		board = new Board(8,8);
	}
	
	//returns a matrix that corresponds to the match
	public ChessPiece[][] getPieces(){
		ChessPiece [][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows(); i++) {
			for(int j=0; j<board.getColumns(); j++){
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
}