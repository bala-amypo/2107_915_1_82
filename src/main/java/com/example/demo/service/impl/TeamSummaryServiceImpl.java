package com.example.demo.service.impl;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.repository.TeamSummaryRecordRepository;
import com.example.demo.service.TeamSummaryService;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeamSummaryServiceImpl implements TeamSummaryService {

    private final TeamSummaryRecordRepository repo;

    public TeamSummaryServiceImpl(TeamSummaryRecordRepository repo) {
        this.repo = repo;
    }

    public TeamSummaryRecord saveSummary(TeamSummaryRecord record) {
        return repo.save(record);
    }

    public List<TeamSummaryRecord> getAllSummaries() {
        return repo.findAll();
    }
}
