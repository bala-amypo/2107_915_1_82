package com.example.demo.service;

import com.example.demo.model.AnomalyFlagRecord;
import java.util.List;

public interface AnomalyFlagService {

    List<AnomalyFlagRecord> getAllFlags();

    AnomalyFlagRecord resolveFlag(Long id);
}
