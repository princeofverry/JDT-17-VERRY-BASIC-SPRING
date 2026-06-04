package com.indivaragroup.jdt17.spring.dasar.exam.model;

// task 1 membuat class gudang untuk nama dan stock count
public class Warehouse {
    private String wareHouseName;
    private int stockCount;

    public Warehouse(String wareHouseName, int stockCount) {
        this.wareHouseName = wareHouseName;
        this.stockCount = stockCount;
    }

    public String getFactoryName() {
        return wareHouseName;
    }

    public int getStockCount() {
        return stockCount;
    }

    // method pengurangan stok yang bisa dipanggil di Distribution Service : BONUS
    public void reduceInventory(int count) {
        this.stockCount -= count;
    }
}
