import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerReadFile {
	String filename;
	
	//Read file line by line, send each
	//sudoku to the solver
	public void readFile(String infile) {
		filename = infile;
		
		// Location of file to read
		File file = new File(filename);

    	try {

    		Scanner scanner = new Scanner(file);

    		while (scanner.hasNextLine()) {
    			String line = scanner.nextLine();
    			//System.out.println(line);
    			Board board = new Board(splitLine(line));
    			board.checkConstraints();
    		}
    		scanner.close();
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
	}
	
	public int[] splitLine(String line) {
		int[] board = new int[81];
		char[] temp = new char[81];
		
		temp = line.toCharArray();
		
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == '.') {
				board[i] = 0;
			} else {	
				board[i] = Character.getNumericValue(temp[i]);
			}
			//System.out.print(board[i]);
		} //System.out.println(" ");
		
		return board;
	}
}


