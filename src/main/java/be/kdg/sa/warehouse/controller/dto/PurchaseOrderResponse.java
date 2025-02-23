package be.kdg.sa.warehouse.controller.dto;

public class PurchaseOrderResponse {
    private PurchaseOrderDto purchaseOrder;

    public PurchaseOrderResponse() {
    }

    public PurchaseOrderResponse(PurchaseOrderDto purchaseOrderDto) {
        this.purchaseOrder = purchaseOrderDto;
    }

    public PurchaseOrderDto getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrderDto purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
