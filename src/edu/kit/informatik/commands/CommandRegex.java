package edu.kit.informatik.commands;

import java.util.regex.*;

public class CommandRegex {
    /*
     * Group modifier for input parameters
     * 0 when input is number only and the parameter is the first entered arg
     * 3 when input is a normal command like "print" or "place 5;5;5;5"
     */
    private int groupMod;
    private Pattern pattern;

    public CommandRegex(boolean numbersOnly) {
        if (numbersOnly) {
            pattern = Pattern.compile("^(\\d*)$");
            groupMod = 1;
        } else {
            pattern = Pattern.compile("^([a-z]+)(\\s)?(\\d*)?;?(\\d*)?;?(\\d*)?;?(\\d*)$");
            groupMod = 3;
        }
    }

    /**
     * Get regex pattern
     * @return regex pattern
     */
    public Pattern getPattern() {
        return pattern;
    }

    /**
     * Check if a command has n amount of parameters
     * @param groups the regex groups of the command
     * @param n amount of parameters the command should have
     * @return true if amount of parameters is n
     */
    public boolean hasParam(String[] groups, int n) {
        int counter = 0;

        for (int i = groupMod; i < groups.length; i++) {
            if (!groups[i].isEmpty())
                counter++; //TODO check that to many parameters are wrong as well such as state 5;5;5
        }

        return counter == n;
    }

    /**
     * Get groups from the chat command
     * Group 1: command
     * Group 2: whitespace
     * Group 3: param 1
     * Group 4: param 2
     * Group 5: param 3
     * Group 6: param 4
     * @param arg input command
     * @return array of groups
     */
    public String[] createGroups(String arg) {
        String[] groups = new String[7];
        Matcher matcher = pattern.matcher(arg);

        if (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.printf("Capture Group Number: %s, Captured Text: '%s'%n", i, matcher.group(i)); //TODO REMOVE
                groups[i] = matcher.group(i);
            }
        }
        return groups;
    }

    /**
     * Gets the parameters from the command and converts it to int
     * @param groups the entered command split up in groups
     * @param index index of the param (0-3)
     * @return array of parameters
     */
    public int getParam(String[] groups, int index) {
        int param = -1;

        if (!groups[index + groupMod].isEmpty())
            param = Integer.parseInt(groups[index + groupMod]);

        return param;
    }
}
