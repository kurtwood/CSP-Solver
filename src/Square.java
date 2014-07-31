
public class Square {
	int value;
    Square next;
    boolean solutionFound = false;
    int solutionCounter = 0;
    
    Board board;
    Row r;
    Box b;
    Column c;

    Square(int value, Row r, Column c, Box b, Board board) {
		this.value = value;
		this.r = r;
		this.c = c;
		this.b = b;
		this.board = board;
		this.setValue(value);	
    }

    Square(Row r, Column c, Box b, Board board) {
    	this.r = r;
    	this.c = c;
    	this.b = b;
    	this.board = board;
    }

    // try setting numbers in the squares
    public void setNumber() {
    	/*if (solutionCounter > 1) {
    		if (solutionFound == true) {
    			System.out.println("sol found square");
    			return;
    		}
    	}*/
	
    	if (value > 0) { 
    		if (next == null) {
    			foundSolution();
	    
    		} else {
    			next.setNumber();
    		}
    	} else {
    		//Could be improved by adding domain to the square and
    		//only check values in the domain.
    		for (int i = 1; i <= r.number.length; i++) {
    			if (legal(i)) {
    				setValue(i);
		    
    				if (next == null) {
    					foundSolution();
    				} else {
    					next.setNumber();
    				}
    				releaseValue();
    			}
    		}
    	}
    }
    
    // checks if a number can be used or not
    public boolean legal(int number) {
    	if (r.checkNumber(number) &&  b.checkNumber(number) 
    			&& c.checkNumber(number)) {
    		return true;
    	}
    	return false;
    }

    // copying the solution, and sends it to the buffer
    public void foundSolution() {
    	//System.out.println("solfound square");
    	solutionCounter++;
    	solutionFound = true;
	
    	if (solutionCounter > 1) {
    		return;
    	}
    	board.saveSolution();
    	//return;
    }

    // Sets the value in a square if it can be used
    public void setValue(int i) {
    	r.setValue(i, true);
    	c.setValue(i, true);
    	b.setValue(i, true);
    	value = i;
    }

    // Releases the value if it can't be used
    public void releaseValue() {
    	r.setValue(value, false);
    	c.setValue(value, false);
    	b.setValue(value, false);
    	value = 0;
    }
}
