package edu.kit.informatik.game;

public class Board {
    private final String[][] board;
    private final int rows;
    private final int columns;

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
     * Get amount of rows of the board
     * @return amount of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * Get amount of columns of the board
     * @return amount of columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Get the board as 2-dimensional String Array
     * @return get the board itself as 2-dimensional array
     */
    public String[][] getBoardString() {
        return board;
    }

    /**
     * Get the board state as String
     * @param row the row to get
     * @param column the column to get
     * @return get the board state as String
     */
    public String getBoardString(int row, int column) {
        if (row < rows && column < columns && row >= 0 && column >= 0)
            return board[row][column];
        else
            return "";
    }

    /**
     * Add a player to a specific field
     * @param row the row where to place the player
     * @param column the column where to place the player
     * @param plyName the name of the player
     */
    public void setBoardString(int row, int column, String plyName) {
        board[row][column] = plyName;
    }

    /**
     * Check if field is in the game board
     * @param row the row to check
     * @param column the row to check
     * @return true when field is in board
     */
    public boolean inGameBoard(int row, int column) {
        return !(row < 0 || row >= this.rows || column < 0 || column >= this.columns);
    }

    /**
     * Check if field is empty
     * @param row the row of the field
     * @param column the column of the field
     * @return true when empty, false when occupied
     */
    public boolean fieldEmpty(int row, int column) {
        return board[row][column].equals("** ");
    }
}
