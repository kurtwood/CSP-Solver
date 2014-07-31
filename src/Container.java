
abstract class Container {
	public  boolean[] number;
    
    Container(int size) {
    	number = new boolean[size];

    }
    
    // returns true if the index in the array is false
    public boolean checkNumber(int i) {
    	return !number[i-1];
		
    }

    // sets the index in the value to true
    public void setValue(int i, boolean take) {
    	if (i != 0 && i != -1) {
    		number[i-1] = take;
    	}
    }
}
