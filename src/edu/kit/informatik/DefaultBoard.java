package edu.kit.informatik;

class DefaultBoard {
    private String[][] board;
    private int rows;
    private int columns;

    /**
     * @param rows amount of rows the board should have
     * @param columns amount of columns the board should have
     */
    DefaultBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        board = new String[rows][columns];  //Create an empty game board

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = "- ";
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
     * Get state of specific field
     * @param row the row of the board
     * @param column the column of the board
     * @return registered entry at requested field
     */
    String stateOf(int row, int column) {
        return board[row][column];
    }
}
