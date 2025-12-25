package com.example.demo.service.impl;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.service.AnomalyFlagService;
import java.util.List;

public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    public AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord r) { return r; }
    public AnomalyFlagRecord resolveFlag(Long id) { return new AnomalyFlagRecord(); }
    public List<AnomalyFlagRecord> getAll() { return List.of(); }
}
