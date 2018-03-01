package edu.kit.informatik.game;

import edu.kit.informatik.commands.WinValidator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class WinValidatorTest {
    private Board board;
    private Player player;

    @Before
    public void setUp() {
        board = new Board(18, 18);
        player = new Player(4);
    }

    @After
    public void tearDown() {
        board = null;
        player = null;
    }

    @Test
    public void checkDraw() {
    }

    @Test
    public void checkWin() {
    }

    @Test
    public void regexWinCheck() {
        String lineP1 = "** ** P2 P1 P1 P1 P1 P1 P1 ** ** ** ** ** ** ** ** ** ** ** ";
        String lineP4 = "** ** P2 P4 P4 P4 P4 P4 P4 P3 P4 P2 P4 P4 P4 P4 ** ** ** ** ";
        String out1 = WinValidator.regexWinCheck(lineP1);
        String out2 = WinValidator.regexWinCheck(lineP4);
        assertEquals("Regex win check P1", "P1 ", out1);
        assertEquals("Regex win check P4", "P4 ", out2);
    }
}
