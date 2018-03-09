package edu.kit.informatik.commands;

import edu.kit.informatik.game.Board;
import edu.kit.informatik.game.GameCore;
import edu.kit.informatik.game.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandHandlerT3Test {
    private GameCore core;
    private Board board;
    private Player player;
    private CommandHandler handler;

    @Before
    public void setUp() {
        core = new GameCore();
        core.setup("torus", 20, 3);
        board = core.getBoard();
        player = core.getPlayer();
        handler = new CommandHandler(board, player);
    }

    @After
    public void tearDown() {
        core = null;
        board = null;
        handler = null;
        player = null;
    }

    @Test
    public void stateOf() {
        assertEquals("Move 1 P1", "OK", handler.placeAt(5, 5, 2, 1));
        assertEquals("Move 1 P2", "OK", handler.placeAt(9, 19, 1, 19));
        assertEquals("Move 1 P3", "OK", handler.placeAt(0, 0, 1, 1));
        assertEquals("State of", "P1", handler.stateOf(5,5));
        assertEquals("State of", "P2", handler.stateOf(9,19));
        assertEquals("State of", "P3", handler.stateOf(0,0));
    }

    @Test
    public void stateOfOOB() {
        assertEquals("State out of bounds", "**", handler.stateOf(-999,999));
    }

    @Test
    public void horizontalTorus() {
        assertEquals("Move 1 P1", "OK", handler.placeAt(5, 5, 2, 1));
        assertEquals("Move 1 P2", "OK", handler.placeAt(9, 19, 1, 19));
        assertEquals("Move 1 P3", "OK", handler.placeAt(0, 0, 0, 1));

        assertEquals("Move 2 P1", "OK", handler.placeAt(1, 2, 3, 1));
        assertEquals("Move 2 P3", "OK", handler.placeAt(2, 3, 3, 5));
        assertEquals("Move 2 P3", "OK", handler.placeAt(0, 2, 0, 3));

        assertEquals("Move 3 P1", "OK", handler.placeAt(5, 1, 4, 1));
        assertEquals("Move 3 P2", "OK", handler.placeAt(5, 3, 4, 7));
        assertEquals("Move 3 P3", "P3 wins", handler.placeAt(0, 4, 0, 19));

        assertEquals("Move 4 P1", "Error, the game is already over.", handler.placeAt(8, 8, 8, 9));
    }

    @Test
    public void verticalTorus() {
        assertEquals("Move 1 P1", "OK", handler.placeAt(5, 5, 2, 1));
        assertEquals("Move 1 P2", "OK", handler.placeAt(9, 19, 1, 19));
        assertEquals("Move 1 P3", "OK", handler.placeAt(0, 0, 1, 0));

        assertEquals("Move 2 P1", "OK", handler.placeAt(1, 2, 3, 1));
        assertEquals("Move 2 P3", "OK", handler.placeAt(2, 3, 3, 5));
        assertEquals("Move 2 P3", "OK", handler.placeAt(2, 0, 3, 0));

        assertEquals("Move 3 P1", "OK", handler.placeAt(5, 1, 4, 1));
        assertEquals("Move 3 P2", "OK", handler.placeAt(5, 3, 4, 7));
        assertEquals("Move 3 P3", "P3 wins", handler.placeAt(4, 0, 19, 0));

        assertEquals("Move 4 P1", "Error, the game is already over.", handler.placeAt(8, 8, 8, 9));
    }

    @Test
    public void diagonalTest() {
        assertEquals("Move 1 P1", "OK", handler.placeAt(5, 5, 2, 1));
        assertEquals("Move 1 P2", "OK", handler.placeAt(9, 19, 1, 19));
        assertEquals("Move 1 P3", "OK", handler.placeAt(0, 0, 1, 1));

        assertEquals("Move 2 P1", "OK", handler.placeAt(1, 2, 3, 1));
        assertEquals("Move 2 P3", "OK", handler.placeAt(2, 3, 3, 5));
        assertEquals("Move 2 P3", "OK", handler.placeAt(2, 2, 3, 3));

        assertEquals("Move 3 P1", "OK", handler.placeAt(5, 1, 4, 1));
        assertEquals("Move 3 P2", "OK", handler.placeAt(5, 3, 4, 7));
        assertEquals("Move 3 P3", "P3 wins", handler.placeAt(18, 18, 19, 19));

        assertEquals("Move 4 P1", "Error, the game is already over.", handler.placeAt(8, 8, 8, 9));
    }
}
