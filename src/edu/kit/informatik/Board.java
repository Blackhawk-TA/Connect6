package edu.kit.informatik;

class Board {
    private String[][] board;
    private int rows;
    private int columns;

    /**
     * @param rows amount of rows the board should have
     * @param columns amount of columns the board should have
     */
    Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        board = new String[rows][columns];  //Create an empty game board

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = "** ";
            }
        }
    }

    /**
     * @return get the board itself as 2-dimensional array
     */
    String[][] getBoard() {
        return board;
    }

    /**
     * Print board
     * @return board as String
     */
    String print() {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board.append(this.board[i][j]);
            }
            board.append("\n");
        }
        return board.toString();
    }

    /**
     * Prints either row or column depending on type
     * @param n number of the row/column to print
     * @param type defines if print mode is row or column
     * @return board row/column as String
     */
    String linePrint(int n, PrintType type) {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (type == PrintType.ROW)
                board.append(this.board[n][i]);
            else if (type == PrintType.COLUMN)
                board.append(this.board[i][n]);
        }
        return board.toString();
    }

    /**
     * Get state of specific field
     * @param row the row of the board
     * @param column the column of the board
     * @return registered entry at requested field
     */
    String stateOf(int row, int column) {
        return board[row][column];
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

    /**
     * Occupy a field
     * @param row the row to occupy
     * @param column the column to occupy
     * @return Status after placing (valid, invalid, game over)
     */
    String placeAt(int row, int column) {
        return "PLACEHOLDER";
    }
}
