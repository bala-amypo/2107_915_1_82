package com.example.demo.service;

import com.example.demo.model.TeamSummaryRecord;
import java.util.List;

public interface TeamSummaryService {

    TeamSummaryRecord saveSummary(TeamSummaryRecord record);

    List<TeamSummaryRecord> getAllSummaries();
}
