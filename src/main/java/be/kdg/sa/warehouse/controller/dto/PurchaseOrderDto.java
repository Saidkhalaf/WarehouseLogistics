package be.kdg.sa.warehouse.controller.dto;

import be.kdg.sa.warehouse.domain.PurchaseOrder;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public record PurchaseOrderDto (
                                @NotNull String poNumber,
                                @NotNull UUID referenceUUID,
                                @NotNull CustomerPartyDto customerParty,
                                @NotNull SellerPartyDto sellerParty,
                                @NotNull String vesselNumber,
                                @NotNull @Size(min = 1) List<OrderLineDto> orderLines) {

    public PurchaseOrderDto(PurchaseOrder purchaseOrder) {
            this(
                    purchaseOrder.getPoNumber(),
                    purchaseOrder.getReferenceUUID(),
                    new CustomerPartyDto(purchaseOrder.getCustomerParty()),
                    new SellerPartyDto(purchaseOrder.getSellerParty()),
                    purchaseOrder.getVesselNumber(),
                    purchaseOrder.getOrderLines().stream()
                            .map(OrderLineDto::new)
                            .toList()
            );
        }
}
