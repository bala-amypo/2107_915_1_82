package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/team-summaries")
public class TeamSummaryController {

    @PostMapping("/generate")
    public String generate() {
        return "summary-generated";
    }

    @GetMapping
    public String list() {
        return "summaries";
    }
}
