package edu.kit.informatik.commands;

import edu.kit.informatik.formatter.*;
import edu.kit.informatik.game.Board;
import edu.kit.informatik.game.GameCore;
import edu.kit.informatik.game.Player;

class CommandHandler extends GameCore {
    private final Board board;
    private final Player player;
    private boolean gameOver = false;

    /**
     * CommandHandler constructor
     * @param board the game board
     * @param player the player object
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
                boardFormatted.append(board.getBoardString(i, j));
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
     */
    void reset(String[] args) {
        gameOver = false;
        InitHandler handler = new InitHandler();
        handler.init(args);
    }

    /**
     * Get state of specific field
     * @param row the row of the board
     * @param column the column of the board
     * @return registered entry at requested field
     */
    String stateOf(int row, int column) {
        return board.getBoardString(row, column);
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
        boolean draw;
        String winner1;
        String winner2;

        if (!gameOver) {
            if ((row1 != row2 || column1 != column2)
                    && board.inGameBoard(row1, column1) && board.fieldEmpty(row1, column1)
                    && board.inGameBoard(row2, column2) && board.fieldEmpty(row2, column2)) {
                board.setBoardString(row1, column1, player.getName());
                board.setBoardString(row2, column2, player.getName());

                draw = WinValidator.checkDraw(board);
                winner1 = WinValidator.checkWin(board, row1, column1);
                winner2 = WinValidator.checkWin(board, row2, column2);
            } else {
                return "Error, at least one field doesn't exist or is already occupied.";
            }

            if (!draw && winner1.isEmpty() && winner2.isEmpty()) {
                player.next();
                return "OK";
            } else if (draw && winner1.isEmpty() && winner2.isEmpty()) {
                gameOver = true;
                return "draw";
            } else {
                gameOver = true;
                return player.getName() + "wins";
            }
        } else {
            return "Error, the game is already over.";
        }
    }
}
