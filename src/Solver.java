import java.util.ArrayList;
import java.util.List;


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
	Restrictions res = new Restrictions();
	
	
	//implementing arc consistency
	public void advancedSolver (Board board) {
		System.out.println("In solver");
		//for each cell, try each number based
		//on the domain...
		
		while (!solved && /*!valid(board) &&*/ !constraintCheck(board)) {
			System.out.println("In while");
			res.setConstraints(board);
			Board split = splitBoard(board);
			advancedSolver(split);
			
		}
		if (constraintCheck(board)) {
			System.out.println("In ifSolved");
			solved = true;
			board.writeSolution();
		}
	}
	/*
	private void setConstraints(Board board) {
		System.out.println("In setConstraint");
        int filledCells = board.filledCells();
        board.cellDomainCheck();

        //Constrain the cells until no longer possible
        while(board.filledCells() != filledCells) {
            filledCells = board.filledCells();
            board.cellDomainCheck();
        }
	}*/
	
	private boolean constraintCheck(Board board) {
		System.out.println("In constraintCheck");
		return (board.verifyDomain() && 
				board.verifyRows() && 
				board.verifyColumns() && 
				board.verifyRegions());	
	}
	
	private boolean valid(Board board) {
		System.out.println("In valid");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board.sudokuBoard[i][i].domain.size() == 0) {
					System.out.println("In domainsize == 0");
					return false;
				}
			}
		} return true;
	}
	

	private Board splitBoard(Board board) {
		System.out.println("In splitBoard");
		return res.select(res.chooseVariable(board), board);
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
