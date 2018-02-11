package edu.kit.informatik;

class Commands {
    /**
     * Handles all console commands
     * @param board the game board
     */
    static void handleCommands(Board board) {
        boolean running = true;
        while (running) {
            String input = Terminal.readLine();
            String[] inputParam = input.split(" "); //split command name from parameters

            switch (input) {
                case "quit":
                    running = false;
                    break;
                case "print":
                    Terminal.printLine(board.print());
                    break;
                case "reset":
                    //TODO implement
                    break;
                default:
                    if (!inputParam[1].isEmpty() && inputParam[2].isEmpty()) {
                        String[] param = inputParam[1].split(";"); //store parameters in array
                        switch (inputParam[0]) {
                            case "rowprint":
                                Terminal.printLine(board.linePrint(Integer.parseInt(inputParam[1]), PrintType.ROW));
                                break;
                            case "colprint":
                                Terminal.printLine(board.linePrint(Integer.parseInt(inputParam[1]), PrintType.COLUMN));
                                break;
                            case "place":
                                if (!param[0].isEmpty() && !param[1].isEmpty() && param[2].isEmpty())
                                    Terminal.printLine(board.placeAt(
                                            Integer.parseInt(param[0]), Integer.parseInt(param[1])));
                                else
                                    Terminal.printError("don't add unknown parameters.");
                                break;
                            case "state":
                                if (!param[0].isEmpty() && !param[1].isEmpty() && param[2].isEmpty())
                                    Terminal.printLine(board.stateOf(
                                            Integer.parseInt(param[0]), Integer.parseInt(param[1])));
                                else
                                    Terminal.printError("don't add unknown parameters.");
                                break;
                            default:
                                Terminal.printError("don't add unknown parameters.");
                                break;
                        }
                    } else {
                        Terminal.printError("invalid command.");
                    }
                    break;
            }
        }
    }
}
