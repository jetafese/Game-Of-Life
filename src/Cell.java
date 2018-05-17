/*************************************************************
 * Programmer: Joseph
 * 
 * Class: CS40S
 * 
 * Assignment: Game of Life
 * 
 * Purpose: Do all functionalities for the cell in a matrix
 * 
 * Input: none
 * 
 * Output: none
 *************************************************************/

public class Cell {
    
    private int row;           // particular row in table
    private int col;           // column in table
    private int neighbour;     // number o neighbours
    
    private int alive = 1;
    private int dead = 0;
    
    private int state;        // dead or alive
   
    /****************** Constructors ********************/
   
    /* 
    default constructor
       input: none
       output: none */
    
    public Cell (){
        state = dead;
        neighbour = 0;
    }
    
    /*
    initialized constructor
       input: state, number of neightbours
       output: none */
    
    public Cell (int s,              // state
                 int n){             // number of neighbours
        
        state = s;
        neighbour = n;
    }
    
    /* row getter
       input: none
       output: row # */
    
    /***************** Accessors *********************/
    
    /* state getter
       input: none
       output: state */
    
    public int getState (){
       return state;
    }
    
    /* 
    neighbour getter
       input: none
       output: # of neighbours */
    
    public int getNeighbours (){
        
       
       return neighbour;
    }
    
    /*********************** Mutators *********************/
    
    /* 
    neighbour setter
       input: # of neighbours
       output: none */
    
    public void setNeighbours (int n){
        
       neighbour = n;
    }
    
     /* 
    State  setter
       input: state
       output: none */
    
    public void setState (int s){
        
       state = s;
    }
    
    /* 
    get number of neighbours
       input: table, row, column
       output: # of neighbours */
    
    public void getNumberOfNeighbours (TableClass t, int r, int c){
     
        neighbour = 0;
        
        int up;
        int down;
        int left;
        int right;
        
        // for up
        if(r > 0){
            up = r - 1;
        } else{
            up = 99;
        }
        
        //for down
        if(r < 99){
            down = r + 1;
        }else{
            down = 0;
        }
        
        // for left
        if(c > 0){
            left = c - 1;
        } else{
            left = 99;
        }
        
        // for right
        if(c < 99){
            right = c + 1;
        }else{
            right = 0;
        }
        
              if (t.myBox[up][left] != 0) {
                neighbour++;
                //System.out.println(neighbour);
              }
              if (t.myBox[up][c] != 0) {
                neighbour++;
                //System.out.println(neighbour);
              }
              if (t.myBox[up][right] != 0) {
                neighbour++;
                //System.out.println(neighbour);
              }
              if (t.myBox[r][left] != 0) {
                neighbour++;
                //System.out.println(neighbour);
              }
              if (t.myBox[r][right] != 0) {
                neighbour++;
                //System.out.println(neighbour);
              }
              if (t.myBox[down][left] != 0) {
                neighbour++;
                //System.out.println(neighbour);
              }
              if (t.myBox[down][c] != 0) {
                neighbour++;
                //System.out.println(neighbour);
              }
              if (t.myBox[down][right] != 0) {
                neighbour++;
               // System.out.println(neighbour);
              }
            
             
          this.setNeighbours(neighbour);
          
          
    }
    
    /* 
    next cell value getter
       input: state, number of neighbours
       output: dead or alive */
    
    public int getNextCell (int n, int index){
        
        int state;   // dead
        
        if(index == 0){
            if(n == 3){
                state = 1;
            }
            else{
                state = 0;
            }
        }
        else{
            if(n == 3 || n == 2){
                
            state = 1;
            
            }else{
                state = 0;
            }
        
        }
        
        return state;
    }
    
} // end class
