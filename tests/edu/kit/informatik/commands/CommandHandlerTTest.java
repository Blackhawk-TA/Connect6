package edu.kit.informatik.commands;

import edu.kit.informatik.formatter.FormatType;
import edu.kit.informatik.game.Board;
import edu.kit.informatik.game.GameCore;

import edu.kit.informatik.game.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CommandHandlerTTest {
    private GameCore core;
    private Board board;
    private Player player;
    private CommandHandler handler;

    @Before
    public void setUp() {
        core = new GameCore();
        core.setup("torus", 20, 2);
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
    public void print() {
    }

    @Test
    public void linePrint() {
        String exOut = "** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ";
        String out1 = handler.linePrint(0, FormatType.ROW);
        String out2 = handler.linePrint(0, FormatType.COLUMN);
        assertEquals("Row correct", exOut, out1);
        assertEquals("Column correct", exOut, out2);
    }

    @Test
    public void reset() {
    }

    @Test
    public void stateOf() {
    }

    @Test
    public void horizontalTorus() {
        assertEquals("Move 1 P1", "OK", handler.placeAt(0, 0, 0, 1));
        assertEquals("Move 1 P2", "OK", handler.placeAt(1, 1, 2, 1));

        assertEquals("Move 2 P1", "OK", handler.placeAt(0, 2, 0, 3));
        assertEquals("Move 2 P2", "OK", handler.placeAt(1, 2, 3, 1));

        assertEquals("Move 3 P1", "OK", handler.placeAt(0, 4, 9, 9));
        assertEquals("Move 3 P2", "OK", handler.placeAt(5, 1, 4, 1));

        assertEquals("Move 4 P1", "P1 wins", handler.placeAt(0, 18, 0, 19));
        assertEquals("Move 4 P2", "Error, the game is already over.", handler.placeAt(8, 8, 8, 9));
    }

    @Test
    public void verticalTorus() {
        assertEquals("Move 1 P1", "OK", handler.placeAt(0, 19, 1, 19));
        assertEquals("Move 1 P2", "OK", handler.placeAt(1, 1, 2, 1));

        assertEquals("Move 2 P1", "OK", handler.placeAt(2, 19, 3, 19));
        assertEquals("Move 2 P2", "OK", handler.placeAt(1, 2, 3, 1));

        assertEquals("Move 3 P1", "OK", handler.placeAt(4, 19, 9, 9));
        assertEquals("Move 3 P2", "OK", handler.placeAt(5, 1, 4, 1));

        assertEquals("Move 4 P1", "P1 wins", handler.placeAt(5, 19, 8, 19));
        assertEquals("Move 4 P2", "Error, the game is already over.", handler.placeAt(8, 8, 8, 9));
    }
}
