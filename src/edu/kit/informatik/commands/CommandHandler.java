package edu.kit.informatik.commands;

import edu.kit.informatik.game.Board;
import edu.kit.informatik.PrintType;

public class CommandHandler {
    /**
     * Print board
     * @param board the game board
     * @return formatted board as String
     */
    String print(Board board) {
        StringBuilder boardFormatted = new StringBuilder();
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                boardFormatted.append(board.getBoardString()[i][j]);
            }
            boardFormatted.append("\n");
        }
        return boardFormatted.toString();
    }

    /**
     * Prints either row or column depending on type
     * @param board the game board
     * @param n number of the row/column to print
     * @param type defines if print mode is row or column
     * @return board row/column as String
     */
    String linePrint(Board board, int n, PrintType type) {
        StringBuilder boardFormatted = new StringBuilder();
        for (int i = 0; i < board.getBoardString().length; i++) {
            if (type == PrintType.ROW)
                boardFormatted.append(board.getBoardString()[n][i]);
            else if (type == PrintType.COLUMN)
                boardFormatted.append(board.getBoardString()[i][n]);
        }
        return boardFormatted.toString();
    }

    /**
     * Get state of specific field
     * @param board the game board
     * @param row the row of the board
     * @param column the column of the board
     * @return registered entry at requested field
     */
    String stateOf(Board board, int row, int column) {
        return board.getBoardString()[row][column];
    }

    /**
     * Player occupies a field
     * @param board the game board
     * @param row1 the row for the first field
     * @param column1 the column for the first field
     * @param row2 the row for the second field
     * @param column2 the column for the second field
     * @return Status after placing (valid, invalid, game over)
     */
    String placeAt(Board board, int row1, int column1, int row2, int column2) {
        return "PLACEHOLDER";
    }
}
