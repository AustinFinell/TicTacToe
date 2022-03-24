package TicTacToe;

import java.util.Random;

public class TicTacToe {
	
	Random rand = new Random();
	private int moveCount;
	private String turn;
	private String[] moveArr;
	private int a;
	private int b;
	private int c;
	
	TicTacToe(){
		moveCount = 0;
		moveArr = new String[9];
		turn = rand.nextInt(2) == 1 ? "X" : "O";
	}
	
	public String getTurn() {
		return turn;
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	
	public void setMoveArr(int index) {
		moveArr[index] = turn;
	}
	
	public void clearMoveArr() {
		for (int i = 0; i < 9; i++) {
			moveArr[i] = null;
		}
	}
	
	public void clearMoveCount() {
		moveCount = 0;
	}
	
	public int[] getWonCells() {
		int[] cells = new int[3];
		cells[0] = a;
		cells[1] = b;
		cells[2] = c;
		return cells;
	}
	
	public void changeTurn(){
		turn = turn.equals("X") ? "O" : "X";
	}
	
	public void move(int index) {
		moveCount++;
		setMoveArr(index);
		changeTurn();
	}
	
	public String checkWin() {
		String line = "";
		String result = "";
		for (int l = 0; l < 8; l++) {
			switch (l) {
			case 0:
				line = moveArr[0] + moveArr[1] + moveArr[2];
				a = 0;
				b = 1;
				c = 2;
				break;
			case 1:
				line = moveArr[3] + moveArr[4] + moveArr[5];
				a = 3;
				b = 4;
				c = 5;
				break;
			case 2:
				line = moveArr[6] + moveArr[7] + moveArr[8];
				a = 6;
				b = 7;
				c = 8;
				break;
			case 3:
				line = moveArr[0] + moveArr[3] + moveArr[6];
				a = 0;
				b = 3;
				c = 6;
				break;
			case 4:
				line = moveArr[1] + moveArr[4] + moveArr[7];
				a = 1;
				b = 4;
				c = 7;
				break;
			case 5:
				line = moveArr[2] + moveArr[5] + moveArr[8];
				a = 2;
				b = 5;
				c = 8;
				break;
			case 6:
				line = moveArr[0] + moveArr[4] + moveArr[8];
				a = 0;
				b = 4;
				c = 8;
				break;
			case 7:
				line = moveArr[6] + moveArr[4] + moveArr[2];
				a = 6;
				b = 4;
				c = 2;
				break;
			}
			
			if (line.equals("XXX")) {
				result = "X";
				break;
			}
			
			if (line.equals("OOO")) {
				result = "O";
				break;
			}
			
			if (getMoveCount() == 9 && result.equals("")) {
				result = "Draw";
			}
			
		}
		
		return result;
		
	}
	
	

}
