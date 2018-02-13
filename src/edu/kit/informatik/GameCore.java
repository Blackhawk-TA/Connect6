package edu.kit.informatik;

class GameCore {
    private String[][] board;
    private int rows;
    private int columns;

    /**
     * Constructor for GameBoard
     * @param board the GameBoard where the game happens
     */
    GameCore(Board board) {
        this.board = board.getBoard();
        this.rows = board.getRows();
        this.columns = board.getColumns();
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
     * Player occupies a field
     * @param row1 the row for the first field
     * @param column1 the column for the first field
     * @param row2 the row for the second field
     * @param column2 the column for the second field
     * @return Status after placing (valid, invalid, game over)
     */
    String placeAt(int row1, int column1, int row2, int column2) {
        return "PLACEHOLDER";
    }
}
