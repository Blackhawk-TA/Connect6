package edu.kit.informatik.game;

public class GameCore {
    //TODO regex for win lose ^([**\\s]*)(P1\s){6}([**\\s]*)$
    private Board board;
    private Player player;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
