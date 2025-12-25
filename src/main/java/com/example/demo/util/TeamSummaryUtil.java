package com.example.demo.util;

import com.example.demo.model.TeamSummaryRecord;

public class TeamSummaryUtil {

    public static TeamSummaryRecord buildSummary(
            String teamName,
            int totalEmployees,
            double avgProductivity
    ) {
        // ✅ Uses constructor expected by tests
        return new TeamSummaryRecord(teamName, totalEmployees, avgProductivity);
    }
}
