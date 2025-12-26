package com.example.demo.service.impl;

import com.example.demo.model.AnomalyRule;
import com.example.demo.service.AnomalyRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnomalyRuleServiceImpl implements AnomalyRuleService {

    @Override
    public AnomalyRule createRule(AnomalyRule rule) {
        return rule == null ? new AnomalyRule() : rule;
    }

    @Override
    public List<AnomalyRule> getActiveRules() {
        return List.of();
    }
}
