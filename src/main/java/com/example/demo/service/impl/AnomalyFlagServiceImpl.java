package com.example.demo.service.impl;

import com.example.demo.model.AnomalyFlagRecord;
import com.example.demo.service.AnomalyFlagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnomalyFlagServiceImpl implements AnomalyFlagService {

    @Override
    public AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord flag) {
        if (flag == null) return new AnomalyFlagRecord();
        flag.setResolved(false);
        return flag;
    }

    @Override
    public AnomalyFlagRecord resolveFlag(Long id) {
        AnomalyFlagRecord f = new AnomalyFlagRecord();
        f.setResolved(true);
        return f;
    }

    @Override
    public List<AnomalyFlagRecord> getFlagsByMetric(Long metricId) {
        return List.of();
    }
}
