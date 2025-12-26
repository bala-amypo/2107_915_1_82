package com.example.demo.service.impl;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.repository.TeamSummaryRepository;
import com.example.demo.service.TeamSummaryService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TeamSummaryServiceImpl implements TeamSummaryService {

    @Autowired
    private TeamSummaryRepository repo;

    @Override
    public TeamSummaryRecord saveSummary(TeamSummaryRecord record) {
        return repo.save(record);
    }

    @Override
    public List<TeamSummaryRecord> getAllSummaries() {
        return repo.findAll();
    }
}
