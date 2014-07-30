import java.util.ArrayList;

public class Cell {

    public ArrayList<Integer> domain;
    public int row; //id of the row
    public int column;  //id of the column
    public int region;  //id of the square

    public Cell()
    {
        domain = new ArrayList<Integer>();
        fillDomain();
    }

    public void setValueInCell(int startValue){

        //if cell is not given then add all 9 possible numbers
        if(startValue != 0)
        {
            int givenNumber = startValue;
            domain.clear();
            domain.add(givenNumber);
        }
    }

    public void removeFromDomain(ArrayList<Integer> remove) {
        domain.removeAll(remove);
    }

    public void fillDomain(){
        domain.clear();
        for (int i = 1; i < 10; i++)
        {
        	domain.add(i);
        }
    }
    public Cell copy() {
        Cell copy = new Cell();
        copy.row = row;
        copy.column = column;
        copy.region = region;
        copy.domain = new ArrayList<Integer>(domain.size());

        for (int i = 0; i < domain.size(); i++) {
            copy.domain.add(i, domain.get(i));

        }

        return copy;
    }
}