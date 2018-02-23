package edu.kit.informatik.game;

import edu.kit.informatik.commands.CommandRegex;
import edu.kit.informatik.formatter.*;

public class WinValidator {
    /**
     * Check if game ends as draw
     * @return true when draw, false if not
     */
    public boolean checkDraw(Board board) {
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
     * @return empty String if no winner, else return winner
     * @param board the game board
     */
    public String checkWin(Board board) {
        return ""; //TODO remove
        /*LineFormat format = new LineFormat(board);
        String[] horizontal = format.getLines(board.getRows(), FormatType.ROW);
        String[] vertical = format.getLines(board.getColumns(), FormatType.COLUMN);
        String[] diagLB = format.getDiagLines(board, FormatType.DIAG_BOTTOMLEFT);
        String[] diagLT = format.getDiagLines(board, FormatType.DIAG_TOPLEFT);

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
        }*/
    }

    /**
     * Check for horizontal or vertical win
     * @param lines horizontal or vertical lines depending on input
     * @return empty String if no winner, else return winner
     */
    private String regexWinCheck(String[] lines) {
        CommandRegex regex = new CommandRegex("command"); //Group arg inputs start at index 3
        for (String line: lines) {
            String[] groups = regex.createGroups(line);
            if (regex.hasParam(groups, 1)) {
                return groups[6]; //The regex group index to get the player who won
            }
        }
        return ""; //no winner
    }
}
