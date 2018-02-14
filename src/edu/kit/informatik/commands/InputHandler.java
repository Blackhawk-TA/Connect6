package edu.kit.informatik.commands;

import edu.kit.informatik.game.Board;
import edu.kit.informatik.*;

public class InputHandler {
    /**
     * Handles all console commands
     */
    public static void inputs() {
        InitGame initGame = new InitGame();
        CommandHandler handler = new CommandHandler();
        CommandRegex regex = new CommandRegex(false); //Group arg inputs start at index 3
        boolean running = true;

        while (running) {
            Board board = initGame.getBoard();
            String input = Terminal.readLine();
            String[] groups = regex.createGroups(input);
            String arg = groups[1]; //The main command of the argument (such as "print", "quit")

            //Checking if game has been initialized
            if (initGame.init(groups)) {
                if (arg.matches("quit") && regex.hasParam(groups, 0)) {
                    running = false;
                }
                else if (arg.matches("print") && regex.hasParam(groups, 0)) {
                    Terminal.printLine(handler.print(board));
                }
                else if (arg.matches("reset") && regex.hasParam(groups, 0)) {
                    //TODO implement
                }
                else if (arg.matches("rowprint") && regex.hasParam(groups, 1)) {
                    Terminal.printLine(handler.linePrint(board, regex.getParam(groups, 0), PrintType.ROW));
                }
                else if (arg.matches("colprint") && regex.hasParam(groups, 1)) {
                    Terminal.printLine(handler.linePrint(board, regex.getParam(groups, 0), PrintType.COLUMN));
                }
                else if (arg.matches("place") && regex.hasParam(groups, 4)) {
                    //TODO implement
                }
                else if (arg.matches("state") && regex.hasParam(groups, 2)) {
                    Terminal.printLine(handler.stateOf(board, regex.getParam(groups, 0), regex.getParam(groups, 1)));
                }
                else {
                    Terminal.printError("unknown command.");
                }
            } else {
                initGame.init(groups);
            }
        }
    }

    /**
     * Handle inital number input for player amount and board size
     * @param groups input splitted to groups
     * @return input converted to string
     */
    public static int getInputNumber(String[] groups) {
        int number = -1;
        CommandRegex regex = new CommandRegex(true); //Group arg inputs start at index 0

        if (regex.hasParam(groups, 0)) {
            number = regex.getParam(groups, 0);
        }

        return number;
    }
}
