import java.util.ArrayList;
import java.util.List;

public class Board {

	//Properties
	int[] board;
	int boardCounter;
	
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
        
		ArrayList<Cell> temp;
 		//set rows
		for (int i = 0; i < 9; i++) {
            temp = new ArrayList<Cell>();
			for (int j = 0; j < 9; j++) {
                sudokuBoard[i][j].row = i;
                temp.add(sudokuBoard[i][j]);
			}
			rows[i] = temp; //adding all the numbers in a row
		}
		
		//set columns
		for (int i = 0; i < 9; i++) {
            temp = new ArrayList<Cell>();
			for (int j = 0; j < 9; j++) {
                sudokuBoard[j][i].column = i;
                temp.add(sudokuBoard[j][i]);
			}
			rows[i] = temp; //adding all the numbers in a column
		}
		
		
		//set regions
		for (int region = 0; region < 9; region++) {
			temp = new ArrayList<Cell>();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
		
				}
			}
		}
		drawBoard(board); 
	}
	
	//draw board with the given values
	//the rest is 0
	private void drawBoard(int[] line) {
		boardCounter = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
                sudokuBoard[i][j].setValueInCell(board[boardCounter++]);

                if(sudokuBoard[i][j].domain.size() == 1){
                    //chosenVariables.add( sudokuCells[i][j] );
			
                }	
			}
		}
	}
	
	//fill the domain of a cell to {1, 2...9}
	public void setDomain() {
        for (int i = 0; i < columns.length; i++) {
       		for (int j = 0; j < columns[i].size(); j++) {
       			columns[i].get(j).fillDomain();
       		}
       	}
		
	}
	
	public void checkConstraints() {
		
	}	
}
