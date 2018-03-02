package edu.kit.informatik.game;

public class TorusBoard extends Board {
    /**
     * @param rows amount of rows the board should have
     * @param columns amount of columns the board should have
     */
    TorusBoard(int rows, int columns) {
        super(rows, columns);
    }

    /**
     * Check if field is in the game board (for Torus always true)
     * @param row the row to check
     * @param column the row to check
     * @return true when field is in board
     */
    @Override
    public boolean inGameBoard(int row, int column) {
        return true;
    }

    /**
     * Get the board state as String
     * @param row the row to get
     * @param column the column to get
     * @return get the board state as String
     */
    @Override
    public String getBoardString(int row, int column) {
        int torusRow = toTorus(row);
        int torusCol = toTorus(column);
        return super.getBoardString(torusRow, torusCol);
    }

    /**
     * Add a player to a specific field
     * @param row the row where to place the player
     * @param column the column where to place the player
     * @param plyName the name of the player
     */
    @Override
    public void setBoardString(int row, int column, String plyName) {
        int torusRow = toTorus(row);
        int torusCol = toTorus(column);
        super.setBoardString(torusRow, torusCol, plyName);
    }

    /**
     * Check if field is empty
     * @param row the row of the field
     * @param column the column of the field
     * @return true when empty, false when occupied
     */
    @Override
    public boolean fieldEmpty(int row, int column) {
        int torusRow = toTorus(row);
        int torusCol = toTorus(column);
        return super.fieldEmpty(torusRow, torusCol);
    }

    /**
     * This function converts inputs placed outside to field to existing fields in torus
     * @param n the row or column to convert depending on input
     * @return position in torus board
     */
    private int toTorus(int n) {
        if (n < 0) {
            return this.getRows() - (Math.abs(n) % this.getRows());
        } else {
            return n % this.getRows();
        }
    }
}
