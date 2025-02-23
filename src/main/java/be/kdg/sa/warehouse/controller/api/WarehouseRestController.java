package be.kdg.sa.warehouse.controller.api;

import be.kdg.sa.warehouse.controller.dto.PurchaseOrderDto;
import be.kdg.sa.warehouse.controller.dto.PurchaseOrderResponse;
import be.kdg.sa.warehouse.domain.PurchaseOrder;
import be.kdg.sa.warehouse.domain.Warehouse;
import be.kdg.sa.warehouse.service.PurchaseOrderService;
import be.kdg.sa.warehouse.service.WarehouseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseRestController {

    private final PurchaseOrderService purchaseOrderService;
    private final WarehouseService warehouseService;

    public WarehouseRestController(PurchaseOrderService purchaseOrderService, WarehouseService warehouseService) {
        this.purchaseOrderService = purchaseOrderService;
        this.warehouseService = warehouseService;
    }

    @GetMapping("")
    public List<Warehouse> getAllWarehouses() {

        return warehouseService.getAllWarehouses();
    }

    @GetMapping("/{warehouseId}")
    public Warehouse getWarehouseById(@PathVariable("warehouseId") UUID warehouseId) {
        return warehouseService.getWarehouseById(warehouseId);
    }

    @PostMapping("/purchaseOrders")
    public ResponseEntity<PurchaseOrderResponse> createPurchaseOrder(@Valid @RequestBody PurchaseOrderResponse response) {
        PurchaseOrderDto purchaseOrderDto = response.getPurchaseOrder();
        if (purchaseOrderDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        try {
            PurchaseOrderDto createdPurchaseOrder = purchaseOrderService.createPurchaseOrder(purchaseOrderDto);
            return new ResponseEntity<>(new PurchaseOrderResponse(createdPurchaseOrder), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
