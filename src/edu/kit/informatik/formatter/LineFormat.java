package edu.kit.informatik.formatter;

import edu.kit.informatik.game.Board;
import edu.kit.informatik.game.GameCore;

public class LineFormat extends GameCore {
    private Board board;

    /**
     * LineFormat constructor
     * @param board the game board
     */
    public LineFormat(Board board) {
        this.board = board;
    }

    /**
     * Formats either row or column depending on type to a String
     * @param n number of the row/column to print
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
     * Gets all rows/columns depending on type input
     * @param n amount of lines to get
     * @param type format enum type, ROW for get rows, COLUMN for get columns
     * @return array of all rows/columns as formatted String
     */
    public String[] getLines(int n, FormatType type) {
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = toLine(i, type);
        }
        return lines;
    }
}
