package edu.kit.informatik.commands;

import java.util.regex.*;

public class CommandRegex {
    //TODO CHECK IF GROUP 2 (space) is existing
    /*
     * Group modifier for input parameters
     * 1 when input is for game init, params start at index 1
     * 3 when input is a normal command like "print" or "place 5;5;5;5", params start at index 3
     * 6 when input is a winCheck, param which shows who won starts at 6
     */
    private int groupMod;
    private int groupNum; //Amount of expected groups in a regex
    private Pattern pattern;

    /**
     * Regex Constructor
     * @param mode the regex mode, "init" for start param check, "command" for input check, "winCheck" for win check.
     */
    public CommandRegex(String mode) {
        switch (mode) {
            case "init":
                pattern = Pattern.compile("^(standard|torus)\\s(18|20)\\s([2-4])$"); //pattern for init param
                groupMod = 1;
                groupNum = 4;
                break;
            case "command":
                pattern = Pattern.compile("^([a-z]+)(\\s)?(\\d*)?;?(\\d*)?;?(\\d*)?;?(\\d*)$"); //pattern for normal cmd
                groupMod = 3;
                groupNum = 7;
                break;
            case "winCheck":
                pattern = Pattern.compile("([**\\s]*)((P1\\s){6}|(P2\\s){6}|(P3\\s){6}|(P4\\s){6})([**\\s]*)$");
                groupMod = 6;
                groupNum = 6;
                break;
            default:
                break;
        }
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
            if (counter == n && !groups[i].isEmpty()) {
                return false;
            }

            if (groups[i] != null && !groups[i].isEmpty())
                counter++;
        }

        return counter == n;
    }

    /**
     * Get groups from the chat command
     * @param arg input command
     * @return array of groups
     */
    public String[] createGroups(String arg) {
        String[] groups = new String[groupNum];
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
     * @param index index of the param
     * @return array of parameters
     */
    public int getParam(String[] groups, int index) {
        int param = -1;

        if (!groups[index + groupMod].isEmpty())
            param = Integer.parseInt(groups[index + groupMod]);

        return param;
    }
}
