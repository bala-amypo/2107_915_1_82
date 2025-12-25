package com.example.demo.util;

import com.example.demo.model.TeamSummaryRecord;

public class TeamSummaryUtil {

    private TeamSummaryUtil() {}

    public static TeamSummaryRecord build(String teamName, int employees, double productivity) {
        return new TeamSummaryRecord(teamName, employees, productivity);
    }
}
