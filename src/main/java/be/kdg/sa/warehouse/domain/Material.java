package be.kdg.sa.warehouse.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;
    private int storagePricePerTonPerDay;
    private int sellingPricePerTon;
    private String type;

    @ManyToOne
    private Warehouse warehouse;

    protected Material() {
    }

    public Material(String name, String description, int storagePricePerTonPerDay, int sellingPricePerTon, String type) {
        this.name = name;
        this.description = description;
        this.storagePricePerTonPerDay = storagePricePerTonPerDay;
        this.sellingPricePerTon = sellingPricePerTon;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStoragePricePerTonPerDay() {
        return storagePricePerTonPerDay;
    }

    public void setStoragePricePerTonPerDay(int storagePricePerTonPerDay) {
        this.storagePricePerTonPerDay = storagePricePerTonPerDay;
    }

    public int getSellingPricePerTon() {
        return sellingPricePerTon;
    }

    public void setSellingPricePerTon(int sellingPricePerTon) {
        this.sellingPricePerTon = sellingPricePerTon;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
