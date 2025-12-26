package com.example.demo.service.impl;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.service.AnomalyFlagService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    private final List<AnomalyFlagRecord> flags = new ArrayList<>();

    @Override
    public AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord record) {
        flags.add(record);
        return record;
    }

    @Override
    public AnomalyFlagRecord resolveFlag(Long id) {
        AnomalyFlagRecord r = new AnomalyFlagRecord();
        r.setResolved(true);
        return r;
    }

    @Override
    public List<AnomalyFlagRecord> getFlagsByMetric(Long metricId) {
        return flags;
    }
}
