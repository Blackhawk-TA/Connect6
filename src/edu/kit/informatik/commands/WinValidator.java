package edu.kit.informatik.commands;

import edu.kit.informatik.RegexHandler;
import edu.kit.informatik.formatter.*;
import edu.kit.informatik.game.Board;

public class WinValidator {
    /**
     * Check if game ends as draw
     * @param board the game board
     * @return true when draw, false if not
     */
    static boolean checkDraw(Board board) {
        int rows = board.getRows();
        int columns = board.getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board.getBoardString()[i][j].equals("** ")) {
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
//        String diagLB = format.toLine(board, FormatType.DIAG_BOTTOMLEFT);
//        String diagLT = format.toLine(board, FormatType.DIAG_TOPLEFT);

        String horizontalWin = regexWinCheck(horizontal);
        String verticalWin = regexWinCheck(vertical);
//        String diagLBWin = regexWinCheck(diagLB);
//        String diagLTWin = regexWinCheck(diagLT);

        //Check for win
        if (!horizontalWin.isEmpty()) {
            return horizontalWin;
        } else if (!verticalWin.isEmpty()) {
            return verticalWin;
//        } else if (!diagLBWin.isEmpty()) {
//            return diagLBWin;
//        } else if (!diagLTWin.isEmpty()) {
//            return diagLTWin;
        } else {
            return ""; //no winner
        }
    }

    /**
     * Check for horizontal or vertical win
     * @param line horizontal or vertical line depending on input
     * @return empty String if no winner, else return winner
     */
    private static String regexWinCheck(String line) {
        RegexHandler regex = new RegexHandler("command"); //Group arg inputs start at index 3
        String[] groups = regex.createGroups(line);
        if (regex.hasParam(groups, 1)) {
            return groups[6]; //The regex group index to get the player who won
        }
        return ""; //no winner
    }
}