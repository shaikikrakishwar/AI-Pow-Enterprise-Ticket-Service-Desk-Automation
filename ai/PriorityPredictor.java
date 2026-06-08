package com.project.ai;

public class PriorityPredictor {

    public static String predictPriority(
            String title,
            String description) {

        String text =
                (title + " " + description)
                .toLowerCase();

        if(text.contains("server")
                || text.contains("critical")
                || text.contains("down")
                || text.contains("production")) {

            return "HIGH";
        }

        if(text.contains("slow")
                || text.contains("performance")
                || text.contains("wifi")
                || text.contains("network")) {

            return "MEDIUM";
        }

        return "LOW";
    }
}