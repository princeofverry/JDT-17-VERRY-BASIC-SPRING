package com.indivaragroup.jdt17.spring.dasar.exam.model;

public class Factory {
    private String factoryName;
    private int stockCount;

    public Factory(String factoryName, int stockCount) {
        this.factoryName = factoryName;
        this.stockCount = stockCount;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void reduceInventory(int count) {
        this.stockCount -= count;
    }
}
