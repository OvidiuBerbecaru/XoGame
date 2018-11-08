package XoGame;

public enum PieceType {
	X("x"), ZERO("0"), SPACE(" ");
	
	private String abbreviation;
	
	public String getAbbreviation() {
		return this.abbreviation;
	}
	
	PieceType(String abbreviation) {
	    this.abbreviation = abbreviation;
	}
}
