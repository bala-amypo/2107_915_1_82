package com.example.demo.service;

import com.example.demo.model.AnomalyFlagRecord;
import java.util.List;

public interface AnomalyFlagService {
    AnomalyFlagRecord create(AnomalyFlagRecord a);
    List<AnomalyFlagRecord> getAll();
}
