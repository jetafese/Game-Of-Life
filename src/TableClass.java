/*************************************************************
 * Programmer: Joseph
 * 
 * Class: CS40S
 * 
 * Assignment: 2 Dimensional array 
 * 
 * Input: none
 * 
 * Output: Output will vary for different
 *         parts of the exercise 
 *************************************************************/

public class TableClass {
    
    // properties for the object
    private int row;               // rows for the 
    private int col;
    
    // create an array for the class
       protected int [][] myBox = new int [100][100];
    
    
    // Constructors
    // default constructor
        // no input
        // no output
    public TableClass () {
        
        row = 100;
        col = 100;
        
        Zeroer z = new Zeroer(row, col, myBox);
    }
    
    // initialized constructor
        // input row, column, array dimensdions
        // no output
    public TableClass( int r, int c) {
        
        row = r;
        col = c;
        
         Zeroer z = new Zeroer(row, col, myBox);
    }
    
    // Accessors
    
    // get the number of rows
        // input: none
        // returns: number of rows
    public int getRow() {
        return row;
    }
    
    // get the number of columns
        // input: none
        // returns: number of columns
    public int getCol() {
        return col;
    }
    
    // get the value at a certain index
        // input: row annd columns
        // returns: index vaue
     public int getIndex(int a, int b) {
        return myBox[a][b];
    }
    
    // mutators
    
     // set the number of rows
        // input: number of rows
        // returns: none
    public void setRow(int r){
        row = r;
    }
    
    // set the number of columns
        // input: number of rows
        // returns: none
    public void setCol(int c){
        col = c;
    }
    
    // set the index and value for the array
        // input: index and value
        // returns: none
    public void setIndex(int a, int b, int arrayValue){
        myBox[a][b] = arrayValue;
    }
    
} // end class
