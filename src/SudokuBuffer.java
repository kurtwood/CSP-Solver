import java.util.ArrayList;


public class SudokuBuffer {
    ArrayList<int[]> solutionBuffer;
    
    SudokuBuffer() {
    	solutionBuffer = new ArrayList<int[]>();
	
    }  
    
    // adding solution to the ArrayList. 
    public void add(int[] solution) {
    	solutionBuffer.add(solution);
    }
    
    // returns a solution from the ArrayList
    public int[] get(int index) {
    	return solutionBuffer.get(index);
    }
}
