package com.example.demo.service.impl;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.repository.AnomalyFlagRecordRepository;
import com.example.demo.service.AnomalyFlagService;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    private final AnomalyFlagRecordRepository repo;

    public AnomalyFlagServiceImpl(AnomalyFlagRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord r) {
        return repo.save(r);
    }

    @Override
    public AnomalyFlagRecord resolveAnomaly(Long id) {
        AnomalyFlagRecord f = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Flag not found"));
        f.setResolved(true);
        return repo.save(f);
    }

    @Override
    public List<AnomalyFlagRecord> getAllFlags() {
        return repo.findAll();
    }
}
