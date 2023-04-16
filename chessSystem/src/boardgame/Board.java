package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece [][] pieces;
	
	public Board(int rows, int columns) {
		if (rows <1 || columns <1) {
			throw new BoardException("erro creating board: there's gotta be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	//cannot alter rows
	/*
	 * public void setRows(int rows) { this.rows = rows; }
	 */

	public int getColumns() {
		return columns;
	}
	
	
	
	
	//cannot alter columns
	/*
	 * public void setColumns(int columns) { this.columns = columns; }
	 */
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		
		return pieces[row][column];
	}
	
	//sobrecarga
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//place a piece on the board
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Theres already a piece on position" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int row, int column) {
		return row >=0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean  positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		//this method "piece" returns the piece that is in the position
		return piece(position) !=null;
	}

}
