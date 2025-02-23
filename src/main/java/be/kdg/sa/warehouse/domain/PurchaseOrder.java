package be.kdg.sa.warehouse.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID referenceUUID;

    private String poNumber  ;

    @ManyToOne
    private CustomerParty customerParty;

    @ManyToOne
    private SellerParty sellerParty;

    private String vesselNumber;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL)
    private List<OrderLine> orderLines = new ArrayList<>();

    public PurchaseOrder() {
    }

    public UUID getReferenceUUID() {
        return referenceUUID;
    }

    public void setReferenceUUID(UUID referenceUUID) {
        this.referenceUUID = referenceUUID;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public CustomerParty getCustomerParty() {
        return customerParty;
    }

    public void setCustomerParty(CustomerParty customerParty) {
        this.customerParty = customerParty;
    }

    public SellerParty getSellerParty() {
        return sellerParty;
    }

    public String getVesselNumber() {
        return vesselNumber;
    }

    public void setVesselNumber(String vesselNumber) {
        this.vesselNumber = vesselNumber;
    }

    public void setSellerParty(SellerParty sellerParty) {
        this.sellerParty = sellerParty;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void addOrderLine(OrderLine orderLine){
        orderLines.add(orderLine);
        orderLine.setPurchaseOrder(this);
    }
}
