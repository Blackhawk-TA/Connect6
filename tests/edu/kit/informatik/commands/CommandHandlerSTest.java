package edu.kit.informatik.commands;

import edu.kit.informatik.formatter.FormatType;
import edu.kit.informatik.game.Board;
import edu.kit.informatik.game.GameCore;
import edu.kit.informatik.game.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandHandlerSTest {
    private GameCore core;
    private Board board;
    private Player player;
    private CommandHandler handler;

    @Before
    public void setUp() {
        core = new GameCore();
        core.setup("standard", 18, 2);
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
    public void linePrint() {
        handler.placeAt(0, 0, 0, 5);
        String exOut1 = "P1 ** ** ** ** P1 ** ** ** ** ** ** ** ** ** ** ** ** ";
        String exOut2 = "P1 ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ";
        assertEquals("Row correct", exOut1, handler.linePrint(0, FormatType.ROW));
        assertEquals("Column correct", exOut2, handler.linePrint(0, FormatType.COLUMN));
    }

    @Test
    public void stateOf() {
        handler.placeAt(5, 5, 0, 0);
        handler.placeAt(3, 3, 1, 0);
        assertEquals("State of", "P1 ", handler.stateOf(5,5));
        assertEquals("State of", "** ", handler.stateOf(1,1));
        assertEquals("State of", "P2 ", handler.stateOf(1,0));
    }

    @Test
    public void horizontal() {
        assertEquals("Move 1 P1", "OK", handler.placeAt(0, 0, 0, 1));
        assertEquals("Move 1 P2", "OK", handler.placeAt(1, 1, 2, 1));

        assertEquals("Move 2 P1", "OK", handler.placeAt(0, 2, 0, 3));
        assertEquals("Move 2 P2", "OK", handler.placeAt(1, 2, 3, 1));

        assertEquals("Move 3 P1", "OK", handler.placeAt(0, 4, 9, 9));
        assertEquals("Move 3 P2", "OK", handler.placeAt(5, 1, 4, 1));

        assertEquals("Move 4 P1", "P1 wins", handler.placeAt(0, 7, 0, 5));
        assertEquals("Move 4 P2", "Error, the game is already over.", handler.placeAt(8, 8, 8, 9));
    }

    @Test
    public void vertical() {
        assertEquals("Move 1 P1", "OK", handler.placeAt(0, 17, 1, 17));
        assertEquals("Move 1 P2", "OK", handler.placeAt(1, 1, 2, 1));

        assertEquals("Move 2 P1", "OK", handler.placeAt(2, 17, 3, 17));
        assertEquals("Move 2 P2", "OK", handler.placeAt(1, 2, 3, 1));

        assertEquals("Move 3 P1", "OK", handler.placeAt(4, 17, 9, 9));
        assertEquals("Move 3 P2", "OK", handler.placeAt(5, 1, 4, 1));

        assertEquals("Move 4 P1", "P1 wins", handler.placeAt(5, 17, 9, 17));
        assertEquals("Move 4 P2", "Error, the game is already over.", handler.placeAt(8, 8, 8, 9));
    }

    @Test
    public void checkDraw() {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j+=2) {
                if (i == board.getColumns() - 1 && j == board.getRows() - 2)
                    assertEquals("Last move", "draw", handler.placeAt(i, j, i, j + 1));
                else
                    assertEquals("Valid move", "OK", handler.placeAt(i, j, i, j + 1));
            }
        }
    }
}
