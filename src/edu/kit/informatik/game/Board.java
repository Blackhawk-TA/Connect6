package edu.kit.informatik.game;

public class Board {
    private String[][] board;
    private int rows;
    private int columns;

    /**
     * @param rows amount of rows the board should have
     * @param columns amount of columns the board should have
     */
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        this.board = new String[rows][columns];  //Create an empty game board

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = "** ";
            }
        }
    }

    /**
     * @return get the board itself as 2-dimensional array
     */
    public String[][] getBoardString() {
        return board;
    }

    /**
     * get amount of rows of the board
     * @return amount of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * get amount of columns of the board
     * @return amount of columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Check if field is in the game board
     * @param row the row to check
     * @param column the row to check
     * @return true when field is in board
     */
    boolean inGameBoard(int row, int column) {
        return !(row < 0 || row >= this.rows || column < 0 || column >= this.columns);
    }
}
