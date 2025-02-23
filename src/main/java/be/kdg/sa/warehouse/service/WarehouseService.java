package be.kdg.sa.warehouse.service;

import be.kdg.sa.warehouse.domain.Warehouse;
import be.kdg.sa.warehouse.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Warehouse getWarehouseById(UUID id) {
        return warehouseRepository.findById(id).orElse(null);
    }
}
