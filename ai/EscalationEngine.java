package com.project.ai;

public class EscalationEngine {

    public static String checkEscalation(
            String priority,
            String status) {

        if("HIGH".equalsIgnoreCase(priority)
                &&
           "OPEN".equalsIgnoreCase(status)) {

            return "YES";
        }

        return "NO";
    }
}