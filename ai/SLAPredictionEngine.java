package com.project.ai;

public class SLAPredictionEngine {

    public static String predictSLA(
            String priority) {

        if(priority == null) {

            return "ON_TRACK";
        }

        if(priority.equalsIgnoreCase(
                "HIGH")) {

            return "AT_RISK";
        }

        return "ON_TRACK";
    }
}