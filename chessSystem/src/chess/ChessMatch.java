package chess;
import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	//a match needs a board
	private Board board;
	
	//it's the class ChessMatch that has to know the size of the board
	public ChessMatch() {
		board = new Board(8,8);
		initialSetup();
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
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		 board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		
		//board.placePiece(new Rook(board, Color.WHITE), new Position(2,1));
		placeNewPiece('b', 6 , new Rook(board, Color.WHITE));
		placeNewPiece('e', 8 , new Rook(board, Color.BLACK));
		placeNewPiece('e', 1 , new Rook(board, Color.WHITE));
		
	}
	
}
