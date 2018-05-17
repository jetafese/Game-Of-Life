/*************************************************************
 * Programmer: Joseph
 * 
 * Class: CS40S
 * 
 * Assignment: 2 Dimensional array
 * 
 * Input: data will come in as parameters
 *        primarily tables
 * 
 * Output: altered/desired table
 *************************************************************/

public class TablePrinter {
    
    TableClass table = new TableClass();
    
    // initialized constructor
        // input: table Class
        // output: none
    public TablePrinter (TableClass t){
        table = t;
    }
    
     // print whole matrix
        // input: table Class
        // returns: none
    public void printMatrix(TableClass t){
        
        for(int r = 0; r < t.getRow(); r++){
            for(int c = 0; c < t.getCol(); c++){
               System.out.print(t.myBox[r][c] + " ");
            } // end int c = 0
            System.out.println(" ");   
        } // end int r = 0
        
    }
    
     // print whole matrix reversed
        // input: table Class
        // returns: none
    public void printReverseMatrix(TableClass t){
        
        for(int r = t.getRow() - 1; r >= 0; r--){
            for(int c = t.getCol() - 1;c >= 0;c--){
               System.out.print(t.myBox[r][c] + " ");
            } // end int c = 0
            System.out.println(" ");   
        } // end int r = 0
        
    }
    
     // print whole matrix, with reversed rows
        // input: table Class
        // returns: none
    public void printReverseRows(TableClass t){
        
        for(int r = t.getRow() - 1; r >= 0; r--){
            for(int c = 0; c < t.getCol(); c++){
               System.out.print(t.myBox[r][c] + " ");
            } // end int c = 0
            System.out.println(" ");   
        } // end int r = 0
        
    }
    
     // print whole matrix, with reversed columns
        // input: table Class
        // returns: none
    public void printReverseColumns(TableClass t){
    
        for(int r = 0; r < t.getRow(); r++){
            for(int c = t.getCol() - 1; c >= 0; c--){
               System.out.print(t.myBox[r][c] + " ");
            } // end int c = 0
            System.out.println(" ");   
        } // end int r = 0
        
    }
    
     // print matrix columns
        // input: table Class, column number
        // returns: none
    public void printColumn(TableClass t, int col){
        
        System.out.println(" ");
        System.out.print("Column " + (col + 1) + ": ");
        
        for(int r = 0; r < t.getRow(); r++){
            System.out.print(t.myBox[r][col] + " ");
            
        }
    }
    
     // print matrix rows
        // input: table Class, row number
        // returns: none
     public void printRow(TableClass t, int row){
        
        System.out.println(" ");
        System.out.print("Row " + (row + 1) + ": ");
        
        for(int c = 0; c < t.getCol(); c++){
                System.out.print(t.myBox[row][c] + ", ");
        }
    }
    
} // end class
