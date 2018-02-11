package edu.kit.informatik;

class Player {
    private int id;

    /**
     * Player constructor
     */
    Player() {
        this.id = 1;
    }

    /**
     * Switches to the next player
     * @param amount total amount of players
     */
    void next(int amount) {
        if (id < amount)
            id++;
        else
            id = 1;
    }
}

