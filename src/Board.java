import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

	//Properties
	int[] board;
	
    public Cell sudokuBoard[][];

    //for the checking methods 
    public ArrayList<Cell> rows[] = new ArrayList[9];
    public ArrayList<Cell> columns[] = new ArrayList[9];
    public ArrayList<Cell> regions[] = new ArrayList[9];

    //?
    public List<Cell> chosenVariables;
	
	Board(int[] line) {
		board = line;
        sudokuBoard = new Cell[9][9];
        initiateBoard();
        setDomain(); //gives non-given values {1,...9}
	}
	
	//set up an empty board 
	//by defining rows, collumns and regions
	private void initiateBoard() {
		
		//Fill the board with cells
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
               sudokuBoard[i][j] = new Cell();
            }
        }
		
		//set rows
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				
			}
		}
		
		//set collumns
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
			
			}
		}
		
		
		//set regions
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
		
			}
		}
		drawBoard(board); 
	}
	
	//draw board with the given values
	private void drawBoard(int[] line) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				
			}
		}
	}
	
	public void setDomain() {
		
	}
	
	public void checkConstraints() {
		
	}	
}
