package be.kdg.sa.warehouse.service;

import be.kdg.sa.warehouse.controller.dto.OrderLineDto;
import be.kdg.sa.warehouse.controller.dto.PurchaseOrderDto;
import be.kdg.sa.warehouse.domain.CustomerParty;
import be.kdg.sa.warehouse.domain.OrderLine;
import be.kdg.sa.warehouse.domain.PurchaseOrder;
import be.kdg.sa.warehouse.domain.SellerParty;
import be.kdg.sa.warehouse.repository.CustomerPartyRepository;
import be.kdg.sa.warehouse.repository.MaterialRepository;
import be.kdg.sa.warehouse.repository.PurchaseOrderRepository;
import be.kdg.sa.warehouse.repository.SellerPartyRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final CustomerPartyRepository customerPartyRepository;
    private final SellerPartyRepository sellerPartyRepository;
    private final MaterialRepository materialRepository;

    public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository, CustomerPartyRepository customerPartyRepository, SellerPartyRepository sellerPartyRepository, MaterialRepository materialRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.customerPartyRepository = customerPartyRepository;
        this.sellerPartyRepository = sellerPartyRepository;
        this.materialRepository = materialRepository;
    }

    public PurchaseOrderDto createPurchaseOrder(PurchaseOrderDto purchaseOrderDto){
        CustomerParty customerParty = customerPartyRepository.findById(purchaseOrderDto.customerParty().id())
                .orElseThrow(() -> new IllegalArgumentException("Customer party not found"));
        SellerParty sellerParty = sellerPartyRepository.findById(purchaseOrderDto.sellerParty().id())
                .orElseThrow(() -> new IllegalArgumentException("Seller party not found"));

        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setPoNumber(purchaseOrderDto.poNumber());
        purchaseOrder.setReferenceUUID(purchaseOrderDto.referenceUUID());
        purchaseOrder.setCustomerParty(customerParty);
        purchaseOrder.setSellerParty(sellerParty);
        purchaseOrder.setVesselNumber(purchaseOrderDto.vesselNumber());

        for(OrderLineDto orderLineDto : purchaseOrderDto.orderLines()){
            OrderLine orderLine = new OrderLine();
            orderLine.setMaterial(materialRepository.findByType(orderLineDto.materialType()));
            orderLine.setDescription(orderLineDto.description());
            orderLine.setQuantity(orderLineDto.quantity());
            orderLine.setUom(orderLineDto.uom());
            purchaseOrder.addOrderLine(orderLine);
        }
        purchaseOrderRepository.save(purchaseOrder);
        return new PurchaseOrderDto(purchaseOrder);
    }

    public PurchaseOrder getPurchaseOrderById(UUID referenceUUID){
        return purchaseOrderRepository.findByReferenceUUID(referenceUUID);
    }
}
