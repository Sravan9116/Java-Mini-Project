package com.smartwater.services;

import com.smartwater.models.WaterUsage;
import com.smartwater.repository.WaterUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WaterUsageService {
    @Autowired
    private WaterUsageRepository repository;

    public List<WaterUsage> getAllWaterUsage() {
        return repository.findAll();
    }

    public WaterUsage addWaterUsage(WaterUsage waterUsage) {
        return repository.save(waterUsage);
    }
}
