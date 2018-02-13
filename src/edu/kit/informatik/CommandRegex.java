package edu.kit.informatik;

import java.util.regex.*;

class CommandRegex {
    private final Pattern pattern = Pattern.compile("^([a-z]+)(\\s)(\\d*)?;?(\\d*)?;?(\\d*)?;?(\\d*)$");
    private final int groupMod = 3; //group modifier, used to create the parameter groups from 3 to 6

    /**
     * Check if a command has n amount of parameters
     * @param groups the regex groups of the command
     * @param n amount of parameters the command should have
     * @return true if amount of parameters is n
     */
    boolean hasParam(String[] groups, int n) {
        int counter = 0;

        for (int i = groupMod; i < groups.length; i++) {
            if (!groups[i].isEmpty())
                counter++;
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
    String[] createGroups(String arg) {
        String[] groups = new String[7];
        Matcher matcher = pattern.matcher(arg);

        if (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.printf("Capture Group Number: %s, Captured Text: '%s'%n", i, matcher.group(i));
                groups[i] = matcher.group(i);
            }
        }
        return groups;
    }

    /**
     * Gets the parameters from the command and converts it to int
     * @param arg the entered command
     * @param index index of the param (0-3)
     * @return array of parameters
     */
    int getParam(String arg, int index) {
        String[] groups = createGroups(arg);
        int param = -1;

        if (!groups[index + groupMod].isEmpty())
            param = Integer.parseInt(groups[index + groupMod]);

        return param;
    }
}
