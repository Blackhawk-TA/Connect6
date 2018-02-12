package edu.kit.informatik;

public class Main {
    /**
     * Main method
     * @param args console input, not used!
     */
    public static void main(String[] args) {
        Board board = new Board(15, 15);
        CommandHandler.handleCommands(board);
    }
}
