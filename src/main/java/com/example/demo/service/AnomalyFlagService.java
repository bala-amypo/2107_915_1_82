package com.example.demo.service;

import com.example.demo.model.AnomalyFlagRecord;
import java.util.List;

public interface AnomalyFlagService {

    AnomalyFlagRecord flagAnomaly(AnomalyFlagRecord r);

    AnomalyFlagRecord resolveAnomaly(Long id);

    List<AnomalyFlagRecord> getAllFlags();
}
