package connectFour;
import java.util.Scanner;


public class Main {

	private static int playCol;
	private static int playRow;
	private static String turn;
	private static String[][] board = new String[7][6];
	private static boolean win;
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		turn = "X";
		win = false;
		
		System.out.println("\n");
		
		for(int h = 0; h < 6; h++) {
			for(int l = 0; l < 7; l++) {
				board[l][h] = new String("    -");
				System.out.print(board[l][h]);
			}
			System.out.print("\n\n");
		}
		
		System.out.println("   ---  ---  ---  ---  ---  ---  ---");
		System.out.println("    1    2    3    4    5    6    7");
		System.out.println("---------------------------------------\n\n");
		System.out.print("To play, type the number of the column you wish to play in and press \"Enter\" to end your turn.\n\nX's Turn: ");
		
		while(turns()==false) {
		}
		
		for(int h = 5; h >= 0; h--) {
			for(int l = 0; l < 7; l++) {
				System.out.print(board[l][h]);
			}
			System.out.print("\n\n");
		}
		System.out.println("\n" + turn + " is the winner!");
		
	}

	public static boolean turns() {
		
		playCol = input.nextInt() - 1;
		
		if(playCol >= 0 && playCol < 8 && board[playCol][5].equals("    -")) {
			for(int i = 0; i < 6; i++) {
				if(board[playCol][i].equals("    -")) {
					board[playCol][i] = "    " + turn;
					playRow = i;
					if(winCondition()) {
						return true;
					}
					break;
				} 
			}
		} else { 
			System.out.println("This is not a valid column, please pick a different one.");
			if(turn.equals("X")) {
				turn = "O";
			} else {
				turn = "X";
			}
		}
		
		System.out.println("");
		
		for(int h = 5; h >= 0; h--) {
			for(int l = 0; l < 7; l++) {
				System.out.print(board[l][h]);
			}
			System.out.print("\n\n");
		}
		
		System.out.println("   ---  ---  ---  ---  ---  ---  ---");
		System.out.println("    1    2    3    4    5    6    7");
		System.out.println("---------------------------------------\n\n");
		
		if(turn.equals("X")) {
				System.out.print("O's Turn: ");
				turn = "O";
			} else {
				System.out.print("X's Turn: ");
				turn = "X";
			}
		return false;
	}
	
	public static boolean winCondition() {
		
		int winCount = 0;
		
		//column win check
		for(int i = 0; i < 6; i++) {
			if(board[playCol][i].equals("    " + turn)) {
				winCount++;
				if(winCount == 4) {
					return true;
				}
			} else {
				winCount = 0;
			}
		}
		
		winCount = 0;
		
		//row win check
		for(int i = 0; i < 7; i++) {
			if(board[i][playRow].equals("    " + turn)) {
				winCount++;
				if(winCount == 4) {
					return true;
				}
			} else {
				winCount = 0;
			}
		}
		
		//diagonal win check
		winCount = 0;
		int col = playCol;
		int row = playRow;
		
		while(col > 0 && row > 0) {
			col --;
			row--;
		}
		
		while(col < 7 && row < 6) {
			if(board[col][row].equals("    " + turn)) {
				winCount++;
				if(winCount == 4) {
					return true;
				}
			} else {
				winCount = 0;
			}
			col++;
			row++;
		}
		
		winCount = 0;
		col = playCol;
		row = playRow;
		
		while(col < 6 && row > 0) {
			col ++;
			row--;
		}
		
		while(col > 0 && row < 5) {
			if(board[col][row].equals("    " + turn)) {
				winCount++;
				if(winCount == 4) {
					return true;
				}
			} else {
				winCount = 0;
			}
			col--;
			row++;
		}
		
		return false;
	}
}