package be.kdg.sa.warehouse.repository;

import be.kdg.sa.warehouse.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MaterialRepository extends JpaRepository<Material, UUID> {
    List<Material> findMaterialsByWarehouseId(UUID warehouseId);
    Material findByType(String type);
}
