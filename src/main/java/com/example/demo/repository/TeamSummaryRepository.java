package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.TeamSummaryRecord;

public interface TeamSummaryRepository
        extends JpaRepository<TeamSummaryRecord, Long> {
}
