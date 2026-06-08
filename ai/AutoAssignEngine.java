package com.project.ai;

public class AutoAssignEngine {

    public static String assignTeam(
            String category) {

        if(category.equalsIgnoreCase(
                "Network")) {

            return "Network Team";
        }

        if(category.equalsIgnoreCase(
                "Hardware")) {

            return "Hardware Team";
        }

        if(category.equalsIgnoreCase(
                "Email")) {

            return "Email Support Team";
        }

        if(category.equalsIgnoreCase(
                "Performance")) {

            return "Performance Team";
        }

        return "Help Desk Team";
    }
}