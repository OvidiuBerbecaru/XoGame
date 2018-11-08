package XoGame;

public class Board {
	private final int boardColumns = 3;
	private final int boardRows = 3;
	private Cell boardArray[][] = new Cell[boardColumns][boardRows];
	
	public Board() {
		for(int i = 0 ; i < boardRows; i++) {
			for(int j = 0 ; j < boardColumns ; j++) {
				Piece piece = new Piece(PieceType.SPACE);
				boardArray[i][j] = new Cell(i * 10 + j);
				boardArray[i][j].setPiece(piece);
			}	
		}
	}
	
	public int getBoardColumns() {
		return boardColumns;
	}
	
	public int getBoardRows() {
		return boardRows;
	}
	
	public void displayBoard() {
		System.out.println(" -------------");
		for(int i = 0 ; i < boardRows ; i++) {
			System.out.print(" | ");
			for(int j = 0 ; j < boardColumns ; j++) {
				System.out.print(boardArray[i][j].getPiece().getType().getAbbreviation());
				System.out.print(" | ");
			}
		System.out.println();
		System.out.println(" -------------");
		}
	}
	
	public Cell[][] getBoardArray() {
		return boardArray;
	}
	
	public Cell getCell(int row, int column) {
		return boardArray[row][column];
	}

}
