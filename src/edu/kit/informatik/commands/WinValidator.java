package edu.kit.informatik.commands;

import edu.kit.informatik.RegexHandler;
import edu.kit.informatik.formatter.*;
import edu.kit.informatik.game.Board;
import edu.kit.informatik.game.TorusBoard;

public class WinValidator {
    /**
     * Check if game ends as draw
     * @param board the game board
     * @return true when draw, false if not
     */
    public static boolean checkDraw(Board board) { //TODO remove public
        int rows = board.getRows();
        int columns = board.getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board.getBoardString(i, j).equals("** ")) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if a player has won the game
     * @param board the game board
     * @param row the row where the player was placed
     * @param column the column where the player was placed
     * @return empty String if no winner, else return winner
     */
    static String checkWin(Board board, int row, int column) {
        LineFormat format = new LineFormat(board);
        String horizontal = format.toLine(row, FormatType.ROW);
        String vertical = format.toLine(column, FormatType.COLUMN);
        String diagLB;
        String diagLT;

        if (board instanceof TorusBoard) {
            horizontal = ((TorusBoard) board).lineCheck(horizontal);
            vertical = ((TorusBoard) board).lineCheck(vertical);
            diagLB = ((TorusBoard) board).diagonalCheck(row, column, FormatType.DIAG_BOTTOMLEFT);
            diagLT = ((TorusBoard) board).diagonalCheck(row, column, FormatType.DIAG_TOPLEFT);
        } else {
            horizontal = format.toLine(row, FormatType.ROW);
            vertical = format.toLine(column, FormatType.COLUMN);
            diagLB = format.getDiagonalLine(board, row, column, FormatType.DIAG_BOTTOMLEFT);
            diagLT = format.getDiagonalLine(board, row, column, FormatType.DIAG_TOPLEFT);
        }

        String horizontalWin = regexWinCheck(horizontal);
        String verticalWin = regexWinCheck(vertical);
        String diagLBWin = regexWinCheck(diagLB);
        String diagLTWin = regexWinCheck(diagLT);

        //Check for win
        if (!horizontalWin.isEmpty()) {
            return horizontalWin;
        } else if (!verticalWin.isEmpty()) {
            return verticalWin;
        } else if (!diagLBWin.isEmpty()) {
            return diagLBWin;
        } else if (!diagLTWin.isEmpty()) {
            return diagLTWin;
        } else {
            return ""; //no winner
        }
    }

    /**
     * Check for horizontal or vertical win
     * @param line horizontal or vertical line depending on input
     * @return empty String if no winner, else return winner
     */
    public static String regexWinCheck(String line) { //TODO change to private
        RegexHandler regex = new RegexHandler("winCheck");
        String[] groups = regex.createGroups(line);
        for (int i = groups.length - 1; i > 1; i--) {
            if (groups[i] != null && !groups[i].isEmpty()) {
                return groups[i];
            }
        }
        return ""; //no winner
    }
}
