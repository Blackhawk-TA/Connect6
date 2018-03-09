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
            String boardStringRow = board.getBoardString(n, i);
            String boardStringCol = board.getBoardString(i, n);
            if (type == FormatType.ROW && !boardStringCol.isEmpty())
                boardFormatted.append(boardStringRow);
            else if (type == FormatType.COLUMN && !boardStringCol.isEmpty())
                boardFormatted.append(boardStringCol);
            else
                return "Error, input out of bounds.";
        }
        return boardFormatted.toString();
    }

    /**
     * Convert the diagonals to normal lines to check winner
     * @param board the game board
     * @param row the row of the field
     * @param column the column of the field
     * @param type the type of diagonals, DIAGLB for bottom left to top right, DIAGLT for top left to bottom right
     * @return the diagonals as line
     */
    public String getDiagonalLine(Board board, int row, int column, FormatType type) {
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
                diagonalLine.append(board.getBoardString(modRow, modCol));
                modCol++;
                if (modRow < board.getRows() - 1)
                    modRow++;
            }
        } else {
            while (modCol < board.getColumns() - 1) {
                modCol++;
                if (modRow > 0)
                    modRow--;
            }

            for (int i = board.getRows() - 1; i > 0; i--) {
                diagonalLine.append(board.getBoardString(modRow, modCol));
                modCol--;
                if (modRow < board.getRows() - 1)
                    modRow++;
            }
        }
        return diagonalLine.toString();
    }

    /**
     * For torus board diagonal check, creates a board 4 times bigger filled 4x with the game board
     * @param board the game board
     * @return the big board
     */
    public Board toBigBoard(Board board) {
        Board bigBoard = new Board(board.getRows() * 2, board.getColumns() * 2);
        for (int i = 0; i < bigBoard.getRows(); i++) {
            int k = i;
            if (i >= board.getRows() - 1) {
                k -= board.getRows();
            }
            for (int j = 0; j < bigBoard.getColumns(); j++) {
                int l = j;
                if (j >= board.getColumns() - 1) {
                    l -= board.getColumns();
                }
                bigBoard.setBoardString(i, j, board.getBoardString(k, l));
            }
        }

        return bigBoard;
    }
}
