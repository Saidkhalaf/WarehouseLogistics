package be.kdg.sa.warehouse.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int capacity;
    private int overflowPercentage;
    private int currentAmountStored;

    @OneToOne
    private Material material;
    @ManyToOne
    @JoinColumn(name = "seller_party_id")
    private SellerParty sellerParty;

    @OneToMany(mappedBy = "warehouse")
    private List<Material> materials;

    protected Warehouse() {}

    public UUID getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getOverflowPercentage() {
        return overflowPercentage;
    }

    public int getCurrentAmountStored() {
        return currentAmountStored;
    }

    public Material getMaterial() {
        return material;
    }
}
