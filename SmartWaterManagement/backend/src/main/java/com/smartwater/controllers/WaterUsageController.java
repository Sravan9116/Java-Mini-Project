package com.smartwater.controllers;

import com.smartwater.models.WaterUsage;
import com.smartwater.services.WaterUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/water")
@CrossOrigin(origins = "*")
public class WaterUsageController {
    @Autowired
    private WaterUsageService service;

    @GetMapping("/usage")
    public List<WaterUsage> getAllWaterUsage() {
        return service.getAllWaterUsage();
    }

    @PostMapping("/usage")
    public WaterUsage addWaterUsage(@RequestBody WaterUsage waterUsage) {
        return service.addWaterUsage(waterUsage);
    }
}
