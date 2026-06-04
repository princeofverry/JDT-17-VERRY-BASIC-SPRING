package com.indivaragroup.jdt17.spring.dasar.exam.service;

public class carSales implements Sales{
    private final String name;
    private final String area;

    public carSales(String name, String area) {
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
        return "Car";
    }
}
