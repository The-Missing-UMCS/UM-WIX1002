package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q5.Q5A.util;

public class ParticipantInfoParser {
    public static String[][] parseParticipantInfo(String info) {
        return parseParticipantInfo(info, ",");
    }

    public static String[][] parseParticipantInfo(String info, String regex) {
        String[] lines = info.split("\n");
        String[][] participantInfoMatrix = new String[lines.length][4];
        for (int i = 0; i < lines.length; i++)
            participantInfoMatrix[i] = lines[i].split(regex);
        return participantInfoMatrix;
    }

    public static boolean isParticipantInfoValid(String[][] participantInfo) {
        if (participantInfo.length != 4)
            return false;
        for (String[] info : participantInfo)
            if (info.length != 4)
                return false;
        return true;
    }
}
