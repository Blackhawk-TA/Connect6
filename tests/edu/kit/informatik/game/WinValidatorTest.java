package edu.kit.informatik.game;

import edu.kit.informatik.commands.WinValidator;

public class WinValidatorTest {
    private Board board;
    private Player player;

    @org.junit.Before
    public void setUp() {
        board = new Board(18, 18);
        player = new Player(4);
    }

    @org.junit.After
    public void tearDown() {
        board = null;
        player = null;
    }

    @org.junit.Test
    public void checkDraw() {
    }

    @org.junit.Test
    public void checkWin() {
    }
}
