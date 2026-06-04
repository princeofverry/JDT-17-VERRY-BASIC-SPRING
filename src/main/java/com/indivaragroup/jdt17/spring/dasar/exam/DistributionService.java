package com.indivaragroup.jdt17.spring.dasar.exam;

import com.indivaragroup.jdt17.spring.dasar.exam.model.Factory;
import com.indivaragroup.jdt17.spring.dasar.exam.service.Sales;
import org.springframework.beans.factory.annotation.Qualifier;

public class DistributionService {
    private final Factory factory;

    private final Sales motor1;
    private final Sales motor2;
    private final Sales motor3;
    private final Sales mobil1;
    private final Sales mobil2;

    // inject 1 gudang sama kelima salesnya
    public DistributionService(
            Factory factory,
            @Qualifier("motor1") Sales motor1,
            @Qualifier("motor2") Sales motor2,
            @Qualifier("motor3") Sales motor3,
            @Qualifier("mobil1") Sales mobil1,
            @Qualifier("mobil2") Sales mobil2
    )
    {
        this.factory = factory;
        this.motor1 = motor1;
        this.motor2 = motor2;
        this.motor3 = motor3;
        this.mobil1 = mobil1;
        this.mobil2 = mobil2;
    }

    public void stockDistribution() {
        printDistribution(motor1);
        printDistribution(motor2);
        printDistribution(motor3);
        printDistribution(mobil1);
        printDistribution(mobil2);
    }

    private void printDistribution(Sales sales) {
        // pengurangan inventory
        factory.reduceInventory(50);

        System.out.println(
                "[DISTRIBUSI] Sales: " + sales.getName()
                        + " | Wilayah: " + sales.getArea()
                        + " | Kendaraan: " + sales.getTypeVehicle()
                        + " | Gudang: " + factory.getFactoryName()
                        + " (stok: " + factory.getStockCount() + ")"
        );
    }
}
