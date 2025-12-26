package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.repository.TeamSummaryRepository;
import com.example.demo.service.TeamSummaryService;

@Service
public class TeamSummaryServiceImpl implements TeamSummaryService {

    private final TeamSummaryRepository repo;

    public TeamSummaryServiceImpl(TeamSummaryRepository repo) {
        this.repo = repo;
    }

    public TeamSummaryRecord saveSummary(TeamSummaryRecord record) {
        return repo.save(record);
    }

    public List<TeamSummaryRecord> getAllSummaries() {
        return repo.findAll();
    }
}
