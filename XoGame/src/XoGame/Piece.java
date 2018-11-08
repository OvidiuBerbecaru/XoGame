package XoGame;

public class Piece {
	private PieceType pieceType;
	
	public Piece() {}
	
	public Piece(PieceType pieceType) {
		this.pieceType = pieceType;
	}
	
	public void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}
	
	public PieceType getType() {
		return pieceType;
	}
}
