# C211_Large_Number
A project for the INFO-C211 Fall 23 class.

The project implements two classes: LargeNumber and TestNumber. The first class implements a large integer number of unlimited size and a few arithmetic operations to manipulate it. The second one performs
some testing of the class. The class LargeNumber uses an ArrayList to store the digits of the number.




//phase 3 with a new class named as Board
//Charlie Kinnett
//FA23-SB-INFO-C211-19523

public class Board {
    private LargeNumberHelper[][] board;
    private int rows;
    private int cols;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        initializeBoard();
    }


    public LargeNumberHelper getValueAt(int row, int col) {
        return board[row][col];
    }

    public void setValueAt(int row, int col, LargeNumberHelper value) {
        board[row][col] = value;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

   
}

