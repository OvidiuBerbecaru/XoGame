
// Joc de sah --> chess piece unicode de cautat !

package XoGame;

import java.util.Scanner;

public class Game {
	
	// The initial game build

	private Player p1 = new Player();
	private Player p2 = new Player();
	private Board board = new Board();
	private static final int playerPieceNumber = 5;
	private GameState gamestate = GameState.RUNNING;
	private int playerPieceIndex = 0;
	
	// The players type in their name
	
	public void nameSelection(Player player1, Player player2) {
		System.out.println("Player1 please type in your name : ");
		Scanner s = new Scanner(System.in);
		String answer = s.nextLine();
		player1.setName(answer);
		
		System.out.println("Player2 please type in your name : ");
		String answer2 = s.nextLine();
		player2.setName(answer2);
	}
	
	// Side picking method
	
	public void symbolSelection(int playerPieceNumber) {
		System.out.println(p1.getName() + ", please pick x or 0...");
		Scanner s = new Scanner(System.in);
		String answer = s.nextLine();
		
		if(answer.equals("x")) {
			for(int i = 0 ; i < playerPieceNumber; i++) {
				p1.addPiece(new Piece(PieceType.X));
				p2.addPiece(new Piece(PieceType.ZERO));
			}
		}
		if(answer.equals("0")) {
			for(int i = 0 ; i < playerPieceNumber; i++) {
				p1.addPiece(new Piece(PieceType.ZERO));
				p2.addPiece(new Piece(PieceType.X));
			}
		}
		else {}
	}
	
	// Position picking method
	
	public void pickPosition(Player player) {
		System.out.println("Position for " + player.getName() + " :");
		Scanner s = new Scanner(System.in);
		int position = s.nextInt();
		board.getCell(position / 10, position % 10).setPiece(player.getPieceArray(playerPieceIndex));
	}
	
	// Switch between the 2 players
	
	public void playerSwitch(Player playerArray[]) {
		Player temp = playerArray[0];
		playerArray[0] = playerArray[1];
		playerArray[1] = temp;
	}
	
	// Checks if the game is tied
	
	public void tieCheck(int step) {
		if(step == 9 && gamestate != GameState.WIN_X && gamestate != GameState.LOSE_X) {
			gamestate = GameState.TIE;
		}
	}
	
	// Check lines
	
	public GameState lineCheck() {
		GameState state = GameState.RUNNING;
		for(int i = 0 ; i < board.getBoardRows() ; i++) {
			PieceType check = board.getCell(i, 0).getPiece().getType();
			if(check == PieceType.X) {
				state = GameState.WIN_X;
			}
			if(check == PieceType.ZERO) {
				state = GameState.LOSE_X;
			}
			for(int j = 1 ; j < board.getBoardColumns() ; j++) {
				if(board.getCell(i, j).getPiece().getType() != check || check == PieceType.SPACE) {
					state = GameState.RUNNING;
					break;
				}
			}
			if(state != GameState.RUNNING) {
				return state;
			}
		}
		return state;
	}
	
	// Check columns
	
	public GameState columnCheck() {
		GameState state = GameState.RUNNING;
		for(int j = 0 ; j < board.getBoardColumns() ; j++) {
			PieceType check = board.getCell(0, j).getPiece().getType();
			if(check == PieceType.X) {
				state = GameState.WIN_X;
			}
			if(check == PieceType.ZERO) {
				state = GameState.LOSE_X;
			}
			for(int i = 1 ; i < board.getBoardRows() ; i++) {
				if(board.getCell(i, j).getPiece().getType() != check || check == PieceType.SPACE) {
					state = GameState.RUNNING;
					break;
				}
			}
			if(state != GameState.RUNNING) {
				return state;
			}
		}
		return state;
	}
	
	// Check main diagonal
	
	public GameState mainDiagCheck() {
		GameState state = GameState.RUNNING;
		PieceType check = board.getCell(0, 0).getPiece().getType();
		if(check == PieceType.X) {
			state = GameState.WIN_X;
		}
		if(check == PieceType.ZERO) {
			state = GameState.LOSE_X;
		}
		for(int i = 1 ; i < board.getBoardColumns() ; i++) {
			if(board.getCell(i, i).getPiece().getType() != check || check == PieceType.SPACE) {
					state = GameState.RUNNING;
					break;
			}
		}
		return state;
	}
	
	// Check secondary diagonal
	
	public GameState secondDiagCheck() {
		GameState state = GameState.RUNNING;
		PieceType check = board.getCell(0, 2).getPiece().getType();
		if(check == PieceType.X) {
			state = GameState.WIN_X;
		}
		if(check == PieceType.ZERO) {
			state = GameState.LOSE_X;
		}
		for(int i = 1 ; i < board.getBoardColumns() ; i++) {
			if(board.getCell(i, 2-i).getPiece().getType() != check || check == PieceType.SPACE) {
					state = GameState.RUNNING;
					break;
			}
		}
		return state;
	}
	
	// Checks which player won the game
	
	public GameState whoWon() {
		GameState whowon = GameState.RUNNING;
		if(lineCheck() != GameState.RUNNING) {
			whowon = lineCheck();
			return whowon;
		}
		if(columnCheck() != GameState.RUNNING) {
			whowon = columnCheck();
			return whowon;
		}
		if(mainDiagCheck() != GameState.RUNNING) {
			whowon = mainDiagCheck();
			return whowon;
		}
		if(secondDiagCheck() != GameState.RUNNING) {
			whowon = secondDiagCheck();
			return whowon;
		}
		return whowon;
	}
	
	
	public void game() {
		Player playerArray[] = new Player[2];
		playerArray[0] = p1;
		playerArray[1] = p2;
		String name;
		int step = 0;
		
		nameSelection(p1, p2);
		symbolSelection(playerPieceNumber);
		
		while(gamestate == GameState.RUNNING) {
			if(step > 4) {
				gamestate = whoWon();
				tieCheck(step);
			}
			
			switch(gamestate) {
				case RUNNING :
					pickPosition(playerArray[0]);
					board.displayBoard();
					playerSwitch(playerArray);
					if(step % 2 != 0) {
						playerPieceIndex++;
					}
					step++;
					break;
				
				case TIE :
					System.out.println("This game is tie");
					break;
					
				case WIN_X :
					if(playerArray[0].getPieceArray(0).getType() == PieceType.X) {
						name = playerArray[0].getName();
					}
					else name = playerArray[1].getName();
					
					System.out.println(name + " has won the game !");
					break;
					
				case LOSE_X :
					if(playerArray[0].getPieceArray(0).getType() == PieceType.ZERO) {
						name = playerArray[0].getName();
					}
					else name = playerArray[1].getName();
					
					System.out.println(name + " has won the game !");
					break;
			}
		}	
	}
	
	public static void main(String []args) {
		new Game().game();
	}
}
