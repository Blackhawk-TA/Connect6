package edu.kit.informatik.game;

import edu.kit.informatik.commands.WinValidator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WinValidatorTest {
    private Board board;

    @Before
    public void setUp() {
        board = new Board(18, 18);
    }

    @After
    public void tearDown() {
        board = null;
    }

    @Test
    public void checkDraw() {
        String[][] ex = {
            {"P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 ","P2 ","P2 ","P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 "},
            {"P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 ","P4 ","P4 ","P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 "},
            {"P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 ","P2 ","P2 ","P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 "},
            {"P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 ","P4 ","P4 ","P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 "},
            {"P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 ","P2 ","P2 ","P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 "},
            {"P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 ","P4 ","P4 ","P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 "},
            {"P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 ","P2 ","P2 ","P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 "},
            {"P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 ","P4 ","P4 ","P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 "},
            {"P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 ","P2 ","P2 ","P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 "},
            {"P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 ","P4 ","P4 ","P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 "},
            {"P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 ","P2 ","P2 ","P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 "},
            {"P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 ","P4 ","P4 ","P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 "},
            {"P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 ","P2 ","P2 ","P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 "},
            {"P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 ","P4 ","P4 ","P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 "},
            {"P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 ","P2 ","P2 ","P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 "},
            {"P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 ","P4 ","P4 ","P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 "},
            {"P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 ","P2 ","P2 ","P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 "},
            {"P3 ","P3 ","P3 ","P3 ","P3 ","P4 ","P4 ","P4 ","P4 ","P4 ","P1 ","P1 ","P1 ","P1 ","P1 ","P2 ","P2 ","P2 "}
        };

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                board.setBoardString(i, j, ex[i][j]);
            }
        }

        assertTrue("Draw", WinValidator.checkDraw(board));
    }

    @Test
    public void regexWinCheck() {
        String lineP1 = "** ** P2 P1 P1 P1 P1 P1 P1 ** ** ** ** ** ** ** ** ** ** ** ";
        String lineP4 = "** ** P2 P4 P4 P4 P4 P4 P4 P3 P4 P2 P4 P4 P4 P4 ** ** ** ** ";
        assertEquals("Regex win check P1", "P1 ", WinValidator.regexWinCheck(lineP1));
        assertEquals("Regex win check P4", "P4 ", WinValidator.regexWinCheck(lineP4));
    }
}
