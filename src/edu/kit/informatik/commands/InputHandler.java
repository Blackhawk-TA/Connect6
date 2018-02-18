package edu.kit.informatik.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.game.Board;
import edu.kit.informatik.formatter.*;

public class InputHandler extends CommandHandler {

    /**
     * InputHandler constructor
     * @param board the game board
     */
    InputHandler(Board board) {
        super(board);
    }

    /**
     * Handles all console commands
     * @param args the start parameters
     */
    public void inputs(String[] args) {
        CommandRegex regex = new CommandRegex("command"); //Group arg inputs start at index 3
        boolean running = true;

        while (running) {
            String input = Terminal.readLine();
            String[] groups = regex.createGroups(input);
            String arg = groups[1]; //The main command of the argument (such as "print", "quit")

            if (regex.isValid(input)) {
                if (arg.matches("quit") && regex.hasParam(groups, 0)) {
                    running = false;
                }
                else if (arg.matches("print") && regex.hasParam(groups, 0)) {
                    Terminal.printLine(super.print());
                }
                else if (arg.matches("reset") && regex.hasParam(groups, 0)) {
                    Terminal.printLine(super.reset(args));
                }
                else if (arg.matches("rowprint") && regex.hasParam(groups, 1)) {
                    Terminal.printLine(super.linePrint(regex.getParam(groups, 0), FormatType.ROW));
                }
                else if (arg.matches("colprint") && regex.hasParam(groups, 1)) {
                    Terminal.printLine(super.linePrint(regex.getParam(groups, 0), FormatType.COLUMN));
                }
                else if (arg.matches("place") && regex.hasParam(groups, 4)) {
                    Terminal.printLine(super.placeAt(regex.getParam(groups, 0), regex.getParam(groups, 1),
                            regex.getParam(groups, 2), regex.getParam(groups, 3)));
                }
                else if (arg.matches("state") && regex.hasParam(groups, 2)) {
                    Terminal.printLine(super.stateOf(regex.getParam(groups, 0), regex.getParam(groups, 1)));
                }
                else {
                    Terminal.printError("unknown command.");
                }
            }
            else {
                Terminal.printError("command does not fit pattern.");
            }
        }
    }
}
