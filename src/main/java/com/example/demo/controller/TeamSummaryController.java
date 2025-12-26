package com.example.demo.controller;

import com.example.demo.model.TeamSummaryRecord;
import com.example.demo.service.TeamSummaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team-summary")
public class TeamSummaryController {

    private final TeamSummaryService service;

    public TeamSummaryController(TeamSummaryService service) {
        this.service = service;
    }

    @PostMapping
    public TeamSummaryRecord save(@RequestBody TeamSummaryRecord record) {
        return service.saveSummary(record);
    }

    @GetMapping
    public List<TeamSummaryRecord> getAll() {
        return service.getAllSummaries();
    }
}
