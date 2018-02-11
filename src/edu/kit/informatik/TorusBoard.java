package edu.kit.informatik;

class TorusBoard extends Board {
    /**
     * @param rows amount of rows the board should have
     * @param columns amount of columns the board should have
     */
    TorusBoard(int rows, int columns) {
        super(rows, columns);
    }

    /**
     * Check if field is in the game board (for Torus)
     * @param row the row to check
     * @param column the row to check
     * @return true when field is in board
     */
    @Override
    boolean inGameBoard(int row, int column) {
        return true; //TODO Implement
    }
}
