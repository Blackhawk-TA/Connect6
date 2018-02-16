package edu.kit.informatik.game;

public class GameCore {
    //TODO regex for win lose ^([**\\s]*)(P1\s){6}([**\\s]*)$
    private Board board;
    private Player player;

    /**
     * Setup the game board
     * @param gameType the type, standard or torus
     * @param boardSize size of the board
     * @param playerNum amount of players
     */
    public void setup(String gameType, int boardSize, int playerNum) {
        //Set board mode to standard or torus
        if (gameType.matches("standard")) {
            board = new Board(boardSize, boardSize);
        } else {
            board = new TorusBoard(boardSize, boardSize);
        }

        player = new Player(playerNum);
    }

    /**
     * Get board class
     * @return the game board class
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Get player class
     * @return the player class
     */
    public Player getPlayer() {
        return player;
    }
}
