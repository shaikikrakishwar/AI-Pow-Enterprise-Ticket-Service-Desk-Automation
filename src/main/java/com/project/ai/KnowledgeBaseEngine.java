package com.project.ai;

public class KnowledgeBaseEngine {

    public static String getSolution(
            String description) {

        String text =
                description.toLowerCase();

        if(text.contains("printer")) {

            return "1. Check printer power. "
                 + "2. Verify cable connection. "
                 + "3. Restart printer.";
        }

        if(text.contains("password")) {

            return "1. Use Forgot Password. "
                 + "2. Check registered email. "
                 + "3. Reset credentials.";
        }

        if(text.contains("network")
                || text.contains("wifi")) {

            return "1. Restart router. "
                 + "2. Check network cable. "
                 + "3. Verify IP settings.";
        }

        if(text.contains("email")) {

            return "1. Verify mailbox quota. "
                 + "2. Check email settings. "
                 + "3. Re-login to account.";
        }

        return "Please contact Help Desk Team for further assistance.";
    }
}