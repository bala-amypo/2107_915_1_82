package com.example.demo.service.impl;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.repository.TeamSummaryRepository;
import com.example.demo.service.TeamSummaryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamSummaryServiceImpl implements TeamSummaryService {

    private final TeamSummaryRepository repository;

    public TeamSummaryServiceImpl(TeamSummaryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TeamSummaryRecord> getAllSummaries() {
        return repository.findAll();
    }
}
