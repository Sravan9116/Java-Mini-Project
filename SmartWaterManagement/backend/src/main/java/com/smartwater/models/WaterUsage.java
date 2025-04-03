package com.smartwater.models;

import jakarta.persistence.*;

@Entity
@Table(name = "water_usage")
public class WaterUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private Double waterConsumed; // in liters
    private String timestamp;

    public WaterUsage() {}

    public WaterUsage(String location, Double waterConsumed, String timestamp) {
        this.location = location;
        this.waterConsumed = waterConsumed;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public Double getWaterConsumed() { return waterConsumed; }
    public void setWaterConsumed(Double waterConsumed) { this.waterConsumed = waterConsumed; }
    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}
