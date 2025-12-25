package com.example.demo.repository;

import com.example.demo.model.TeamSummaryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamSummaryRepository
        extends JpaRepository<TeamSummaryRecord, Long> {
}
