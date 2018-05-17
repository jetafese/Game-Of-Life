/*************************************************************
 * Programmer: Joseph
 * 
 * Class: CS40S
 * 
 * Assignment: 2 Dimensional array 
 * 
 * Input: table class
 * 
 * Output: empty table
 *************************************************************/

public class Zeroer {
    
    
   int r;     // rows
   int c;     // columns
   
   
    // initialized constructor
        // input row, column, 2DArray
        // no output
    public Zeroer (int rows, int columns, int table [][]){
        
        r = rows;
        c = columns;
        
        for(r = 0;r < rows; r++){
            for(c = 0; c < columns; c++){
                table[r][c] = 0;
            } // end columns = 0
        } // end rows = 0
        
    } // end Zeroer
    
} // end class
