import java.util.ArrayList;

public class Cell {

    public ArrayList<Integer> domain;
    public int row; //id of the row
    public int column;  //id of the column
    public int square;  //id of the square

    public Cell()
    {
        domain = new ArrayList<Integer>();
        reset();
    }

    public void setCellValue(int startValue){

        //if cell is not given then add all 9 possible numbers
        if(startValue != 0)
        {
            int givenNumber = startValue;
            domain.clear();
            domain.add(givenNumber);
        }
    }

    public void RemoveFromDomain(ArrayList<Integer> remove) {
        domain.removeAll(remove);
    }

    public void reset(){
        domain.clear();
        for (int i = 1; i < 10; i++)
        {
             domain.add(i);
        }
    }
}