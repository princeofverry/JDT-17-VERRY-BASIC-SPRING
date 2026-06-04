package com.indivaragroup.jdt17.spring.dasar.exam.model;

// task 1 membuat class gudang untuk nama dan stock count
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

    // method pengurangan stok yang bisa dipanggil di Distribution Service : BONUS
    public void reduceInventory(int count) {
        this.stockCount -= count;
    }
}
