package edu.kit.informatik.commands;

import edu.kit.informatik.formatter.*;
import edu.kit.informatik.game.*;

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

            boardFormatted.deleteCharAt(boardFormatted.length() - 1);
            if (i < board.getRows() - 1) {
                boardFormatted.append("\n");
            }
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
        return format.toLine(n, type).trim();
    }

    /**
     * Reset the game with the already chosen start parameters
     * @param args the start parameters
     */
    void reset(String[] args) {
        gameOver = false;
        InitHandler.init(args);
    }

    /**
     * Get state of specific field
     * @param row the row of the board
     * @param column the column of the board
     * @return registered entry at requested field
     */
    String stateOf(int row, int column) {
        String boardString = board.getBoardString(row, column);
        if (!boardString.isEmpty())
            return board.getBoardString(row, column).trim();
        else
            return "Error, input out of bounds.";
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

        //Modified function parameters because they can't be modified due to checkstyle, makes  the code much better...
        int row1Mod = row1;
        int col1Mod = column1;
        int row2Mod = row2;
        int col2Mod = column2;

        if (board instanceof TorusBoard) {
            row1Mod = ((TorusBoard) board).toTorus(row1Mod);
            col1Mod = ((TorusBoard) board).toTorus(col1Mod);
            row2Mod = ((TorusBoard) board).toTorus(row2Mod);
            col2Mod = ((TorusBoard) board).toTorus(col2Mod);
        }

        if (!gameOver) {
            if ((row1Mod != row2Mod || col1Mod != col2Mod)
                    && board.inGameBoard(row1Mod, col1Mod) && board.fieldEmpty(row1Mod, col1Mod)
                    && board.inGameBoard(row2Mod, col2Mod) && board.fieldEmpty(row2Mod, col2Mod)) {
                board.setBoardString(row1Mod, col1Mod, player.getName());
                board.setBoardString(row2Mod, col2Mod, player.getName());

                draw = WinValidator.checkDraw(board);
                winner1 = WinValidator.checkWin(board, row1Mod, col1Mod);
                winner2 = WinValidator.checkWin(board, row2Mod, col2Mod);
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
