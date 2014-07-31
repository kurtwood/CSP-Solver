import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;


public class ScannerReadFile {
	String filename;
	String outfilename;
	
	//Read file line by line, send each
	//sudoku to the solver
	public void readFile(String infile, String outfile) {
		filename = infile;
		outfilename = outfile;
		
		// Location of file to read and write
		File file = new File(filename);		
		File out = new File(outfilename);
		SudokuBuffer buffer = new SudokuBuffer();
		
    	try {
    		System.out.println("---CSP Solver---");
    		System.out.println("Trying to find solution(s) for sudoku puzzles in the file: " + filename);
    		System.out.println("Writing solutions to the file: " + outfilename);

    		
    		Scanner scanner = new Scanner(file);
    		
    		long startTime = System.currentTimeMillis();
    		
    		while (scanner.hasNextLine()) {
    			String line = scanner.nextLine();
    			//System.out.println(line);
    			int[] convertedLine = splitLine(line);
    			if (convertedLine.length == 81) {
    				Board board = new Board(9, 3 ,3, convertedLine, buffer);
    			}
    			
    		}
    		long endTime = System.currentTimeMillis();
    		System.out.print("Time to solve: " + (endTime - startTime) + " milliseconds --> ");
    		System.out.println((endTime - startTime) / 1000.0 + " seconds.");
    		System.out.println("----------------");
    		//System.out.print("ferdig med sol\n");
    		writeFile(buffer, out);
    		scanner.close();
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
	}
	
	//split the input line and make an int[] out of it
	//for convenience later on.
	public int[] splitLine(String line) {
		int[] board = new int[line.length()];
		char[] temp = new char[line.length()];
		
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
	
	//write the solution to given file
	public void writeFile(SudokuBuffer buffer, File out) {		
		String print;

		try {
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out), "utf-8"));
			//DataOutputStream writer = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(out)));

			//System.out.println("in write");
			for(int i = 0; i < buffer.solutionBuffer.size(); i++) {
				print = "";
				for (int j = 0; j < buffer.solutionBuffer.get(i).length; j++ ) {
					//writer.write(buffer.solutionBuffer.get(i)[j]);
					print += Integer.toString(buffer.solutionBuffer.get(i)[j]);
					//System.out.print(buffer.solutionBuffer.get(i)[j]);
				}
				//System.out.print("\n");
				writer.write(print + "\n");
			}
			writer.close();
		} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
}


