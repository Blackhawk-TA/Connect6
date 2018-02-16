package edu.kit.informatik.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.game.*;

public class InitHandler {
    /**
     * Check init params and apply them
     * @param args the init params
     * @return true if init successful
     */
    public static boolean init(String[] args) {
        //Format String array to normal String
        StringBuilder argsFormatted = new StringBuilder();
        for (String arg: args) {
            argsFormatted.append(arg);
        }
        String input = argsFormatted.toString();

        //Check regex
        CommandRegex regex = new CommandRegex(true);
        String[] groups = regex.createGroups(input);

        if (regex.hasParam(groups, 3)) {
            String gameType = groups[0]; //Get first parameter as String
            int boardSize = regex.getParam(groups, 1);
            int playerNum = regex.getParam(groups, 2);

            GameCore core = new GameCore(); //TODO maybe setter und getter?

            //Set board mode to standard or torus
            if (gameType.matches("standard")) {
                core.setBoard(new Board(boardSize, boardSize));
            } else {
                core.setBoard(new TorusBoard(boardSize, boardSize));
            }

            core.setPlayer(new Player(playerNum));

            return true;
        } else {
            Terminal.printError(" invalid start parameters.");
            return false;
        }
    }
}
