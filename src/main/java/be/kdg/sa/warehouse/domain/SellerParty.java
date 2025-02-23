package be.kdg.sa.warehouse.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class SellerParty {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "sellerParty")
    private List<Warehouse> warehouse;

    @OneToMany(mappedBy = "sellerParty")
    private List<PurchaseOrder> purchaseOrders;

    protected SellerParty() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Warehouse> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(List<Warehouse> warehouse) {
        this.warehouse = warehouse;
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }
}
