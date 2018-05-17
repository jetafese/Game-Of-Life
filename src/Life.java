
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;


/**
 * This program is a very simple implementation of John H. Conway's famous "Game of Life".
 * In this game, the user sets up a board that contains a grid of cells, where each cell can be 
 * either "living" or "dead".  Once the board is set up and the game is started, it runs itself.
 * The board goes through a sequence of "generations."  In each generation, every cell can
 * change its state from living to dead or vice versa, depending on the number of neighbors
 * that it has.  The rules are:
 * 
 *     1.  If a cell is dead, and if it has exactly 3 living neighbors, then the cell comes
 *         to life; if the number of neighbors is less than or greater than 3, then the dead 
 *         cell remains dead.  (That is, three living neighbors give birth to a new cell.)
 *         
 *     2.  If a cell is alive, and if it has exactly 2 or 3 living neighbors, then the cell
 *         remains alive; otherwise, it dies.  (If a cell has 0 or 1 neighbors, it dies of
 *         loneliness; if it has 4 or more neighbors, it dies of overcrowding.)
 *         
 * It is important that all these changes happen simultaneously in each generation.  When
 * counting neighbors, the 8 cells that are next to a given cell horizontally, vertically,
 * and diagonally are considered.  Ideally, the board would be infinite.  On a finite board,
 * special consideration must be given to cells that lie along the boundary.  In this program, 
 * the approach is to consider the left edge to be next to the right edge and the top edge
 * to be next to the bottom edge.  This effectively turns the board into a "torus" (the shape
 * of the surface of a doughnut), which is finite but has no boundary.
 * 
 * This class has a main() routine, so it can be run as a stand-alone application.  The main
 * program simply opens a window that shows a Life board with some control buttons along the
 * bottom.  The user creates the initial board by clicking and dragging on the board to create
 * living cells.  Clicking and dragging while holding down the right mouse button will change
 * living cells back to dead.  There is also a button that will set the state of each cell to
 * be a random value.
 */
public class Life extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

    /**
     * Main program opens a window whose content pane is a JPanel belonging to class Life.
     */
    
    public static void main(String[] args) {
        
    JFrame f = new JFrame("Life");
    JPanel p = new Life();
    f.setContentPane(p);
    f.setDefaultCloseOperation(3);
    f.pack();
    f.setLocation(100, 50);
    f.setVisible(true);
  }

    Random random = new Random();

    private final int GRID_SIZE = 100;  // Number of squares along each side of the board
                                        // (Should probably not be less than 10 or more than 200,)
    private MosaicPanel display;  // Displays the game to the user..  White squares are alive; black squares are dead.
    private Timer timer;  // Drives the game when the user presses the "Start" button.

    private JButton  stopGoButton;  // Button for starting and stopping the running of the game.
    private JButton  nextButton;    // Button for computing just the next generation.
    private JButton  randomButton;  // Button for filling the board randomly with each cell having a 25% chance of  being alive.
    private JButton  clearButton;   // Button for clearing the board, that is setting all the cells to "dead".
    private JButton  quitButton;    // Button for ending the program.

        TableClass table = new TableClass(GRID_SIZE, GRID_SIZE);
        Cell cell = new Cell();
        //TablePrinter printTable = new TablePrinter(table);
        TableLoader load = new TableLoader(table);
    
    /**
     * Create a life game board, initially empty.  The number of cells on each side of the grid is GRID_SIZE.
     */
    public Life() {
       
    setLayout(new BorderLayout(3, 3));
    setBackground(Color.GRAY);
    setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
    int cellSize = 6;
    this.display = new MosaicPanel(GRID_SIZE, GRID_SIZE, cellSize, cellSize);
    if (cellSize < 7) {
      this.display.setGroutingColor(Color.GRAY);
    }
    this.display.setUse3D(true);
    add(this.display, "Center");
    JPanel bottom = new JPanel();
    add(bottom, "South");
    this.clearButton = new JButton("Clear");
    this.stopGoButton = new JButton("Start");
    this.quitButton = new JButton("Quit");
    this.nextButton = new JButton("One Step");
    this.randomButton = new JButton("Random Fill");
    bottom.add(this.stopGoButton);
    bottom.add(this.nextButton);
    bottom.add(this.randomButton);
    bottom.add(this.clearButton);
    bottom.add(this.quitButton);
    this.stopGoButton.addActionListener(this);
    this.clearButton.addActionListener(this);
    this.quitButton.addActionListener(this);
    this.randomButton.addActionListener(this);
    this.nextButton.addActionListener(this);
    this.display.addMouseListener(this);
    this.display.addMouseMotionListener(this);
    this.timer = new Timer(50, this);
    }

    
    /**
     * Compute the next generation of cells.  The "alive" array is modified to reflect the
     * state of each cell in the new generation.  (Note that this method does not actually
     * draw the new board; it only sets the values in the "alive" array.  The board is
     * redrawn in the showBoard() method.)
     */
    private void doFrame() { // Compute the new state of the Life board.
        /* put your code for computing the next generation here
        *   you'll probably want to call showBoard at the end of this method to re-draw the grid
        */
   
        nextGen();
        showBoard();
        //printTable.printMatrix(table);
        //System.out.println();
        //System.out.println();
        
    } // end of doFrame


    /**
     *  Sets the color of every square in the display to show whether the corresponding
     *  cell on the Life board is alive or dead. 
     */
    private void showBoard() {
    
    this.display.setAutopaint(true);
        display.setAutopaint(false);  // For efficiency, prevent redrawing of individual squares.
        for (int r = 0; r < GRID_SIZE; r++) {
            for (int c = 0; c < GRID_SIZE; c++) {
                if (table.myBox[r][c] != 0)
                    display.setColor(r,c,Color.RED);
                else
                    display.setColor(r,c,null);  // Shows the background color, black.
            }
        }
        display.setAutopaint(true);  // Redraw the whole board, and turn on drawing of individual squares.
    }


    /**
     * Respond to an ActionEvent from one of the control buttons or from the timer.
     */
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();  // The object that caused the event.
        if (src == quitButton) { // End the program.
            System.exit(0);
        }
        else if (src == clearButton) {  // Clear the board.
            display.clear();
            table.myBox = new int [GRID_SIZE][GRID_SIZE];
        }
        else if (src == nextButton) {  // Compute and display the next generation.
            doFrame();
            showBoard();
        }
        else if (src == stopGoButton) {  // Start or stop the game, depending on whether or not it is currenty running.
            if (timer.isRunning()) {  // If the game is currently running, stop it.
                timer.stop();  // This stops the game by turning off the timer that drives the game.
                clearButton.setEnabled(true);  // Some buttons are disabled while the game is running.
                randomButton.setEnabled(true);
                nextButton.setEnabled(true);
                stopGoButton.setText("Start");  // Change text of button to "Start", since it can be used to start the game again.
            }
            else {  // If the game is not currently running, start it.
                timer.start();  // This starts the game by turning the timee that will drive the game.
                clearButton.setEnabled(false);  // Buttons that modify the board are disabled while the game is running.
                randomButton.setEnabled(false);
                nextButton.setEnabled(false);
                stopGoButton.setText("Stop"); // Change text of button to "Stop", since it can be used to stop the game.
            }
        }
        else if (src == randomButton) { // Fill the board randomly.
            // add code here to fill the grid with random values
            // each cell will have one of two possible values, alive or dead
            // you wil have to consider the data type of the matrix here
            // what value represents alive and what represents dead? think!!
            table.myBox = load.loadTableRandomly(table);
            showBoard();
        }
        else if (src == timer) {  // Each time the timer fires, a new frame is computed and displayed.
            doFrame();
            showBoard();
        }
    }


    /**
     * The square containing the mouse comes to life or, if the right-mouse button is down, dies.
     */
    public void mousePressed(MouseEvent e) {
        if (timer.isRunning())
            return;
        int row = display.yCoordToRowNumber(e.getY());
        int col = display.xCoordToColumnNumber(e.getX());
        if (row >= 0 && row < display.getRowCount() && col >= 0 && col < display.getColumnCount()) {
            if (e.isMetaDown() || e.isControlDown()) {
                display.setColor(row,col,null);
                table.myBox[row][col] = 0;
            }
            else {
                display.setColor(row,col,Color.RED);
                table.myBox[row][col] = 1;
            }
        }
    }
    
    /* Does the creation of the new board, just encapsulates it*/
   
    private void nextGen(){
        
        int [][] a = new int [100][100];
        
        for(int r = 0; r < 100; r++){
            for(int c = 0; c < 100; c++){
                cell.getNumberOfNeighbours(table, r, c);
                a[r][c] = 
                    cell.getNextCell(cell.getNeighbours(),table.myBox[r][c]);
            }
        }
        this.table.myBox = a;
    } // end nextGen


    /**
     * The square containing the mouse comes to life or, if the right-mouse button is down, dies.
     */
    public void mouseDragged(MouseEvent e) {
        mousePressed(e);  // Dragging the mouse into a square has the same effect as clicking in that square.
    }

    public void mouseClicked(MouseEvent e) { }  // Other methods required by the MouseListener and MouseMotionListener interfaces.
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseMoved(MouseEvent e) { }


}
