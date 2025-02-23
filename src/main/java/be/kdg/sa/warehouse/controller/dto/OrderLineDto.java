package be.kdg.sa.warehouse.controller.dto;

import be.kdg.sa.warehouse.domain.OrderLine;

public record OrderLineDto(int lineNumber, String materialType, String description, int quantity, String uom) {
    public OrderLineDto(OrderLine orderLine) {
        this(
                orderLine.getLineNumber(),
                orderLine.getMaterial().getType(),
                orderLine.getDescription(),
                orderLine.getQuantity(),
                orderLine.getUom()
        );
    }
}