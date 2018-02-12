package edu.kit.informatik;

import java.util.regex.*;

class CommandRegex {
    private final Pattern pattern = Pattern.compile("^([a-z]+(\\s)*)(\\d*)?;?(\\d*)?;?(\\d*)?;?(\\d*)$");

    /**
     * Check if a command has any parameters
     * @param arg input command to check
     * @return true when command has parameters
     */
    boolean hasNoParam(String arg) {
        String[] groups = createGroups(arg);

        for (int i = 1; i < groups.length; i++) {
            if (pattern.matcher(arg).find() && !groups[i].isEmpty())
                return false;
        }

        return true;
    }

    /**
     * Check if a command has n amount of parameters
     * @param arg input command to check
     * @param n amount of parameters the command should have
     * @return true if amount of parameters is n
     */
    boolean hasParam(String arg, int n) {
        String[] groups = createGroups(arg);
        int counter = 0;

        for (int i = 2; i < groups.length; i++) {
            if (pattern.matcher(arg).find() && !groups[i].isEmpty())
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
        String[] groups = new String[4];
        Matcher matcher = pattern.matcher(arg);

        if (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.printf("Capture Group Number: %s, Captured Text: '%s'%n", i, matcher.group(i));
            }
        }
        return groups;
    }
}
