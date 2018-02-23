package edu.kit.informatik.commands;

import edu.kit.informatik.formatter.*;
import edu.kit.informatik.game.Board;
import edu.kit.informatik.game.GameCore;
import edu.kit.informatik.game.Player;
import edu.kit.informatik.game.WinValidator;

class CommandHandler extends GameCore {
    private Board board;
    private Player player;

    /**
     * CommandHandler constructor
     * @param board the game board
     */
    CommandHandler(Board board, Player player) {
        this.board = board;
        this.player = player;
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
        return "OK"; //TODO returns "OK" after only after quit and not after setup because init runs the whole time...
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
        System.out.println("ok " + player);
        WinValidator validator = new WinValidator();
        boolean draw = validator.checkDraw(board);
        String winner = validator.checkWin(board);
        boolean noWin = winner.isEmpty();
        boolean valid1 = false;
        boolean valid2 = false;

        if (!draw && noWin) {
            if ((row1 != row2 || column1 != column2)
                    && board.inGameBoard(row1, column1) && board.fieldEmpty(row1, column1)
                    && board.inGameBoard(row2, column2) && board.fieldEmpty(row2, column2)) {
                board.setBoardString(row1, column1, player.getName());
                board.setBoardString(row2, column2, player.getName());
                player.next();
                return "OK";
            } else {
                return "Error, field is occupied.";
            }
        } else if (draw && noWin) {
            return "draw";
        } else {
            return winner + "wins";
        }
    }
}
