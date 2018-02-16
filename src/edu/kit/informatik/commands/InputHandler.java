package edu.kit.informatik.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.game.GameCore;

public class InputHandler {
    /**
     * Handles all console commands
     */
    public static void inputs() {
        CommandRegex regex = new CommandRegex(false); //Group arg inputs start at index 3

        boolean running = true;

        while (running) {
            GameCore core = new GameCore();
            CommandHandler handler = new CommandHandler(core.getBoard()); //TODO not working
            String input = Terminal.readLine();
            String[] groups = regex.createGroups(input);
            String arg = groups[1]; //The main command of the argument (such as "print", "quit")

            //Checking if game has been initialized
            if (arg.matches("quit") && regex.hasParam(groups, 0)) {
                running = false;
            }
            else if (arg.matches("print") && regex.hasParam(groups, 0)) {
                Terminal.printLine(handler.print());
            }
            else if (arg.matches("reset") && regex.hasParam(groups, 0)) {
                //TODO implement
            }
            else if (arg.matches("rowprint") && regex.hasParam(groups, 1)) {
                Terminal.printLine(handler.linePrint(regex.getParam(groups, 0), PrintType.ROW));
            }
            else if (arg.matches("colprint") && regex.hasParam(groups, 1)) {
                Terminal.printLine(handler.linePrint(regex.getParam(groups, 0), PrintType.COLUMN));
            }
            else if (arg.matches("place") && regex.hasParam(groups, 4)) {
                //TODO implement
            }
            else if (arg.matches("state") && regex.hasParam(groups, 2)) {
                Terminal.printLine(handler.stateOf(regex.getParam(groups, 0), regex.getParam(groups, 1)));
            }
            else {
                Terminal.printError("unknown command.");
            }
        }
    }
}
