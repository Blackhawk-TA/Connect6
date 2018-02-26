package edu.kit.informatik.formatter;

import edu.kit.informatik.game.Board;
import edu.kit.informatik.game.GameCore;

public class LineFormat extends GameCore {
    private final Board board;

    /**
     * LineFormat constructor
     * @param board the game board
     */
    public LineFormat(Board board) {
        this.board = board;
    }

    /**
     * Formats either row or column depending on type to a String
     * @param n index of the row/column to print
     * @param type defines if print mode is row or column
     * @return board row/column as String
     */
    public String toLine(int n, FormatType type) {
        StringBuilder boardFormatted = new StringBuilder();
        for (int i = 0; i < board.getBoardString().length; i++) {
            if (type == FormatType.ROW)
                boardFormatted.append(board.getBoardString()[n][i]);
            else if (type == FormatType.COLUMN)
                boardFormatted.append(board.getBoardString()[i][n]);
        }
        return boardFormatted.toString();
    }

    /**
     * Convert the diagonals to normal lines to check winner
     * @param row the row of the field
     * @param column the column of the field
     * @param type the type of diagonals, DIAGLB for bottom left to top right, DIAGLT for top left to bottom right
     * @return the diagonals as line
     */
    public String getDiagonalLine(int row, int column, FormatType type) {
        StringBuilder diagonalLine = new StringBuilder();
        int modRow = row;
        int modCol = column;

        if (type == FormatType.DIAG_TOPLEFT) {
            while (modCol > 0) {
                modCol--;
                if (modRow > 0)
                    modRow--;
            }

            for (int i = 0; i < board.getRows() - 1; i++) {
                diagonalLine.append(board.getBoardString()[modRow][modCol]);
                modCol++;
                if (modRow < board.getRows() - 1)
                    modRow++;
            }
        } else {
            while (modCol < board.getColumns() - 1) {
                modCol++;
                if (modRow < board.getRows() - 1)
                    modRow++;
            }

            for (int i = board.getRows() - 1; i > 0; i--) {
                diagonalLine.append(board.getBoardString()[modRow][modCol]);
                modCol--;
                if (modRow > 0)
                    modRow--;
            }
        }
        return diagonalLine.toString();
    }
}
