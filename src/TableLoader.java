/*************************************************************
 * Programmer: Joseph
 * 
 * Class: CS40S
 * 
 * Assignment: 2 Dimensional array
 * 
 * Input: Comes through parameters
 * 
 * Output: loaded array
 *************************************************************/
import java.util.*;

public class TableLoader {
    
    Random random = new Random();
    Cell cell = new Cell();
    
    TableClass table = new TableClass();
  
    // initialized constructor 
        // input: table Class
        // returns: none
    public TableLoader (TableClass t){
        
        table = t;
     
    }
    
    
    //******************* load table *********************
    
    
    // method that loads a 2D array
        // input: table Class
        // returns: none
    public int [][] loadTableRandomly (TableClass t){
        
        for(int r = 0; r < t.getRow(); r++){
            for(int c = 0; c < t.getCol(); c++){
              // populate array
              t.myBox[r][c] = random.nextInt(1 - 0 + 1) + 0;
              
            } // end int c = 0
        } // end int r = 0

        return t.myBox;
    }
    
    // next-gen matrix loader
        // input: table Class
        // returns: none
    public void loadNextGen (TableClass t){
        
        for(int r = 0; r < t.getRow(); r++){
            for(int c = 0; c < t.getCol(); c++){
              // populate array
             // t.myBox[r][c] = cell.getNextCell(c, c)
              
            } // end int c = 0
        } // end int r = 0
        
    }
    
} // end class
