package com.example.demo.service;

import java.util.List;
import com.example.demo.model.TeamSummaryRecord;

public interface TeamSummaryService {
    TeamSummaryRecord saveSummary(TeamSummaryRecord record);
    List<TeamSummaryRecord> getAllSummaries();
}
