package com.project.ai;

public class TicketCategorizer {

    public static String predictCategory(
            String title,
            String description) {

        String text =
                (title + " " + description)
                .toLowerCase();

        if(text.contains("wifi")
                || text.contains("network")
                || text.contains("vpn")) {

            return "Network";
        }

        if(text.contains("email")
                || text.contains("outlook")) {

            return "Email";
        }

        if(text.contains("printer")) {

            return "Hardware";
        }

        if(text.contains("slow")
                || text.contains("performance")
                || text.contains("lag")) {

            return "Performance";
        }

        return "General";
    }
}