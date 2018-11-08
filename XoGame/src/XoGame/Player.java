package XoGame;

import java.util.ArrayList;

public class Player {
	private String name;
	private ArrayList<Piece> pieceArray = new ArrayList<Piece>();
	
	public Player() {}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Piece> getPieceArray() {
		return pieceArray;
	}
	
	public Piece getPieceArray(int index) {
		return pieceArray.get(index);
	}
	
	public void addPiece(Piece piece) {
		pieceArray.add(piece);
	}
	
}
