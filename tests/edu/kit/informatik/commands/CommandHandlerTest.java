package edu.kit.informatik.commands;

import edu.kit.informatik.formatter.FormatType;
import edu.kit.informatik.game.Board;
import edu.kit.informatik.game.GameCore;

import edu.kit.informatik.game.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CommandHandlerTest {
    private GameCore core;
    private Board board;
    private Player player;
    private CommandHandler handler;

    @Before
    public void setUp() {
        core = new GameCore();
        core.setup("standard", 20, 4);
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
    public void placeAt() {
    }
}
