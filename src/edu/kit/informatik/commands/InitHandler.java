package edu.kit.informatik.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.game.*;

public class InitHandler {
    private void init(String[] args) {
        String input = arrayToString(args);

        //Check regex
        CommandRegex regex = new CommandRegex(true);
        String[] groups = regex.createGroups(input);
        if (regex.hasParam(groups, 3)) {
            //String gameType = regex.getParam(groups, 0); TODO not working because getParam returns int
            int boardSize = regex.getParam(groups, 1);
            int playerNum = regex.getParam(groups, 2);

            Board board = new Board(boardSize, boardSize); //Check if torus or not
            Player player = new Player(playerNum);
            GameCore core = new GameCore(board, player);

        } else {
            Terminal.printError("invalid start parameters.");
        }
    }

    private String arrayToString(String[] args) {
        StringBuilder argsFormatted = new StringBuilder();
        for (String arg: args) {
            argsFormatted.append(arg);
        }
        return argsFormatted.toString();
    }
}
