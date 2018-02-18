package edu.kit.informatik.commands;

import edu.kit.informatik.formatter.*;
import edu.kit.informatik.game.Board;
import edu.kit.informatik.game.GameCore;
import edu.kit.informatik.game.Player;
import edu.kit.informatik.game.WinValidator;

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
     * Formats either row or column depending on type to a String
     * @param n number of the row/column to print
     * @param type defines if print mode is row or column
     * @return board row/column as String
     */
    String linePrint(int n, FormatType type) {
        LineFormat format = new LineFormat(board);
        return format.toLine(n, type);
    }

    /**
     * Reset the game with the already chosen start parameters
     * @param args the start parameters
     * @return OK when successful
     */
    String reset(String[] args) {
        InitHandler handler = new InitHandler();
        handler.init(args);
        return "OK";
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
        Player player = super.getPlayer();
        WinValidator validator = new WinValidator();
        boolean draw = validator.checkDraw(board);
        String winner = validator.checkWin(board);
        boolean noWin = winner.isEmpty();

        if (!draw && noWin) {
            //Place at field
            if (board.inGameBoard(row1, column1) && board.fieldEmpty(row1, column1)
                    && board.inGameBoard(row2, column2) && board.fieldEmpty(row2, column2)) {
                board.setBoardString(row1, column1, player.getName());
                board.setBoardString(row2, column2, player.getName());
                player.next(); //Switch to next player
                return "OK";
            } else {
                return "Error, field occupied.";
            }
        } else if (draw && noWin) {
            return "draw";
        } else if (!draw && !noWin) {
            return winner + "wins";
        } else {
            return "Error, unexpected exception.";
        }
    }
}
