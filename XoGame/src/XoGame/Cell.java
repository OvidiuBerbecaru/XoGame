package XoGame;

public class Cell {
	private int number;
	private Piece piece;
	
	public Cell() {
		piece = null;
	}

	public Cell(int number) {
		this.number = number;
	}
	
	public void setNumber(int cellNumber) {
		number = cellNumber;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public Piece getPiece() {
		return piece;
	}
}
