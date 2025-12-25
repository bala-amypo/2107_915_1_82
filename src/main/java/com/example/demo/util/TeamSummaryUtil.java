package com.example.demo.util;

import com.example.demo.model.TeamSummaryRecord;

public class TeamSummaryUtil {

    public static TeamSummaryRecord buildSummary(
            String teamName, int totalEmployees, double avgProductivity) {

        TeamSummaryRecord record = new TeamSummaryRecord();
        record.setTeamName(teamName);
        record.setTotalEmployees(totalEmployees);
        record.setAverageProductivity(avgProductivity);

        return record;
    }
}
