package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.TeamSummaryService;
import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.repository.TeamSummaryRepository;
import java.util.List;

@Service
public class TeamSummaryServiceImpl implements TeamSummaryService {

    private final TeamSummaryRepository repo;

    public TeamSummaryServiceImpl(TeamSummaryRepository repo) {
        this.repo = repo;
    }

    public TeamSummaryRecord saveSummary(TeamSummaryRecord r) {
        return r;
    }

    public List<TeamSummaryRecord> getAllSummaries() {
        return List.of();
    }
}
