package edu.kit.informatik.game;

public class Player {
    private int id;
    private int amount;

    /**
     * Player constructor
     * @param amount total amount of players
     */
    Player(int amount) {
        this.id = 0;
        this.amount = amount;
    }

    /**
     * Switches to the next player
     */
    public void next() {
        if (id < amount)
            id++;
        else
            id = 0;
    }

    /**
     * Get the player name like it is presented at the field (such as "P1 " or "P2 ")
     * @return the player name
     */
    public String getName() {
        int plyNum = id + 1;
        return "P" + plyNum + " ";
    }
}

