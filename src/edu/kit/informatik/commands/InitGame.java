package edu.kit.informatik.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.game.*;

public class InitGame {
    private Player player;
    private Board board;
    private BoardType type;
    private int initStage;
    private CommandRegex regex;
    private CommandRegex regexNumOnly;

    public InitGame() {
        initStage = 0;
        type = BoardType.NONE;
        regex = new CommandRegex(false); //Group arg inputs start at index 3
        regexNumOnly = new CommandRegex(true); //Group arg inputs start at index 0
    }

    boolean init(String[] groups) {
        boolean initialized = false;
        String arg = groups[1]; //The main command of the argument (such as "print", "quit")

        switch (initStage) {
            case 0: //First init stage
                if (regex.getPattern().matcher(arg).find()) {
                    if (arg.matches("standard") && regex.hasParam(groups, 0)) { //TODO maybe set stuff in command handler
                        type = BoardType.STANDARD;
                        initStage++;
                    } else if (arg.matches("torus") && regex.hasParam(groups, 0)) {
                        type = BoardType.TORUS;
                        initStage++;
                    } else {
                        Terminal.printError("invalid board type.");
                    }
                    break;
                }
            case 1:
                if (regexNumOnly.getPattern().matcher(arg).find()) {
                    int boardSize = InputHandler.getInputNumber(groups);

                    if (boardSize > 17 && boardSize < 21 && boardSize % 2 == 0) {
                        if (type == BoardType.STANDARD) {
                            board = new Board(boardSize, boardSize);
                            initStage++;
                        } else if (type == BoardType.TORUS) {
                            board = new TorusBoard(boardSize, boardSize);
                            initStage++;
                        } else
                            Terminal.printError("No board type set, this shouldn't even happen.");
                    } else {
                        Terminal.printError("invalid size.");
                    }
                } else {
                    Terminal.printError("unknown command, board size expected.");
                }
                break;
            case 2: //Finish initialisation
                if (regexNumOnly.getPattern().matcher(arg).find()) {
                    int playerAmount = InputHandler.getInputNumber(groups);

                    if (playerAmount > 1 && playerAmount < 5) {
                        player = new Player(playerAmount); //TODO init global
                        initialized = true;
                    }
                    break;
                }
        }
        return initialized;
    }

    //TODO rather set those in GameCore (setter in GameCore)
    public Player getPlayer() {
        return player;
    }

    public Board getBoard() {
        return board;
    }

    public BoardType getType() {
        return type;
    }
}
