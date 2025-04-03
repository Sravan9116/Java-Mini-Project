package com.smartwater.repository;

import com.smartwater.models.WaterUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterUsageRepository extends JpaRepository<WaterUsage, Long> {
}
