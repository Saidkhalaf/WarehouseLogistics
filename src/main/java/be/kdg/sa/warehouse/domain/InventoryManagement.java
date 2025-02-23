package be.kdg.sa.warehouse.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class InventoryManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Warehouse warehouse;

//    @OneToMany(mappedBy = "inventoryManagement")
//    private List<PurchaseOrder> purchaseOrder;
}

