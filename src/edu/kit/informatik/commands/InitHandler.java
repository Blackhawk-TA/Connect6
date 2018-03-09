package edu.kit.informatik.commands;

import edu.kit.informatik.RegexHandler;
import edu.kit.informatik.game.GameCore;
import edu.kit.informatik.Terminal;

public class InitHandler {
    /**
     * Check init params and apply them
     * @param args the init params
     */
    public static void init(String[] args) {
        //Format String array to normal String
        StringBuilder argsFormatted = new StringBuilder();
        for (String arg: args) {
            argsFormatted.append(arg).append(" ");
        }
        String input = argsFormatted.toString().trim();

        //Check regex
        RegexHandler regex = new RegexHandler("init");
        String[] groups = regex.createGroups(input);

        if (regex.hasParam(groups, 3)) {
            String gameType = groups[1]; //Get first parameter as String
            int boardSize = regex.getParam(groups, 1);
            int playerNum = regex.getParam(groups, 2);

            GameCore core = new GameCore();
            core.setup(gameType, boardSize, playerNum);

            InputHandler handler = new InputHandler(core.getBoard(), core.getPlayer());
            handler.inputs(args);
        } else {
            Terminal.printError("invalid start parameters.");
        }
    }
}
