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
			columns[i] = temp; //adding all the numbers in a column
		}
		
		//set regions
		for (int region = 0; region < 9; region++) {
			temp = new ArrayList<Cell>();
			for (int i = ((region/3)*3); i < (((region/3)*3)+3); i++) {
				for (int j = ((region%3)*3); j< (((region%3)*3)+3); j++) {
                    sudokuBoard[i][j].region = region;
                    temp.add(sudokuBoard[i][j] );
                    
                    //System.out.println("reg " + region + " i " + i 
                    	//	+ " j " + j + " " + sudokuBoard[i][j].region);
				}
			}
            regions[region] = temp;
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
       			if (columns[i].get(j).domain.get(0) == 0) {
       				columns[i].get(j).fillDomain();
       			//System.out.println("i: " + i + " j: " + j);
       			}
       		}
       	}
		
	}

<<<<<<< HEAD
	//Verify that the domains are filled in
	public boolean verifyDomain(){
		//Check each row
		for(int i = 0; i <9; i++){
			//check each column
			for (int j = 0; j < 9; j++){
				//Check domain size
				if(sudokuBoard[i][j].domain.size()!=1)
					{
						return false;
					}
			}
		}
		return true;
	}

=======
>>>>>>> edf87ed83916eef84fd197f7c1da54ac1541c0a3
	public boolean verifyRows(){
		//check each row
		for(int i = 0; i < 9; i++){
			//check each column
			for(int j = 0; j < 9; j++){
				//Check numbers
				for(int numb = j +1; numb < 9; numb++){
					if(sudokuBoard[i][j].domain.get(0) == sudokuBoard[i][numb].domain.get(0) )
                          return false ;
				}
			}
		}
		return true;
	}

	public boolean verifyColumns(){
		//Check each column
		for (int j = 0; j < 9; j++){
			//Check each row
			for( int i = 0; i < 9; i ++){
				//Check numbers
				for(int numb = i +1; numb < 9; numb++){
					if(sudokuBoard[i][j].domain.get(0) == sudokuBoard[numb][j].domain.get(0)){
						return false;
					}
				}
			}
		}
		return true;
	}

		/** Checks if the regions are valid
        	* row is calculated by dividing the box number by 3 and casting to an int this way ony whole numbers are gotten
            * then multiplied by 3 to get the row to start from. for box 0-2 this is 0  3-5 this is 3 for 6-8 this is 6.. get it?
            * for the column this same interval is calculated by box mod 3 times 3 to calculate the column*/

        public boolean verifyRegions()
        {
            for (int region = 0; region < 9; region++)  //each box
             {
                boolean[] seen ={false,false,false,false,false,false,false,false,false,};

                for (int i = (((int)region/3)*3); i < (((int)region/3)*3)+3; i++)  //each row
                 {
                    for (int j = ((region%3)*3); j < (((region%3)*3)+3); j++)  //each column
                    {
                        int numbertoCheck = (sudokuCells[i][j].domain.get(0)) -1;
                        if(seen[numbertoCheck])
                        {
                            //I already saw this number
                            return false;
                        }
                        else
                        {
                            seen[numbertoCheck] = true;
                        }
                    }
                 }

             }

            //no need to check array... 9 fields are checked per box! so 9 unique values must be found...i think
              return true ;
        }
	
	public String writeSolution() {
        
		String print = "";
        for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
                if(sudokuBoard[i][j].domain.size() == 1) {
                    print +=sudokuBoard[i][j].domain.get(0).toString();
                } else {
                    print += ".";
                }
            }
        }
        return print;
	}
	
    public boolean verifyDomain() {
        for (int i = 0; i < 9; i++) {
             for (int j = 0; j < 9; j++) {
                if(sudokuBoard[i][j].domain.size() != 1) {
                    return false;
                }
             }
        }
        return true;
    }
}
