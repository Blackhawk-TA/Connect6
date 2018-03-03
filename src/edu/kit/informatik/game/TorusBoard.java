package edu.kit.informatik.game;

import edu.kit.informatik.formatter.FormatType;
import edu.kit.informatik.formatter.LineFormat;

public class TorusBoard extends Board {
    /**
     * @param rows amount of rows the board should have
     * @param columns amount of columns the board should have
     */
    TorusBoard(int rows, int columns) {
        super(rows, columns);
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
     * This function converts inputs placed outside to field to existing fields in torus
     * @param n the row or column to convert depending on input
     * @return position in torus board
     */
    public int toTorus(int n) {
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
     * @param row the row where to create the check line from
     * @param column the column where to create the check line from
     * @param type the check type,
     * @return the torus line for win check
     */
    public String diagonalCheck(int row, int column, FormatType type) {
        LineFormat format = new LineFormat(this);
        Board bigBoard = format.toBigBoard(this);

        String check1 = format.getDiagonalLine(bigBoard, row, column, type);
        String check2 = format.getDiagonalLine(bigBoard, row, column + this.getColumns(), type);
        String check3 = format.getDiagonalLine(bigBoard, row + this.getRows(), column, type);
        String check4 = format.getDiagonalLine(bigBoard, row + this.getRows(), column + this.getColumns(), type);

        return check1 + check2 + check3 + check4;
    }
}
