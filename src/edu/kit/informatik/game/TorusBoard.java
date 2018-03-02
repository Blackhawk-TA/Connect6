package edu.kit.informatik.game;

import edu.kit.informatik.formatter.FormatType;
import edu.kit.informatik.formatter.LineFormat;

import java.util.List;

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

    /**
     * Win check for torus board horizontal and vertical
     * @param line the horizontal or vertical line
     * @return the torus line
     */
    public String lineCheck(String line) {
        return line + line;
    }

    /**
     * Win check for torus board diagonal lines
     * @param diagonal the initial diagonal
     * @param type diagonal type (bottom left to top right or top left to bottom right)
     * @return the torus line for win check
     */
    public String diagonalCheck(int row, int column, String diagonal, FormatType type) {
        LineFormat format = new LineFormat(this);
        StringBuilder torusDiagonal = new StringBuilder();
        String lastDiagonal;
        String nextDiagonal;
        String[][] board = this.getBoardString();

        return "";
    }
}
