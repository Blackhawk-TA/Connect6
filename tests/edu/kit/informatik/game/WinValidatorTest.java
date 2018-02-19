package edu.kit.informatik.game;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class WinValidatorTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(edu.kit.informatik.game.WinValidator.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    private Board board;

    @org.junit.Before
    public void setUp() throws Exception {
        board = new Board(18, 18);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        board = null;
    }

    @org.junit.Test
    public void checkDraw() {
    }

    @org.junit.Test
    public void checkWin() {
    }
}
