
public class Board {
    Square[][] board;
    Square square;
    SudokuBuffer buffer; //= new SudokuBuffer();
    int boardSize;
    int[] boardLine;
    int[] solution;
    int solCount = 0;
    
    // Making some "random" arrays
    //setting up the sudoku board the biggest construct ever
    Board(int boardSize, int boxHight, int boxLength, int[] boardLine, SudokuBuffer buffer) {

		board = new Square[boardSize][boardSize];
		Column[] column = new Column[boardSize];
		Row[] row = new Row[boardSize];
		Box[][] box = new  Box[boxLength][boxHight];
		this.boardSize = boardSize;
		this.boardLine = boardLine;
		this.buffer = buffer;
		
		// Making column-, row- and box pointers
		for (int i = 0; i < boardSize; i++) {
		    column[i] = new Column(boardSize);
		    row[i] = new Row(boardSize);
		    box[i/boxHight][i%boxHight] = new Box(boardSize); 		    
		}
		
		int boardCounter = 0;
		//variables.clear();
			
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				int number = boardLine[boardCounter++];
				 board[r][c] = new Square(number, row[r], column[c], 
					     box[r/boxHight][c/boxLength], this);
				 //System.out.println(board[r][c].value);
			}
		}			

		Square previous = null;
	    
		// Making the next pointers
		for (int r = boardSize-1; r >= 0; r--){
		    for (int c = boardSize-1; c >= 0; c--) {
		    	board[r][c].next = previous;
		    	previous = board[r][c];
			
		    }
		}
		board[0][0].setNumber();
    }
      
    // copying the solution, and sends it to the buffer
    public void saveSolution() {
    	solCount++;
    	if (solCount > 1) {
    		return;
    	}
    		
    	solution = new int[81];
    	int counter = 0;
    	for(int i = 0; i < board.length; i++) {
    		 for (int j = 0; j < board.length; j++) {
    			 solution[counter++] = board[i][j].value;
    			 //System.out.print(board[i][j].value);
    		 }
    	}//System.out.print("added solution\n");
    	buffer.add(solution);
    	//return;
    }
}

