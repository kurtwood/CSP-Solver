import java.util.ArrayList;


public class Restrictions {
	
	public void setConstraints(Board board) {
		System.out.println("In setConstraint");
        int filledCells = board.filledCells();
        board.cellDomainCheck();

        //Constrain the cells until no longer possible
        while(board.filledCells() != filledCells) {
            filledCells = board.filledCells();
            board.cellDomainCheck();
        }
	}
	
	public Board select(Board splitBoard, Board board) {	
		System.out.println("In select");
		int valRow = splitBoard.variables.get(0).row;
		int valCol = splitBoard.variables.get(0).column;
		
		System.out.println("valRow: " + valRow);
		System.out.println("valCol: " + valCol);
		
		System.out.println("board " + board.sudokuBoard[valRow][valCol].domain);
		System.out.println("split " + splitBoard.sudokuBoard[valRow][valCol].domain);

        ArrayList<Integer> posDomain = board.sudokuBoard[valRow][valCol].domain;
        int chosenVal = posDomain.get(0);
        
        System.out.println(chosenVal);
        
        ArrayList<Integer> removed = new ArrayList<Integer>();
        removed.add(chosenVal);

        board.sudokuBoard[valRow][valCol].removeFromDomain(removed);

        splitBoard.sudokuBoard[valRow][valCol].domain = new ArrayList<Integer>();
        splitBoard.sudokuBoard[valRow][valCol].domain.add(chosenVal);
        
		return splitBoard;
	}
	
	public Board chooseVariable(Board board) {
		System.out.println("In chooseVariable");
		int small = 9;
		Board split = board.copy(board);
		System.out.println("Split: " + split.sudokuBoard[2][1].domain.get(0));
		System.out.println("Board: " + board.sudokuBoard[2][1].domain.get(0));

		int defI = 0, defJ = 0;
		for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //select the cell with the smallest domain
                if(split.sudokuBoard[i][j].domain.size() > 1 && 
                		split.sudokuBoard[i][j].domain.size() < small) {
                	defI = i;
                	defJ = j;
                    small = split.sudokuBoard[i][j].domain.size();
                    System.out.println("out");
                }
            }
        }
		
		System.out.println("Split2: " + split.sudokuBoard[2][1].domain.get(0));
		System.out.println("Board2: " + board.sudokuBoard[2][1].domain.get(0));
		
        split.variables.clear();
        board.variables.clear();
        split.variables.add(split.sudokuBoard[defI][defJ]);		
		System.out.println(split.sudokuBoard[0][0].domain.get(0));

		return split;
	}
	
}
