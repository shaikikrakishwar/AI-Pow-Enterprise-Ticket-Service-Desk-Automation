package com.project.ai;

public class ResolutionEngine {

    public static String getSuggestion(String description) {

        description = description.toLowerCase();

        if(description.contains("wifi")) {

            return "Restart WiFi adapter, reconnect network and verify router connectivity.";
        }

        if(description.contains("printer")) {

            return "Check printer power, cable connection and restart print spooler service.";
        }

        if(description.contains("server")) {

            return "Check server health, CPU usage, memory usage and restart affected services.";
        }

        if(description.contains("password")) {

            return "Reset password using account recovery process.";
        }

        return "Please contact the IT Help Desk for further assistance.";
    }
}