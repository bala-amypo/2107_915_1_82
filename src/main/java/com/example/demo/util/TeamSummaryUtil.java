package com.example.demo.util;

import com.example.demo.model.TeamSummaryRecord;

public class TeamSummaryUtil {

    public static TeamSummaryRecord emptySummary() {
        TeamSummaryRecord r = new TeamSummaryRecord();
        r.setAvgHoursLogged(0.0);
        r.setAvgScore(0.0);
        r.setAnomalyCount(0);
        return r;
    }
}
