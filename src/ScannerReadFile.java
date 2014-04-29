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
    			System.out.println(line);
    			//TODO: each line to solver
    		}
    		scanner.close();
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
	}
}



