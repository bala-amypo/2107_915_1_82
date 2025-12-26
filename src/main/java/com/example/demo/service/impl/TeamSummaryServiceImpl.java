package com.example.demo.service.impl;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.repository.AnomalyFlagRecordRepository;
import com.example.demo.service.AnomalyFlagService;
import org.springframework.stereotype.Service;

import java.util.List;

@RestController
@RequestMapping("/api/team-summary")
public class TeamSummaryController {

    private final TeamSummaryService service;

    public TeamSummaryController(TeamSummaryService service) {
        this.service = service;
    }

    @PostMapping
    public TeamSummaryRecord save(@RequestBody TeamSummaryRecord r) {
        return service.saveSummary(r);
    }

    @GetMapping
    public List<TeamSummaryRecord> all() {
        return service.getAllSummaries();
    }
}
