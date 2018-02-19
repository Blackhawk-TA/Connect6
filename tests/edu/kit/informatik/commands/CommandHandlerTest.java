package edu.kit.informatik.commands;

import edu.kit.informatik.formatter.FormatType;
import edu.kit.informatik.game.Board;
import edu.kit.informatik.game.GameCore;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class CommandHandlerTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(CommandHandler.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    private GameCore core;
    private Board board;
    private CommandHandler handler;

    @Before
    public void setUp() throws Exception {
        core = new GameCore();
        core.setup("standard", 20, 4);
        board = core.getBoard();
        handler = new CommandHandler(board);
    }

    @After
    public void tearDown() throws Exception {
        core = null;
        board = null;
        handler = null;
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
