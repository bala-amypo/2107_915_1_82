package com.example.demo.service.impl;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.service.TeamSummaryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamSummaryServiceImpl implements TeamSummaryService {

    private final List<TeamSummaryRecord> list = new ArrayList<>();

    @Override
    public TeamSummaryRecord saveSummary(TeamSummaryRecord record) {
        list.add(record);
        return record;
    }

    @Override
    public List<TeamSummaryRecord> getAllSummaries() {
        return list;
    }
}
