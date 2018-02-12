package edu.kit.informatik;

class CommandHandler {
    /**
     * Handles all console commands
     * @param board the game board
     */
    static void handleCommands(Board board) {
        boolean running = true;
        while (running) {
            CommandRegex regex = new CommandRegex();

            String input = Terminal.readLine();
            String[] groups = regex.createGroups(input);
            String cmd = groups[0];

            if (cmd.matches("quit") && regex.hasNoParam(input)) {
                running = false;
            } else if (cmd.matches("print") && regex.hasNoParam(input)) {
                Terminal.printLine(board.print());
            } else if (cmd.matches("reset") && regex.hasNoParam(input)) {
                //TODO implement
            } else if (cmd.matches("rowprint") && regex.hasParam(input, 1)) {
                Terminal.printLine(board.linePrint(Integer.parseInt(groups[2]), PrintType.ROW));
            } else if (cmd.matches("colprint") && regex.hasParam(input, 1)) {
                Terminal.printLine(board.linePrint(Integer.parseInt(groups[2]), PrintType.COLUMN));
            } else if (cmd.matches("place") && regex.hasParam(input, 4)) {
                //TODO implement
            } else if (cmd.matches("state") && regex.hasParam(input, 2)) {
                //TODO implement
            } else {
                Terminal.printError("unknown command.");
            }
        }
    }
}
