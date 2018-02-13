package edu.kit.informatik.game;

public class Player {
    private int id;
    private int amount;

    /**
     * Player constructor
     * @param amount total amount of players
     */
    public Player(int amount) {
        this.id = 0;
        this.amount = amount;
    }

    /**
     * Switches to the next player
     */
    void next() {
        if (id < amount)
            id++;
        else
            id = 0;
    }
}

