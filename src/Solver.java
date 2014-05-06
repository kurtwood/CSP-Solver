
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
			Board split = split(board);
			advancedSolver(split);
			
		}
		if (constraintCheck(board)) {
			solved = true;
			board.writeSolution();
		}
	}
	
	private boolean constraintCheck(Board board) {
		return (/*board.CheckDomains() &&*/ 
				board.verifyRows() && 
				board.verifyColumns() && 
				board.verifyRegions());	}
	
	private boolean valid(Board board) {
		return false;
	}
	
	private Board split(Board board) {
		return board;
	}

	public void easySolver (Board board)
	{
		if(board.verifyDomain){
			solved = true;
			board.writeSolution();
		}

		for(int num =1; num <= 9; num++)
		{

			if(!board.verifyRows() && !board.verifyColumns && !board.verifyRegions)
			{
				board.sudokuBoard[i][j] = num;
				return true;
			}

		}
		return false;
	}

}


