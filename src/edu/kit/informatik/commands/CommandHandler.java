package edu.kit.informatik.commands;

import edu.kit.informatik.game.Board;
import edu.kit.informatik.game.GameCore;

class CommandHandler extends GameCore {
    private Board board;

    /**
     * CommandHandler constructor
     * @param board the game board
     */
    CommandHandler(Board board) {
        this.board = board;
    }

    /**
     * Print board
     * @return formatted board as String
     */
    String print() {
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
     * @param n number of the row/column to print
     * @param type defines if print mode is row or column
     * @return board row/column as String
     */
    String linePrint(int n, PrintType type) {
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
     * @param row the row of the board
     * @param column the column of the board
     * @return registered entry at requested field
     */
    String stateOf(int row, int column) {
        return board.getBoardString()[row][column];
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
