package edu.kit.informatik.game;

public class GameCore {
    private Board board;
    private Player player;

    public GameCore(Board board, Player player) {
        this.board = board;
        this.player = player;
    }

    public Board getBoard() {
        return board;
    }
}
