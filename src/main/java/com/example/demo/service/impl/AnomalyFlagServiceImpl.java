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

    public AnomalyFlagRecord create(AnomalyFlagRecord a) {
        return repo.save(a);
    }

    public List<AnomalyFlagRecord> getAll() {
        return repo.findAll();
    }
}
