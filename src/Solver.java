import java.util.ArrayList;


//TODO:when testing a value; remove from domain...

/**
*	ATM: if not satisfied
*			split, solve(split)
*		if okay := solved
*		else checkConstraints, checkValidity, 
*		
*/	


//Gets a board,
//finds a solution based on constraints.
//Backtracking and arc consistency/something else
public class Solver {
	
	boolean solved = false;
	
	//implementing arc consistency
	public void advancedSolver (Board board) {
		//for each cell, try each number based
		//on the domain...
		
		while (!solved && !valid(board) && !constraintCheck(board)) {
			Board split = splitBoard(board);
			advancedSolver(split);
			
		}
		if (constraintCheck(board)) {
			solved = true;
			board.writeSolution();
		}
	}
	
	private boolean constraintCheck(Board board) {
		return (board.verifyDomain() && 
				board.verifyRows() && 
				board.verifyColumns() && 
				board.verifyRegions());	
	}
	
	private boolean valid(Board board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board.sudokuBoard[i][i].domain.size() == 0) {
					return false;
				}
			}
		} return true;
	}
	
	private Board select(Board splitBoard, Board board) {		
		int valRow = splitBoard.variables.get(0).row;
		int valCol = splitBoard.variables.get(0).column;
		
        ArrayList<Integer> posDomain = board.sudokuBoard[valRow][valCol].domain;
	
	
        int chosenVal = posDomain.get(0);

        ArrayList<Integer> removed = new ArrayList<Integer>();
        removed.add(chosenVal);

        board.sudokuBoard[valRow][valCol].removeFromDomain(removed);

        splitBoard.sudokuBoard[valRow][valCol].domain = new ArrayList<Integer>();
        splitBoard.sudokuBoard[valRow][valCol].domain.add(chosenVal);
        
		return splitBoard;
	}
	
	private Board chooseVariable(Board board) {
		int small = 9;
		Board split = board;
		int defI = 0, defJ = 0;
		for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //select the cell with the smallest domain
                if(split.sudokuBoard[i][j].domain.size() > 1 && 
                		split.sudokuBoard[i][j].domain.size() < small) {
                	defI = i;
                	defJ = j;
                    small = split.sudokuBoard[i][j].domain.size();
                }
            }
        }
        split.variables.clear();
        board.variables.clear();
        split.variables.add(split.sudokuBoard[defI][defJ]);		
		return split;
	}
	
	private Board splitBoard(Board board) {
		return select(chooseVariable(board), board);
	}	
	
	public boolean easySolver (Board board){
		if(board.verifyDomain()){
			solved = true;
			board.writeSolution();
		}

		for(int num = 1; num <= 9; num++) {

			if(!board.verifyRows() && !board.verifyColumns() && !board.verifyRegions()) {
				//board.sudokuBoard[i][j].domain.get(0) = num;
				return true;
			}
		}
		return false;
	}
}
