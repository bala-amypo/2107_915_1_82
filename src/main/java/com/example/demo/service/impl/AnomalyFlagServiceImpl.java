package com.example.demo.service.impl;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.service.AnomalyFlagService;
import java.util.ArrayList;
import java.util.List;

public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    @Override
    public AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord record) {
        return record;
    }

    @Override
    public AnomalyFlagRecord resolveFlag(Long id) {
        AnomalyFlagRecord f = new AnomalyFlagRecord();
        f.setResolved(true);
        return f;
    }

    @Override
    public List<AnomalyFlagRecord> getAll() {
        return new ArrayList<>();
    }
}
