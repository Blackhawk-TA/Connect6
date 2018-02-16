package edu.kit.informatik.game;

public class GameCore {
    //TODO regex for win lose ^([**\\s]*)(P1\s){6}([**\\s]*)$
    private Board board;
    private Player player;

    public void setup(String gameType, int boardSize, int playerNum) {
        //Set board mode to standard or torus
        if (gameType.matches("standard")) {
            board = new Board(boardSize, boardSize);
        } else {
            board = new TorusBoard(boardSize, boardSize);
        }

        player = new Player(playerNum);
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer() {
        return player;
    }
}
