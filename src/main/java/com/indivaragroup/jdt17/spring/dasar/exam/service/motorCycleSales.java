package com.indivaragroup.jdt17.spring.dasar.exam.service;

public class motorCycleSales implements Sales {
    private final String name;
    private final String area;

    public motorCycleSales(String name, String area) {
        this.name = name;
        this.area = area;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getArea() {
        return area;
    }
    @Override
    public String getTypeVehicle() {
        return "Motorcycle";
    }
}
