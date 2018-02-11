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
     * Get the player id
     * @return current player id
     */
    int getId() {
        return id;
    }

    /**
     * Change the player id
     * @param id new player id
     */
    void setId(int id) {
        this.id = id;
    }
}

