package edu.kit.informatik;

import edu.kit.informatik.commands.InitHandler;
import edu.kit.informatik.commands.InputHandler;

public class Main {
    /**
     * Main method
     * @param args console input, not used!
     */
    public static void main(String[] args) {
        if (InitHandler.init(args)) {
            InputHandler.inputs();
        }
    }
}
