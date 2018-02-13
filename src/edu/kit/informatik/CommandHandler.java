package edu.kit.informatik;

class CommandHandler {
    /**
     * Handles all console commands
     * @param board the game board
     */
    static void handleCommands(Board board) {
        GameCore core = new GameCore(board);
        boolean running = true;
        while (running) {
            CommandRegex regex = new CommandRegex();

            String input = Terminal.readLine();
            String[] groups = regex.createGroups(input);
            String arg = groups[1]; //The main command of the argument (such as "print", "quit")

            if (arg.matches("quit") && regex.hasParam(groups, 0)) {
                running = false;
            }
            else if (arg.matches("print") && regex.hasParam(groups, 0)) {
                Terminal.printLine(core.print());
            }
            else if (arg.matches("reset") && regex.hasParam(groups, 0)) {
                //TODO implement
            }
            else if (arg.matches("rowprint") && regex.hasParam(groups, 1)) {
                Terminal.printLine(core.linePrint(regex.getParam(arg,0), PrintType.ROW));
            }
            else if (arg.matches("colprint") && regex.hasParam(groups, 1)) {
                Terminal.printLine(core.linePrint(regex.getParam(arg,0), PrintType.COLUMN));
            }
            else if (arg.matches("place") && regex.hasParam(groups, 4)) {
                //TODO implement
            }
            else if (arg.matches("state") && regex.hasParam(groups, 2)) {
                //TODO implement
            }
            else {
                Terminal.printError("unknown command.");
            }
        }
    }
}
